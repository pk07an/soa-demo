package com.meila.soa.product.service.dubboservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.meila.common.bean.utils.BeanMapper;
import com.meila.common.collection.utils.Collections3;
import com.meila.common.exceptions.ServiceException;
import com.meila.dubbo.base.model.DubboBasicPageRequest2.DubboSort;
import com.meila.dubbo.base.model.DubboBasicResponse;
import com.meila.soa.meila.client.model.MeilaUser;
import com.meila.soa.meila.client.service.MeilaClient;
import com.meila.soa.product.api.DubboShopService;
import com.meila.soa.product.api.constant.ProductReturnCode;
import com.meila.soa.product.api.model.dto.DubboShop;
import com.meila.soa.product.api.model.dto.DubboShopAdmin;
import com.meila.soa.product.api.model.dto.DubboShopExt;
import com.meila.soa.product.api.model.dto.DubboThirdCommission;
import com.meila.soa.product.api.model.request.DubboAddShopRequest;
import com.meila.soa.product.api.model.request.DubboQueryShopRequest;
import com.meila.soa.product.api.model.request.DubboSearchShopRequest;
import com.meila.soa.product.api.model.request.DubboStatisticsShopInfoRequest;
import com.meila.soa.product.api.model.request.DubboUpdateShopExtRequest;
import com.meila.soa.product.api.model.request.DubboUpdateShopRequest;
import com.meila.soa.product.api.model.request.shop.DubboQueryShopByOwnerIdListRequest;
import com.meila.soa.product.api.model.response.DubboQueryShopResponse;
import com.meila.soa.product.api.model.response.DubboSearchShopResponse;
import com.meila.soa.product.api.model.response.DubboStatisticsShopInfoResponse;
import com.meila.soa.product.dal.dao.product.ProdSyncMapper;
import com.meila.soa.product.dal.dao.shop.ShopMapper;
import com.meila.soa.product.dal.entity.Zone;
import com.meila.soa.product.dal.entity.product.ProdSync;
import com.meila.soa.product.dal.entity.shop.Shop;
import com.meila.soa.product.dal.entity.shop.ShopAdmin;
import com.meila.soa.product.dal.entity.shop.ShopExt;
import com.meila.soa.product.dal.entity.user.User;
import com.meila.soa.product.dal.type.BalanceType;
import com.meila.soa.product.dal.type.DeliveryType;
import com.meila.soa.product.dal.type.ShopStatus;
import com.meila.soa.product.dal.type.SyncAuditStatus;
import com.meila.soa.product.dal.type.UserPartnerType;
import com.meila.soa.product.service.innerservice.ShopService;
import com.meila.soa.product.service.innerservice.UserService;
import com.meila.soa.product.service.innerservice.ZoneService;

/**
 * 
 ************************************************************
 * @类名 : DubboShopServiceImpl.java
 *
 * @DESCRIPTION :店铺服务实现类
 * @AUTHOR : hawk
 * @DATE : 2016年3月16日
 ************************************************************
 */
public class DubboShopServiceImpl implements DubboShopService {

    private static Logger logger = LoggerFactory.getLogger(DubboShopServiceImpl.class);

    @Resource
    private MeilaClient meiClient;

    @Resource
    private UserService userService;

    @Resource
    private ShopService shopService;

    @Resource
    private ZoneService zoneService;

    @Resource
    private ShopMapper shopMapper;

    @Resource
    private ProdSyncMapper prodSyncMapper;

    @Override
    public DubboBasicResponse addShop(DubboAddShopRequest req) {
        try {
            // 判断 美啦用户是否存在
            MeilaUser meiUser = meiClient.getUserInfo(String.valueOf(req.getExtUserId()));
            if (meiUser == null) {
                return new DubboBasicResponse(ProductReturnCode.USER_NOT_EXIST, "美啦用户不存在");
            }

            // 判断vdlm用户是否已经存在
            User kdUser = userService.selectUserByExtUserId(req.getExtUserId());

            if (kdUser == null) {
                kdUser = userService.registerExtUser(UserPartnerType.MEILA.toString(), meiUser.getSlug(), meiUser.getNickname(), meiUser.getAvatar(),
                    meiUser.getId());

            }

            Shop shop = null;

            // 如果还没店铺 createShop
            if (null == kdUser.getShopId()) {
                logger.info("kd_id=" + kdUser.getId());
                shop = new Shop();
                shop.setOwnerId(kdUser.getId());
                shop.setName(kdUser.getName());
                shop.setStatus(ShopStatus.ACTIVE);
                shop.setDanbao(true);
                shop.setFragmentStatus(true);
                shop.setSellerSource(req.getSellerSource());

                // 添加创建者ID
                // shop.setCreateUserId(this.getCurrentUser().getId());
                shop = shopService.createByAdmin(shop);
            }

            return new DubboBasicResponse();
        } catch (ServiceException e) {
            return new DubboBasicResponse(e.getCode(), e.getMessage());
        }
    }

