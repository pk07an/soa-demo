package com.meila.soa.product.service.innerservice.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.meila.common.exceptions.ServiceException;
import com.meila.meigou.cachehelper.MeilaCacheType;
import com.meila.meigou.cachehelper.MeilaCacheUtils;
import com.meila.meigou.cachehelper.RedisAdapter;
import com.meila.soa.meila.client.model.OmsJsonResult;
import com.meila.soa.meila.client.model.UserDto;
import com.meila.soa.meila.client.service.MeiLaOmsClient;
import com.meila.soa.product.api.constant.ProductReturnCode;
import com.meila.soa.product.dal.dao.product.ProductInfoMapper;
import com.meila.soa.product.dal.dao.shop.ShopExtMapper;
import com.meila.soa.product.dal.dao.shop.ShopMapper;
import com.meila.soa.product.dal.entity.product.Product;
import com.meila.soa.product.dal.entity.shop.Shop;
import com.meila.soa.product.dal.entity.shop.ShopAdmin;
import com.meila.soa.product.dal.entity.shop.ShopExt;
import com.meila.soa.product.dal.entity.shop.ShopExtExample;
import com.meila.soa.product.dal.entity.user.User;
import com.meila.soa.product.dal.mybatis.IdTypeHandler;
import com.meila.soa.product.dal.type.DeliveryType;
import com.meila.soa.product.dal.type.ShopStatus;
import com.meila.soa.product.service.innerservice.ProductService;
import com.meila.soa.product.service.innerservice.ShopService;
import com.meila.soa.product.service.innerservice.UserService;
import com.meila.soa.product.service.model.ShopModel;

@Service("shopService")
public class ShopServiceImpl implements ShopService {

    @Resource
    private ShopMapper shopMapper;

    @Resource
    private ShopExtMapper shopExtMapper;

    @Resource
    private UserService userService;

    @Resource
    private MeiLaOmsClient meiLaOmsClient;

    @Autowired
    private MeilaCacheUtils cacheUtils;

    @Resource
    private ProductService productService;

    @Resource
    ProductInfoMapper productInfoMapper;

    @Autowired
    private RedisAdapter redisAdapter;

    @Override
    public ShopModel loadShopAndExt(Long shopId) {

        Shop shop = shopMapper.selectByPrimaryKey(shopId);
        if (null == shop) {
            return null;
        }

        ShopModel vo = new ShopModel();
        vo.setShopEntity(shop);
        ShopExtExample example = new ShopExtExample();
        example.createCriteria().andShopIdEqualTo(shopId);
        List<ShopExt> extList = shopExtMapper.selectByExample(example);
        if (null != extList && extList.size() > 0) {
            vo.setShopExtEntity(extList.get(0));
        }
        return vo;
    }

    @Override
    public Shop load(Long id) {
        return shopMapper.selectByPrimaryKey(id);
    }

    @Override
    public Shop createByAdmin(Shop shop) {
        Shop existShop = shopMapper.selectByUserId(shop.getOwnerId());
        if (existShop == null) {

            Shop chkShop = findByName(shop.getName());
            if (chkShop != null) {
                throw new ServiceException(ProductReturnCode.SHOP_NAME_EXIST, "店铺名字不能重名 shopName=[" + shop.getName() + "]");
            }

            boolean flag = true;
            String code = "";
            while (flag) {
                code = geneteCode();
                if (code.length() == 8 && shopMapper.countByCode(code) == 0) {
                    flag = false;
                }
            }
            shop.setCode(code);
            shop.setArchive(false);
            shop.setCreatedAt(new Date(System.currentTimeMillis()));
            shop.setUpdatedAt(new Date(System.currentTimeMillis()));
            shopMapper.insert(shop);

            User userUpdate = new User();
            userUpdate.setId(shop.getOwnerId());
            userUpdate.setShopId(shop.getId());
            userService.updateByAdmin(userUpdate);

            this.syncSellerToOMS(shop, "create", null);
        } else {
            shop = existShop;
        }

        return shop;
    }

    /**
     * 加入code，code生成规则:当前时期戳去除前2位和后三位 by reese
     *
     * @return
     */
    private String geneteCode() {
        Long seconds = System.currentTimeMillis();
        String code = seconds.toString();
        code = code.substring(2, code.length() - 3);
        return IdTypeHandler.encode(Long.parseLong(code));
    }

    @Override
    public Shop findByName(String shopName) {
        return shopMapper.selectByShopName(shopName);
    }

    /**
     * 调用OMS卖家信息修改同步的API
     * 
     * @param shop 店铺信息
     * @param shopExt TODO
     * @return {返回参数名} {返回参数说明}
     * @exception {说明在某情况下,将发生什么异常}
     */
    public void syncSellerToOMS(Shop shop, String opeType, ShopExt shopExt) {
        // NEO 调用OMS卖家信息修改同步的API（开店） T8、BOS-开店信息同步WMS
        UserDto userDto = new UserDto();

        userDto.setUserId(shop.getOwnerId());

        User user = userService.load(shop.getOwnerId());
        userDto.setName(user.getName());
        userDto.setRemindAmount("1");
        userDto.setOpenSkuRemind(0);

        if (opeType.equals("create")) {
            userDto.setArchive(0);
        }

        if (opeType.equals("freeze") || opeType.equals("unfreeze")) {
            ShopExtExample example = new ShopExtExample();
            example.createCriteria().andShopIdEqualTo(shop.getId());
            List<ShopExt> extList = shopExtMapper.selectByExample(example);

            if (opeType.equals("freeze")) {
                userDto.setArchive(1);
            }

            if (opeType.equals("unfreeze")) {
                userDto.setArchive(0);
            }

            if (CollectionUtils.isNotEmpty(extList)) {
                ShopExt ext = extList.get(0);

                userDto.setDeliveryType(ext.getDeliveryType().name());
                userDto.setDesc(shop.getDescription());
                userDto.setPhone(ext.getPhone());
            }
        }

        if (opeType.equals("modify")) {
            userDto.setArchive(shop.getStatus().equals(ShopStatus.ACTIVE) ? 0 : 1);

            userDto.setDeliveryType(shopExt.getDeliveryType().name());
            userDto.setDesc(shop.getDescription());
            userDto.setPhone(shopExt.getPhone());
        }

        this.syncSellerToOMS(userDto);
    }