    @Override
    public DubboQueryShopResponse queryShop(DubboQueryShopRequest req) {
        Shop shop = BeanMapper.map(req, Shop.class);
        List<Shop> shopList = shopMapper.selectBySelective(shop);
        List<DubboShop> dubboShopList = BeanMapper.map(shopList, DubboShop.class);

        DubboQueryShopResponse dubboResp = new DubboQueryShopResponse();
        dubboResp.setShopList(dubboShopList);

        return dubboResp;
    }

    @Override
    public DubboSearchShopResponse searchShop(DubboSearchShopRequest req) {

        List<DubboSort> sortList = req.getSortList();
        String order = null;
        String direction = null;
        if (!Collections3.isEmpty(sortList)) {
            order = sortList.get(0).getProperty();
            direction = sortList.get(0).getDirection();
        }

        order = StringUtils.defaultIfBlank(order, "created_at");
        direction = StringUtils.defaultIfBlank(direction, "desc");
        Map<String, Object> params = transForm2Map(req);
        Map<String, Long> pageable = Maps.newHashMap();
        pageable.put("beginId", req.getBeginId());
        pageable.put("pageSize", req.getPageSize());
        List<ShopAdmin> shops = new ArrayList<ShopAdmin>();

        shops = shopService.listShopsByAdmin(params, pageable);
        Set<String> zoneIds = new HashSet<String>(); // 记录所有地址的Id
        for (ShopAdmin shopAdmin : shops) {
            // 对用户ID进行解密操作
            // long decodeOwernId = IdTypeHandler.decode(shopAdmin.getOwnerId());
            // shopAdmin.setOwnerId(String.valueOf(decodeOwernId));
            if (null != shopAdmin.getProvinceId() && !zoneIds.contains(shopAdmin.getProvinceId().toString())) {
                zoneIds.add(shopAdmin.getProvinceId().toString());
            }
            if (null != shopAdmin.getCityId() && !zoneIds.contains(shopAdmin.getCityId().toString())) {
                zoneIds.add(shopAdmin.getCityId().toString());
            }
        }
        Map<String, Zone> zoneList = null;
        if (zoneIds.size() > 0) {
            // 根据地址Id批量查询
            zoneList = zoneService.selectByIds(new ArrayList<String>(zoneIds));
        }
        if (null != zoneList) {
            // 填充地址信息
            for (ShopAdmin shopAdmin : shops) {
                if (null != shopAdmin.getProvinceId() && zoneList.containsKey(shopAdmin.getProvinceId().toString())) {
                    shopAdmin.setProvince(zoneList.get(shopAdmin.getProvinceId().toString()).getName());
                }
                if (null != shopAdmin.getCityId() && zoneList.containsKey(shopAdmin.getCityId().toString())) {
                    shopAdmin.setCity(zoneList.get(shopAdmin.getCityId().toString()).getName());
                }
            }
        }
        long totalNum = shopService.countShopsByAdmin(params);

        DubboSearchShopResponse dubboResp = new DubboSearchShopResponse();

        dubboResp.setShopAdminList(BeanMapper.map(shops, DubboShopAdmin.class));
        dubboResp.setTotalNum(totalNum);
        dubboResp.setPageSize(req.getPageSize());
        dubboResp.setCurrentPage(req.getCurrentPage());
        return dubboResp;

    }

    private Map<String, Object> transForm2Map(DubboSearchShopRequest form) {
        Map<String, Object> params = new HashMap<String, Object>();

        params.put("archive", ObjectUtils.defaultIfNull(form.getArchive(), Boolean.FALSE));

        if (StringUtils.isNotBlank(form.getPhone())) {
            params.put("phone", "%" + form.getPhone() + "%");
        }
        if (StringUtils.isNotBlank(form.getShopName())) {
            params.put("shopName", "%" + form.getShopName() + "%");
        }
        if (StringUtils.isNotBlank(form.getCommision())) {
            params.put("commision", form.getCommision());
        }
        if (StringUtils.isNotBlank(form.getDanbao())) {
            params.put("danbao", form.getDanbao());
        }
        if (null != form.getBeginTime()) {
            params.put("created1", form.getBeginTime());
        }
        if (null != form.getEndTime()) {
            Date date = DateUtils.addDays(form.getEndTime(), 1);
            params.put("created2", date);

        }

        if (form.getSellerType() != null) {
            params.put("sellerType", form.getSellerType());
        }

        if (form.getDeliveryType() != null) {
            params.put("deliveryType", form.getDeliveryType());
        }

        if (form.getBalanceType() != null) {
            params.put("balanceType", form.getBalanceType());
        }

        if (form.getBalanceBankId() != null) {
            params.put("balanceBankId", form.getBalanceBankId());
        }

        if (StringUtils.isNotBlank(form.getWechat())) {
            params.put("wechat", "%" + form.getWechat() + "%");
        }

        if (StringUtils.isNotBlank(form.getQq())) {
            params.put("qq", "%" + form.getQq() + "%");
        }

        if (StringUtils.isNotBlank(form.getOwnerId())) {
            params.put("ownerId", "%" + form.getOwnerId() + "%");
        }

        if (StringUtils.isNotBlank(form.getUserName())) {
            params.put("userName", "%" + form.getUserName() + "%");
        }

        if (form.getSellerSource() != null) {
            params.put("sellerSource", form.getSellerSource());
        }

        if (StringUtils.isNotBlank(form.getShopStatus())) {
            params.put("shopStatus", form.getShopStatus());
        }

        return params;
    }

    @Override
    public DubboStatisticsShopInfoResponse statisticsShopInfo(DubboStatisticsShopInfoRequest req) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DubboBasicResponse updateShopExt(DubboUpdateShopExtRequest shopSaveForm) {

        // 拆分表单类参数组合为对象
        Shop shop = splitShopSaveForm(shopSaveForm);
        ShopExt shopExt = splitShopSaveFormForExt(shopSaveForm);
        // shop.setName(shopSaveForm.getShopName());

        Shop oldShop = shopService.load(shop.getId());
        if (!StringUtils.equals(oldShop.getSellerSource().toString(), shop.getSellerSource())) {
            StringBuffer opRemark = new StringBuffer();
            opRemark.append("用户code[" + shopSaveForm.getUserId() + "]");
            // opRemark.append("用户名[" + super.getCurrentUser().getName() + "]");
            opRemark.append("修改店铺shopId=[" + shop.getId() + "] 卖家来源从");
            opRemark.append(oldShop.getSellerSource() + "修改为" + shop.getSellerSource());

            // log.info(opRemark.toString());
        }

        // shopService.updateShop(shop);

        // // 没有店铺扩展信息，则创建一个
        // if (null != shopSaveForm.getShopExtId()) {
        // shopExt.setId(shopSaveForm.getShopExtId());
        //
        // shopService.updateShopExt(shopExt);
        // } else {
        // shopService.insertShopExt(shopExt);
        // }
        shopService.updateShopAndExt(shop, shopExt);

        return new DubboBasicResponse();

    }

    private ShopExt splitShopSaveFormForExt(DubboUpdateShopExtRequest shopSaveForm) {
        ShopExt shopExt = new ShopExt();
        if (null != shopSaveForm.getBalanceType() && !shopSaveForm.getBalanceType().equals(BalanceType.BANK.toString())) {
            shopSaveForm.setOpenBank("");
        }
        // 拆分前台表单提交参数
        shopExt.setId(shopSaveForm.getShopExtId());
        shopExt.setShopId(shopSaveForm.getShopId());
        shopExt.setSellerType(shopSaveForm.getSellerType());
        if (!com.meila.common.utils.StringUtils.isEmpty(shopSaveForm.getDeliveryType())) {
            shopExt.setDeliveryType(DeliveryType.valueOf(shopSaveForm.getDeliveryType()));
        }
        if (!com.meila.common.utils.StringUtils.isEmpty(shopSaveForm.getBalanceType())) {

            shopExt.setBalanceType(BalanceType.valueOf(shopSaveForm.getBalanceType()));
        }
        shopExt.setBalanceBankId(shopSaveForm.getBalanceBankId());
        shopExt.setBalanceAccount(shopSaveForm.getBalanceAccount());
        shopExt.setPhone(shopSaveForm.getPhone());
        shopExt.setQq(shopSaveForm.getQq());
        shopExt.setVideoSlug(shopSaveForm.getVideoSlug());
        shopExt.setVideoImg(shopSaveForm.getVideoImg());
        shopExt.setVideoUrl(shopSaveForm.getVideoUrl());
        shopExt.setReceiverName(shopSaveForm.getReceiverName());
        shopExt.setOpenBank(shopSaveForm.getOpenBank());
        shopExt.setSellerCertification(
            shopSaveForm.getSellerCertification() == null ? "" : StringUtils.join(shopSaveForm.getSellerCertification(), "|"));
        shopExt.setSelfhoodName(shopSaveForm.getSelfhoodName());
        shopExt.setMinPaidFee(shopSaveForm.getMinPaidFee());
        shopExt.setPostageFee(shopSaveForm.getPostageFee());
        return shopExt;
    }