    /**
     * 调用OMS卖家信息修改同步的API
     * 
     * @param shop 店铺信息
     * @return {返回参数名} {返回参数说明}
     * @exception {说明在某情况下,将发生什么异常}
     */
    public void syncSellerToOMS(UserDto userDto) {
        // logger.debug("syncSellerToOMS [userId]{},[userName]{}", userDto.getUserId(), userDto.getName());
        OmsJsonResult result = meiLaOmsClient.syncSeller(userDto);

        if (result.isFail()) {
            // log.error("调用OMS接口创建/修改店铺失败：" + result.getErrorMsg());
            // NEO 2015年12月7日，暂时不抛异常，原因：12月9日上线部分功能联调WMS
            // throw new BizException(GlobalErrorCode.INTERNAL_ERROR,
            // null == result.getErrorMsg() ? "调用OMS接口创建/修改店铺失败" : result.getErrorMsg());
        }
    }

    @Override
    public int updateShop(Shop shop) {
        int count = shopMapper.updateByPrimaryKeySelective(shop);

        return count;
    }

    @Override
    public int updateShopExt(ShopExt shopExt) {
        int count = shopExtMapper.updateByPrimaryKeySelective(shopExt);

        clearSellerCache(shopExt.getShopId());

        return count;
    }

    private void clearSellerCache(Long shopId) {

        try {
            cacheUtils.del(MeilaCacheType.Seller, String.valueOf(IdTypeHandler.encode(shopId)));
            // log.debug("clear seller cache : " + shopId);
        } catch (Throwable e) {
            e.printStackTrace();
            // log.error("清空卖家缓存失败：", e);
        }

    }

    @Override
    public int insertShopExt(ShopExt shopExt) {
        int count = shopExtMapper.insertAutoKey(shopExt);

        this.clearSellerCache(shopExt.getShopId());

        return count;
    }

    @Override
    public void updateShopAndExt(Shop shop, ShopExt shopExt) {
        shop.setUpdatedAt(new Date(System.currentTimeMillis()));

        this.updateShop(shop);
        Shop oldShop = this.load(shop.getId());
        shop.setOwnerId(oldShop.getOwnerId());
        shop.setStatus(oldShop.getStatus());

        // 没有店铺扩展信息，则创建一个
        if (null != shopExt.getId()) {
            this.updateShopExt(shopExt);
        } else {
            this.insertShopExt(shopExt);
        }

        this.syncSellerToOMS(shop, "modify", shopExt);

        if (StringUtils.isBlank(shop.getSellerSource())) {
            shop.setSellerSource(oldShop.getSellerSource());
        }

        // 如果是外部卖家，则需要将发货类型同步到卖家下的所有商品
        if (StringUtils.equals(shop.getSellerSource(), "OUTSIDE")) {
            if (null == shopExt.getDeliveryType()) {
                return;
            }

            List<Product> productList = productService.selectProductListByShopId(shop.getId());
            if (CollectionUtils.isEmpty(productList)) {
                return;
            }

            List<Long> productIdList = Lists.newArrayList();
            List<String> productCodeList = Lists.newArrayList();
            for (Product product : productList) {
                productIdList.add(product.getId());
                productCodeList.add(MeilaCacheType.Product.getPrefix() + product.getCode());
            }

            String warehouse = "";
            if (shopExt.getDeliveryType().equals(DeliveryType.MEILA)) {
                warehouse = "LOCAL_XILI";
            }

            int count = productInfoMapper.updateDeliveryType(productIdList, shopExt.getDeliveryType().name(), warehouse);

            try {
                // 批量清除商品缓存，注意key要加前缀
                String[] keys = productCodeList.toArray(new String[] {});
                // log.debug("clear product cache batch: " + Arrays.toString(keys));
                redisAdapter.del(keys);
            } catch (Throwable e) {
                e.printStackTrace();
                // log.error("清空商品缓存失败：", e);
            }
        }
    }

    @Override
    public int update(Shop shop) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<ShopAdmin> listShopsByAdmin(Map<String, Object> params, Map<String, Long> pageable) {
        return shopMapper.listShopsByAdmin(params, pageable);

    }

    @Override
    public Long countShopsByAdmin(Map<String, Object> params) {
        return shopMapper.countShopsByAdmin(params);

    }

    @Override
    public List<Shop> selectShopByUserIdList(List<Long> ownerIdList) {
        if (CollectionUtils.isEmpty(ownerIdList)) {
            return null;
        }

        return shopMapper.selectbyUserIdList(ownerIdList);
    }

    @Override
    public List<ShopExt> selectShopExtByUserIdList(List<Long> shopIdList) {
        if (CollectionUtils.isEmpty(shopIdList)) {
            return null;
        }
        return shopExtMapper.selectByShopIds(shopIdList);
    }

}