    private Shop splitShopSaveForm(DubboUpdateShopExtRequest shopSaveForm) {
        Shop shop = new Shop();

        shop.setId(shopSaveForm.getShopId());
        shop.setWechat(shopSaveForm.getWechat());
        shop.setDescription(shopSaveForm.getDescription());
        shop.setProvinceId(shopSaveForm.getProvinceId());
        shop.setCityId(shopSaveForm.getCityId());
        // shop.setName(shopSaveForm.getShopName());

        if (null != shopSaveForm.getSellerSource()) {
            shop.setSellerSource(shopSaveForm.getSellerSource().toString());
        }

        return shop;
    }

    @Override
    public DubboBasicResponse updateShop(DubboUpdateShopRequest req) {
        Shop shop = BeanMapper.map(req, Shop.class);
        int rc = shopService.update(shop);

        if (req.getThirdCommission() != null) {
            if (!updateThirdCommission(req.getThirdCommission(), req.getShopId())) {
                // RequestContext requestContext = new RequestContext(req);
                // throw new BizException(GlobalErrorCode.INVALID_ARGUMENT,
                // requestContext.getMessage("invalid.argument"));
                return new DubboBasicResponse(ProductReturnCode.FAILED, "更新佣金设置失败");
            }
        }

        return new DubboBasicResponse();
    }

    private boolean updateThirdCommission(DubboThirdCommission atc, Long shopId) {
        Boolean ret = false;
        if (atc == null || atc.getThirdId() == null)
            return ret;

        Shop shop = shopService.load(shopId);
        if (atc.getCommissionRate() != null) {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("shopId", shop.getId());
            params.put("unionId", atc.getThirdId());
            List<ProdSync> aList = prodSyncMapper.findByParmas(params, null);
            ProdSync aps = new ProdSync();
            if (aList != null && aList.size() != 0) {
                if (aList.size() == 1) {
                    aps.setId(aList.get(0).getId());
                    aps.setAuditSts(SyncAuditStatus.AUDITTING.toString());
                    aps.setCommissionRate(atc.getCommissionRate());
                    ret = prodSyncMapper.update(aps) == 1 ? true : false;
                } else {
                    ret = false;
                }
            } else {
                aps.setShopId(shop.getId());
                aps.setName(shop.getName());
                aps.setSynced(false);
                aps.setAuditSts(SyncAuditStatus.AUDITTING.toString());
                aps.setCommissionRate(atc.getCommissionRate());
                User aUser = userService.load(atc.getThirdId());
                if (aUser != null) {
                    aps.setUnionId(aUser.getId());
                } else {
                    aps.setUnionId(16618945L);
                }
                ret = prodSyncMapper.insert(aps) == 1 ? true : false;
            }

            shop.setDanbao(true);
            shopService.update(shop);
        }
        return ret;
    }

    @Override
    public DubboQueryShopResponse queryShopWithExtByOwnerId(DubboQueryShopByOwnerIdListRequest req) {
        List<Shop> shopList = shopService.selectShopByUserIdList(req.getOwnerIdList());

        List<Long> shopIdList = Lists.newArrayList();

        if (!Collections3.isEmpty(shopList)) {
            for (Shop temp : shopList) {
                shopIdList.add(temp.getId());
            }
        }

        List<ShopExt> shopExtList = shopService.selectShopExtByUserIdList(shopIdList);

        Map<Long, ShopExt> shopExtMap = Maps.newHashMap();
        if (!Collections3.isEmpty(shopExtList)) {
            for (ShopExt temp : shopExtList) {
                shopExtMap.put(temp.getShopId(), temp);
            }
        }

        List<DubboShop> dubboShopList = BeanMapper.map(shopList, DubboShop.class);

        if (!Collections3.isEmpty(dubboShopList)) {
            for (DubboShop temp : dubboShopList) {
                temp.setShopExt(BeanMapper.map(shopExtMap.get(temp.getShopId()), DubboShopExt.class));
            }
        }

        DubboQueryShopResponse dubboResp = new DubboQueryShopResponse();
        dubboResp.setShopList(dubboShopList);
        return dubboResp;
    }
}
