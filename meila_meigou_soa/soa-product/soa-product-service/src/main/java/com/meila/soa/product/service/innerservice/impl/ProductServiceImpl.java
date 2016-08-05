package com.meila.soa.product.service.innerservice.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.collections4.list.SetUniqueList;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.meila.common.bean.utils.BeanMapper;
import com.meila.common.collection.utils.Collections3;
import com.meila.common.exceptions.ServiceException;
import com.meila.common.utils.Reflections;
import com.meila.meigou.cachehelper.MeilaCacheType;
import com.meila.meigou.cachehelper.MeilaCacheUtils;
import com.meila.soa.meila.client.model.GenShareImgResponse;
import com.meila.soa.meila.client.model.OmsJsonResult;
import com.meila.soa.meila.client.service.MeiLaOmsClient;
import com.meila.soa.meila.client.service.MeilaClient;
import com.meila.soa.product.api.constant.ProductReturnCode;
import com.meila.soa.product.api.constant.SkuInvChangeType;
import com.meila.soa.product.api.model.dto.DubboSku;
import com.meila.soa.product.api.model.dto.DubboSkuAmountInfo;
import com.meila.soa.product.api.model.dto.DubboSkuBundle;
import com.meila.soa.product.api.model.dto.DubboSkuBundleInfo;
import com.meila.soa.product.api.model.dto.product.v1.DubboProductV1;
import com.meila.soa.product.api.model.request.inventory.DubboLockInvRequest;
import com.meila.soa.product.api.model.request.inventory.DubboRecoveryInvRequest;
import com.meila.soa.product.api.model.request.inventory.DubboWmsInvNotifyRequest.DubboInvNotify;
import com.meila.soa.product.api.model.request.product.DubboUpdateProductAndExtRequest;
import com.meila.soa.product.dal.dao.product.ProductImageMapper;
import com.meila.soa.product.dal.dao.product.ProductInfoMapper;
import com.meila.soa.product.dal.dao.product.ProductMapper;
import com.meila.soa.product.dal.dao.product.ProductUpdateLogMapper;
import com.meila.soa.product.dal.dao.product.SkuBomMapper;
import com.meila.soa.product.dal.dao.product.SkuExtMapper;
import com.meila.soa.product.dal.dao.product.SkuInvOperateLogMapper;
import com.meila.soa.product.dal.dao.product.SkuMapper;
import com.meila.soa.product.dal.dao.product.SkuMappingMapper;
import com.meila.soa.product.dal.dao.product.SkuWMSInvLogMapper;
import com.meila.soa.product.dal.dao.product.SkuWMSInvMapper;
import com.meila.soa.product.dal.dao.shop.ShopMapper;
import com.meila.soa.product.dal.entity.product.Product;
import com.meila.soa.product.dal.entity.product.ProductImage;
import com.meila.soa.product.dal.entity.product.ProductInfo;
import com.meila.soa.product.dal.entity.product.ProductUpdateLog;
import com.meila.soa.product.dal.entity.product.Sku;
import com.meila.soa.product.dal.entity.product.SkuBom;
import com.meila.soa.product.dal.entity.product.SkuBomExample;
import com.meila.soa.product.dal.entity.product.SkuBomExample.Criteria;
import com.meila.soa.product.dal.entity.product.SkuExt;
import com.meila.soa.product.dal.entity.product.SkuInvOperateLog;
import com.meila.soa.product.dal.entity.product.SkuMapping;
import com.meila.soa.product.dal.entity.product.SkuWMSInv;
import com.meila.soa.product.dal.entity.product.SkuWMSInvLog;
import com.meila.soa.product.dal.entity.shop.Shop;
import com.meila.soa.product.dal.entity.shop.ShopExt;
import com.meila.soa.product.dal.entity.user.User;
import com.meila.soa.product.dal.mybatis.IdTypeHandler;
import com.meila.soa.product.dal.type.DeliveryType;
import com.meila.soa.product.dal.type.ProductStatus;
import com.meila.soa.product.dal.type.ProductType;
import com.meila.soa.product.dal.type.PurchaseSourceEnum;
import com.meila.soa.product.dal.type.SkuDisplayType;
import com.meila.soa.product.dal.type.SkuInvOperateType;
import com.meila.soa.product.dal.type.SkuType;
import com.meila.soa.product.dal.type.StorageType;
import com.meila.soa.product.service.exceptions.BizException;
import com.meila.soa.product.service.exceptions.GlobalErrorCode;
import com.meila.soa.product.service.innerservice.ProductService;
import com.meila.soa.product.service.innerservice.ShopPostAgeService;
import com.meila.soa.product.service.innerservice.ShopService;
import com.meila.soa.product.service.model.ShopModel;
import com.meila.soa.product.service.model.ShopPostAge;
import com.meila.soa.product.service.model.SkuMappingModel;

@Service("productService")
public class ProductServiceImpl implements ProductService {
    private static Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Resource
    private MeiLaOmsClient meiLaOmsClient;

    @Resource
    private MeilaClient meilaClient;

    @Resource
    private SkuMapper skuMapper;

    @Resource
    private SkuExtMapper skuExtMapper;

    @Resource
    private SkuMappingMapper skuMappingMapper;

    @Resource
    private ProductInfoMapper productInfoMapper;

    @Resource
    private ProductImageMapper productImageMapper;

    @Resource
    private ProductUpdateLogMapper productUpdateLogMapper;

    // 缓存工具 @flong
    @Autowired
    private MeilaCacheUtils cacheUtils;

    @Resource
    private ThreadPoolTaskExecutor syncTaskExecutor;

    @Resource
    private SkuWMSInvLogMapper skuWMSInvLogMapper;

    @Resource
    private SkuWMSInvMapper skuWMSInvMapper;

    @Resource
    private ShopPostAgeService shopPostAgeService;

    @Resource
    private ShopMapper shopMapper;

    private Integer skuMappingMaxLen = 5;

    @Resource
    private SkuInvOperateLogMapper skuInvOperateLogMapper;
    /**
     * 美啦质检发货1天
     */
    @Value("${deliverydays.meila.check.days}")
    private int MEILA_CHECK_DAYS;
    /**
     * 国内配送3天
     */
    @Value("${deliverydays.domestic.delivery.days}")
    private int DOMESTIC_DELIVERY_DAYS;
    /**
     * 保税区发货1天
     */
    @Value("${deliverydays.bonded.delivery.days}")
    private int BONDED_DELIVERY_DAYS;
    /**
     * 海关清关5天
     */
    @Value("${deliverydays.clearance.days}")
    private int CLEARANCE_DAYS;

    /**
     * 国内中转1天
     */
    @Value("${deliverydays.domestic.transit.days}")
    private int DOMESTIC_TRANSIT_DAYS;

    @Value("${bom.limit.user.ids}")
    private String bomLimitUserIds;

    @Resource
    private SkuBomMapper skuBomMapper;

    @Resource
    private ProductMapper productMapper;

    @Resource
    private ShopService shopService;

    private List<String> bomLimitUserIdList;
    private static final Object bomLimitLock = new Object();

    /**
     * <pre>
     * 代购美啦代发货：海外备货、国际物流、美啦质检、国内配送、安全收货
     * 代购卖家自发货：海外备货、国际物流、国内中转 ，国内配送、安全收货
     * 保税区直发：保税区发货、海关清关、国内配送、安全收货
     * </pre>
     */
    @Override
    public Map<String, Object> createProductDeliveryInfo(ProductInfo productInfo, DeliveryType deliveryType) {
        Map<String, Object> resultMap = new HashMap<String, Object>();

        int totalDays = 0;
        resultMap.put("deliveryType", deliveryType);
        resultMap.put("domesticDeliveryDays", DOMESTIC_DELIVERY_DAYS);
        resultMap.put("storageType", productInfo.getStorageType());
        resultMap.put("purchaseSource", productInfo.getPurchaseSource());
        totalDays += DOMESTIC_DELIVERY_DAYS;

        // 海外直邮需求中到货天数删除, 为保持兼容, 代码预留
        switch (deliveryType) {
            case MEILA:
            case HONGKONG_ML: {
                if (StorageType.NON_SPOT.equals(productInfo.getStorageType())) {
                    resultMap.put("productPrepareDays", productInfo.getProductPrepareDays());
                    totalDays += productInfo.getProductPrepareDays();
                    resultMap.put("logisticsInternaDays", productInfo.getLogisticsInternaDays());
                    totalDays += productInfo.getLogisticsInternaDays();
                }
                resultMap.put("meilaCheckDays", MEILA_CHECK_DAYS);
                totalDays += MEILA_CHECK_DAYS;
                break;
            }
            case SELLER: {
                if (StorageType.NON_SPOT.equals(productInfo.getStorageType())) {
                    resultMap.put("productPrepareDays", productInfo.getProductPrepareDays());
                    totalDays += productInfo.getProductPrepareDays();
                    resultMap.put("logisticsInternaDays", productInfo.getLogisticsInternaDays());
                    totalDays += productInfo.getLogisticsInternaDays();
                }
                resultMap.put("domesticTransitDays", DOMESTIC_TRANSIT_DAYS);
                totalDays += DOMESTIC_TRANSIT_DAYS;
                break;
            }
            case BONDED_AREA: {
                resultMap.put("clearanceDays", CLEARANCE_DAYS);
                totalDays += CLEARANCE_DAYS;
                resultMap.put("bondedDays", BONDED_DELIVERY_DAYS);
                totalDays += BONDED_DELIVERY_DAYS;
                break;
            }
            case BONDED_AREA_ML: {
                resultMap.put("clearanceDays", CLEARANCE_DAYS);
                totalDays += CLEARANCE_DAYS;
                resultMap.put("bondedDays", BONDED_DELIVERY_DAYS);
                totalDays += BONDED_DELIVERY_DAYS;
                break;
            }
            default:
                break;
        }
        resultMap.put("totalDays", totalDays);

        // 海外直邮则 展示约72小时发货
        if (deliveryType.equals(DeliveryType.OVERSEAS_DIRECT_MAIL)) {
            resultMap.put("sendOutHours", 72);
        }
        // 其他发货方式则 展示约24小时发货
        else {
            resultMap.put("sendOutHours", 24);
        }

        return resultMap;
    }

    /**
     * 增加 mappingValues,如颜色mapping，里有黄色、绿色，红色，方便客户端显示
     * 
     * @param productId
     * @param skus
     * @return
     */
    @Override
    public List<SkuMappingModel> skuMappingToVO(Long productId, List<DubboSku> skus) {
        List<SkuMappingModel> skuMappingVos = new ArrayList<SkuMappingModel>();
        if (null == skus || (skus.size() == 1 && "无".equals(skus.get(0).getSpec()))) {
            return skuMappingVos;
        }

        // List<SkuMapping> skuMappings =
        // skuMappingMapper.selectByProductId(productId);
        List<SkuMapping> skuMappings = skuMappingMapper.selectByProductId(productId);
        SkuMappingModel vo = null;
        for (SkuMapping skuMapping : skuMappings) {
            vo = new SkuMappingModel(skuMapping);
            List<String> values = SetUniqueList.setUniqueList(new ArrayList<String>());
            for (DubboSku sku : skus) {

                Map<String, String> specMap = sku.getSpecMap();
                if (null == specMap) {
                    specMap = new HashMap<>();
                    sku.setSpecMap(specMap);
                }
                String spec = null;
                try {
                    spec = (String) FieldUtils.readDeclaredField(sku, skuMapping.getSpecKey(), true);
                    specMap.put(skuMapping.getSpecName(), spec);

                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                values.add(spec);
            }

            List<String> tempValues = new LinkedList<>();

            for (String str : values) {
                tempValues.add(str);
            }
            vo.setMappingValues(tempValues);
            skuMappingVos.add(vo);
        }

        return skuMappingVos;
    }

    @Override
    public boolean checkUserIdForBomLimit(Long userId) {

        if (CollectionUtils.isEmpty(bomLimitUserIdList)) {
            synchronized (bomLimitLock) {
                bomLimitUserIdList = Lists.newCopyOnWriteArrayList();

                if (StringUtils.isNotEmpty(bomLimitUserIds)) {
                    String[] bomLimitArr = StringUtils.split(bomLimitUserIds, ",");

                    for (String str : bomLimitArr) {
                        bomLimitUserIdList.add(str);
                    }
                }
            }
        }

        return bomLimitUserIdList.contains(String.valueOf(userId));
    }

    @Override
    public Sku findSpuByProductIdAndName(Long productId, String spuName) {
        List<Sku> spuList = skuMapper.findSpuByProductIdAndName(productId, StringUtils.trim(spuName));

        if (spuList != null && spuList.size() > 0) {
            return spuList.get(0);
        } else {
            return null;
        }

    }

    @Override
    public void saveOrUpdateBom(List<DubboSkuBundle> bomsList, String specName, Long productId) {

        // 排序值
        Integer skuOrder = 1;

        // 多个BOM绑定关系的套餐
        for (DubboSkuBundle vo : bomsList) {
            Sku sku = null;
            if (null == vo.getSkuBundleId()) {
                sku = new Sku();
                sku.setProductId(productId);
                sku.setSpec(specName + ":" + vo.getSkuBundleName());
                sku.setSpec1(vo.getSkuBundleName());
                sku.setPrice(vo.getPrice());
                sku.setAmount(vo.getAmount());
                sku.setSkuOrder(skuOrder);
                sku.setSkuType(SkuType.SPU);
                sku.setIsDisplay(SkuDisplayType.valueOf(vo.getIsDisplay()));

                this.saveSku(sku);
                vo.setSkuBundleId(sku.getId());
                skuOrder += 1;
            } else {
                sku = this.loadSku(vo.getSkuBundleId());
                sku.setSpec(specName + ":" + vo.getSkuBundleName());
                sku.setSpec1(vo.getSkuBundleName());
                sku.setPrice(vo.getPrice());
                sku.setAmount(vo.getAmount());
                sku.setSkuOrder(skuOrder);
                sku.setIsDisplay(SkuDisplayType.valueOf(vo.getIsDisplay()));

                this.updateSku(sku);
                skuOrder += 1;
            }

            if (null != sku) {
                List<SkuBom> skuBomList = this.findSkuBomListBySpuId(vo.getSkuBundleId());

                List<DubboSkuBundleInfo> boms = vo.getSkuBundleInfoList();
                for (DubboSkuBundleInfo bom : boms) {

                    // 是否已包含在套餐的标识
                    boolean containFlag = false;
                    for (SkuBom skuBom : skuBomList) {
                        if (bom.getSubSkuId().equals(skuBom.getSubSkuId())) {
                            containFlag = true;
                            break;
                        }
                    }

                    if (containFlag) {
                        SkuBom skuBom = BeanMapper.map(bom, SkuBom.class);
                        this.updateSkuBom(skuBom);
                    } else {
                        bom.setSkuBundleId(vo.getSkuBundleId());
                        SkuBom skuBom = BeanMapper.map(bom, SkuBom.class);

                        this.insertSkuBom(skuBom);
                    }
                }
            }
        }

        if (null != bomsList && bomsList.size() > 0) {
            updateProductAmountAndPriceIncludeBom(productId);
            this.syncProductToOMS(productId, null);
        }

    }

    /**
     * 调用OMS的API同步商品信息
     * 
     * @param productId 商品ID
     * @param shopId TODO
     * @return void 空
     * @exception 调用接口失败向上层抛出BizException异常
     */
    public void syncProductToOMS(final Long productId, final Long shopId) {
        syncTaskExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);

                    log.debug("开始调用OMS同步商品信息 productId:{}", productId);

                    ShopModel shopVo = null;

                    // 获取店铺以及相关扩展信息
                    if (shopId != null) {
                        shopVo = shopService.loadShopAndExt(shopId);
                    } else {
                        Product product = productMapper.selectByPrimaryKey(productId);
                        if (null != product && null != product.getShopId()) {
                            shopVo = shopService.loadShopAndExt(product.getShopId());
                        }
                    }

                    // 如果店铺扩展信息存在，并且发货类型为美啦代发货时才发送消息到OMS通知同步商品信息
                    if (null != shopVo && null != shopVo.getShopExtEntity() && shopVo.getShopExtEntity().getDeliveryType() == DeliveryType.MEILA) {
                        // NEO 调用OMS的API同步商品信息 T3、商品发布（商品新增，商品编辑，sku编辑，套餐编辑）
                        List<Long> productIds = Lists.newArrayList(productId);
                        OmsJsonResult result = meiLaOmsClient.syncProduct(productIds);

                        if (result.isFail()) {
                            log.error(null == result.getErrorMsg() ? "调用OMS同步商品信息失败" : result.getErrorMsg());
                        }
                    }

                } catch (InterruptedException e) {
                    log.error("Thread Sleep Error", e);
                }
            }
        });
    }

    @Transactional
    private void updateProductAmountAndPriceIncludeBom(Long productId) {
        productMapper.updateProductAmountIncludeBom(productId);
        productMapper.updateProductPriceIncludeBom(productId);

    }

    @Override
    public void updateSkuBom(SkuBom bom) {
        skuBomMapper.updateByPrimaryKeySelective(bom);
    }

    @Override
    public void insertSkuBom(SkuBom bom) {
        skuBomMapper.insert((bom));
    }

    private List<SkuBom> findSkuBomListBySpuId(Long skuBundleId) {

        SkuBomExample example = new SkuBomExample();

        Criteria criteria = example.createCriteria();

        criteria.andSpuIdEqualTo(skuBundleId);

        List<SkuBom> list = skuBomMapper.selectByExample(example);

        if (list != null && list.size() > 0) {
            return list;
        } else {
            return Collections.EMPTY_LIST;
        }

    }

    @Override
    public void updateSku(Sku sku) {
        skuMapper.updateByPrimaryKeySelective(sku);
    }

    @Override
    public void saveSku(Sku sku) {
        skuMapper.insert(sku);
        this.addSkuCode(sku.getId());
    }

    @Override
    public void addSkuCode(Long... ids) {
        if (ids == null || ArrayUtils.isEmpty(ids)) {
            return;
        }

        for (Long p : ids) {
            skuMapper.addCode(p, IdTypeHandler.encode(p));
        }
    }

    @Override
    public Sku loadSku(Long skuId) {
        return skuMapper.selectByPrimaryKey(skuId);
    }

    @Override
    public List<Product> querySpuPage(Product product, Map<String, Long> page) {
        List<Product> productList = productMapper.selectBySelective(product, page);
        return productList;
    }

    @Override
    public List<Product> searchSpu(Product product, Map<String, Object> params) {

        return productMapper.selectByKwd(product, params);
    }

    @Override
    public Long countSearchSpu(Product product, Map<String, Object> params) {
        return productMapper.countByKwd(product, params);
    }

    @Override
    public Product saveProduct(Product product, List<ProductImage> imgs, ProductInfo productInfo, User user) {

        log.debug("进入saveProduct方法创建商品基本信息,userId:{}", user.getId());

        setProductParameter(product, imgs, user);

        // 创建商品，保存基本信息时为草稿状态
        product.setStatus(ProductStatus.DRAFT);

        product.setSales(0L);
        product.setArchive(false);
        product.setCreatedAt(new Date(System.currentTimeMillis()));
        product.setUpdatedAt(new Date(System.currentTimeMillis()));
        product.setUpdateLock(false);
        productMapper.insert(product);

        // 添加code
        productMapper.addCode(IdTypeHandler.encode(product.getId()), product.getId());
        product.setCode(IdTypeHandler.encode(product.getId()));

        // 保存商品扩展信息
        if (null != productInfo) {
            productInfo.setProductId(product.getId());
            productInfo.setProperty(null == productInfo.getProperty() ? Integer.valueOf(1) : productInfo.getProperty());
            productInfoMapper.insert(productInfo);
        }

        // 保存商品图片
        saveImgs(null, product, imgs);

        // 获取分享二维码图片
        generateShareImg(product, null, productInfo);

        // 商品变更通知社区搜索
        noticeProductUpdateToMeila(product.getCode());

        // 通知OMS更新商品信息
        this.syncProductToOMS(product.getId(), product.getShopId());

        // 记录新增日志
        HashMap<String, Object> afterMap = new HashMap<String, Object>();
        afterMap.put("product", product);
        afterMap.put("imgs", imgs);
        afterMap.put("productInfo", productInfo);
        String afterLog = JSONObject.toJSONString(afterMap);
        log.debug("save product log,productId:{},log:{}", product.getId(), afterLog);
        productUpdateLogMapper.insert(new ProductUpdateLog(0, "", afterLog, user.getId(), ProductUpdateLog.SystemEnum.SELLERPC, product.getId()));

        return product;

    }

    @Override
    public void noticeProductUpdateToMeila(final String productCode) {

        syncTaskExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    meilaClient.noticeProductUpdateToMeila(IdTypeHandler.decode(productCode));
                } catch (Exception e) {
                    log.error("商品变更通知社区失败: ", e);
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void generateShareImg(final Product newProduct, final Product oldProduct, final ProductInfo productInfo) {

        if (null == newProduct || null == newProduct.getId() || StringUtils.isEmpty(newProduct.getName()) || StringUtils.isEmpty(newProduct.getCode())
                || null == newProduct.getPrice() || StringUtils.isEmpty(newProduct.getImg())) {
            throw new NullPointerException("获取分享二维码失败: id, slug, name, price, img 不能为空.");
        }

        if (null != oldProduct) {
            // 修改前后采购地比较
            Map<String, Object> oldProductInfo = loadInfo(oldProduct.getId());
            String purchaseSource = MapUtils.getString(oldProductInfo, "purchase_source");
            boolean flag = true;
            if (null != productInfo && null != purchaseSource && null != productInfo.getPurchaseSource()
                    && !productInfo.getPurchaseSource().toString().equals(purchaseSource)) {
                flag = false;
            }

            String storage_type = MapUtils.getString(oldProductInfo, "storage_type");
            if (null != productInfo && null != productInfo.getStorageType() && null != storage_type
                    && !productInfo.getStorageType().toString().equals(storage_type)) {
                flag = false;
            }

            // 如果name, price, 主图 没有变更则不重新生成二维码图片
            if (StringUtils.equals(newProduct.getName(), oldProduct.getName()) && StringUtils.equals(newProduct.getImg(), oldProduct.getImg())
                    && newProduct.getPrice().compareTo(oldProduct.getPrice()) == 0 && flag) {
                return;
            }

        }

        syncTaskExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Product product = newProduct;

                    ProductInfo tempProductInfo = productInfo;

                    // 采购地
                    String purchaseSource = "";
                    if (null != tempProductInfo && null != tempProductInfo.getPurchaseSource()) {
                        purchaseSource = tempProductInfo.getPurchaseSource().toString();
                    } else {
                        Map<String, Object> productInfoMap = loadInfo(product.getId());
                        purchaseSource = MapUtils.getString(productInfoMap, "purchase_source");
                    }

                    // 发货方式
                    String shippingText = "";
                    if (null != product.getShopId() && StringUtils.isNotBlank(purchaseSource)) {
                        ShopModel shopModel = shopService.loadShopAndExt(product.getShopId());

                        PurchaseSourceEnum purchaseSourceEnum = null;
                        for (PurchaseSourceEnum tempEunm : PurchaseSourceEnum.values()) {
                            if (StringUtils.equals(tempEunm.toString(), purchaseSource)) {
                                purchaseSourceEnum = tempEunm;
                                break;
                            }
                        }
                        ShopExt shopExt = null;
                        if (null != shopModel) {
                            shopExt = shopModel.getShopExtEntity();
                        }
                        if (null != shopExt && null != shopExt.getDeliveryType() && null != purchaseSourceEnum) {
                            shippingText += purchaseSourceEnum.getName();
                            shippingText += "直采 ";

                            DeliveryType deliveryType = shopExt.getDeliveryType();

                            if (deliveryType == DeliveryType.BONDED_AREA || deliveryType == DeliveryType.BONDED_AREA_ML) {
                                shippingText += "保税仓直发";
                            } else if (null != productInfo && null != productInfo.getStorageType()) {
                                if (productInfo.getStorageType().equals(StorageType.SPOT)) {
                                    shippingText += "闪电发货";
                                } else {
                                    shippingText += "海外直发";
                                }
                            }
                        }
                    }

                    GenShareImgResponse res = meilaClient.genShareImgForProduct(product.getId(), product.getCode(), product.getName(),
                        product.getPrice(), product.getImg(), purchaseSource, shippingText);

                    if (null == res || StringUtils.isEmpty(res.getShare_img_url())) {
                        log.error("获取分享二维码异常: 未正确获取到返回值.");
                        return;
                    }

                    String shareImg = res.getShare_img_url();

                    ProductInfo info = new ProductInfo();
                    info.setProductId(product.getId());
                    info.setShareImg(shareImg.startsWith("/") ? shareImg : "/" + shareImg);
                    info.setShareImgWidth(res.getWidth());
                    info.setShareImgHeight(res.getHeight());

                    int row = productInfoMapper.updateShareImgByProductId(info);

                    if (0 == row) {
                        info.setProperty(Integer.valueOf(1));
                        productInfoMapper.insert(info);
                    }

                } catch (Exception e) {
                    log.error("获取分享二维码异常: ", e);
                }
            }
        });
    }

    @Override
    public Map<String, Object> loadInfo(Long productId) {
        if (null == productId) {
            return Collections.EMPTY_MAP;
        }

        return productMapper.loadInfo(productId);
    }

    /**
     * 保存商品图片信息 在删除操作时，不直接删除，使用job任务定时清理
     * 
     * @param modProduct
     * @param product
     * @param imgs
     */
    @Transactional
    private void saveImgs(Product modProduct, Product product, List<ProductImage> imgs) {
        if (imgs == null) {
            imgs = new ArrayList<ProductImage>();
        }
        // 保存关联表
        List<ProductImage> modImgs = null; // 取出原标签
        if (modProduct != null) {
            modImgs = productImageMapper.selectByProductId(product.getId());
        } else {
            modImgs = new ArrayList<ProductImage>();
        }
        for (ProductImage img : imgs) {
            boolean bInclude = false;
            for (ProductImage modImg : modImgs) {
                if (img.getImg().equals(modImg.getImg())) {
                    bInclude = true;
                    break;
                }
            }
            img.setProductId(product.getId());
            if (!bInclude) {
                productImageMapper.insert(img);
            } else {
                productImageMapper.updateImgOrder(img);
            }
        }

        // 删除已删除的原关联表
        for (ProductImage modImg : modImgs) {
            boolean bInclude = false;
            for (ProductImage img : imgs) {
                if (img.getImg().equals(modImg.getImg())) {
                    bInclude = true;
                    break;
                }
            }
            if (!bInclude) {
                productImageMapper.updateForArchive(modImg.getId());
            }
        }
    }

    /**
     * 设置商品参数
     * 
     * @param product 商品
     * @param imgs 图片集合
     * @param user 用户
     * @return void 空
     * @exception {说明在某情况下,将发生什么异常}
     */
    public void setProductParameter(Product product, List<ProductImage> imgs, User user) {
        // 商品的名称取描述的前25个字符
        if (StringUtils.isBlank(product.getName())) {
            product.setName(StringUtils.abbreviate(product.getDescription(), 25));
        }

        // 创建新商品才设值，更新商品则不需要设以下的值
        if (null == product.getId()) {
            // 设置用户ID和卖家ID
            product.setUserId(user.getId());
            product.setShopId(user.getShopId());

            // 创建商品基本信息，库存、售价初始值为0
            product.setAmount(0L);
            product.setPrice(BigDecimal.ZERO);
        }

        // 设置商品图片
        product.setImg(imgs.get(0).getImg());
        product.setImgWidth(imgs.get(0).getImgWidth());
        product.setImgHeight(imgs.get(0).getImgHeight());

        // 上架
        if (product.getStatus() == ProductStatus.ONSALE) {
            product.setOnsaleAt(Calendar.getInstance().getTime());
        }

        // 设置延迟发布默认值
        if (null == product.getIsDelay()) {
            product.setDelayDays(0);
        }

        // 设置推荐的默认值
        if (null == product.getRecommend()) {
            product.setRecommend(Boolean.FALSE);
        }
    }

    @Override
    public List<Sku> selectSkuListByProductId(Long productId, SkuType skuType) {
        if (null == productId) {
            return Collections.emptyList();
        }

        return skuMapper.selectSkuListByProductId(productId, skuType);
    }

    @Override
    public List<SkuBom> selectBomListBySkuList(List<Sku> skuList) {
        if (CollectionUtils.isEmpty(skuList)) {
            return Collections.emptyList();
        }

        List<Long> skuIdList = Lists.newArrayList();
        for (Sku sku : skuList) {
            skuIdList.add(sku.getId());
        }

        return skuBomMapper.selectBomListBySkuIdList(skuIdList);
    }

    @Override
    public List<ProductInfo> selectProductInfoListByBomList(List<SkuBom> bomList) {
        if (CollectionUtils.isEmpty(bomList)) {
            return Collections.emptyList();
        }

        List<Long> skuIdList = Lists.newArrayList();
        for (SkuBom bom : bomList) {
            skuIdList.add(bom.getSpuId());
        }

        return productInfoMapper.selectProductInfoListBySkuIdList(skuIdList);
    }

    @Override
    public void updateProduct(Product product, List<ProductImage> imgs, ProductInfo productInfo, User user) {
        log.debug("进入updateProduct方法更新商品基本信息,userId:{}", user.getId());

        // 检查商品原价是否大于Sku价格，如果小于小于Sku价格则向上抛出异常
        checkProductMarketPrice(product);

        setProductParameter(product, imgs, user);

        Product oldProduct = productMapper.selectByPrimaryKey(product.getId());

        // 检查product和sku是否属于自己
        if (!validProductOwner(user, product, oldProduct)) {
            throw new BizException(GlobalErrorCode.INTERNAL_ERROR, "你没有权限修改该商品");
        }

        if (Boolean.TRUE.equals(oldProduct.getUpdateLock())) {
            throw new BizException(GlobalErrorCode.INTERNAL_ERROR, "商品正在参与促销活动，不能编辑");
        }

        // 更新日志
        String preLog = JSONObject.toJSONString(oldProduct);

        int count = productMapper.updateByPrimaryKeySelective(product);

        product.setCode(oldProduct.getCode());
        product.setPrice(BigDecimal.ZERO);

        // 更新商品扩展信息
        updateProductInfo(product, productInfo, user);

        // 保存或更新商品图片
        saveImgs(oldProduct, product, imgs);

        // 获取分享二维码图片
        generateShareImg(product, oldProduct, productInfo);

        // 清除商品缓存
        clearProductCache(product);

        // 商品变更通知社区搜索
        noticeProductUpdateToMeila(product.getCode());

        // 通知OMS更新商品信息
        this.syncProductToOMS(product.getId(), product.getShopId());

        // 更新日志
        HashMap<String, Object> afterMap = Maps.newHashMap();
        afterMap.put("product", product);
        afterMap.put("imgs", imgs);
        String afterLog = JSONObject.toJSONString(afterMap);
        log.debug("update product log,productId:{},prelog:{},afterLog:{}", product.getId(), preLog, afterLog);
        productUpdateLogMapper
            .insert(new ProductUpdateLog(0, preLog, afterLog, user.getId(), ProductUpdateLog.SystemEnum.SELLERPC, oldProduct.getId()));

    }

    /**
     * 清除商品缓存
     * 
     * @param product 商品
     * @return void 空
     * @exception {说明在某情况下,将发生什么异常}
     */
    @Override
    public void clearProductCache(Product product) {
        try {
            cacheUtils.del(MeilaCacheType.Product, product.getCode());
            log.debug("clear product cache : " + product.getCode());
        } catch (Throwable e) {
            e.printStackTrace();
            log.error("清空商品缓存失败：", e);
        }
    }

    private void updateProductInfo(Product product, ProductInfo productInfo, User user) {
        if (null != productInfo) {
            ProductInfo oldInfo = productInfoMapper.selectByProductId(product.getId());

            // 更新日志
            String preLog = JSONObject.toJSONString(oldInfo);
            String afterLog = "";

            if (null == oldInfo) {
                productInfo.setProductId(product.getId());
                productInfo.setProperty(null == productInfo.getProperty() ? Integer.valueOf(1) : productInfo.getProperty());

                productInfoMapper.insert(productInfo);

                afterLog = JSONObject.toJSONString(productInfo);
            } else {
                oldInfo.setShortName(productInfo.getShortName());
                oldInfo.setShortIntro(productInfo.getShortIntro());
                oldInfo.setPurchaseSource(productInfo.getPurchaseSource());
                oldInfo.setStorageType(productInfo.getStorageType());
                oldInfo.setProductPrepareDays(productInfo.getProductPrepareDays());
                oldInfo.setLogisticsInternaDays(productInfo.getLogisticsInternaDays());

                oldInfo.setDeliveryType(productInfo.getDeliveryType());
                oldInfo.setWarehouse(productInfo.getWarehouse());

                productInfoMapper.updateByProductId(oldInfo);

                afterLog = JSONObject.toJSONString(oldInfo);
            }

            log.debug("update product info log,productId:{},preLog:{},afterLog:{}", product.getId(), preLog, afterLog);

            // 记录更新日志
            productUpdateLogMapper
                .insert(new ProductUpdateLog(0, preLog, afterLog, user.getId(), ProductUpdateLog.SystemEnum.SELLERPC, oldInfo.getProductId()));
        }
    }

    private boolean validProductOwner(User user, Product product, Product oldProduct) {
        if (oldProduct == null || !oldProduct.getUserId().equals(user.getId()) || !oldProduct.getShopId().equals(user.getShopId())) {
            return false;
        }

        return true;
    }

    private void checkProductMarketPrice(Product product) {
        List<Sku> skuList = this.selectSkuListByProductId(product.getId(), null);

        // 如果商品还没有Sku时，则无需校验商品原价
        if (CollectionUtils.isEmpty(skuList)) {
            return;
        }

        checkProductMarketPrice(product, skuList);
    }

    private void checkProductMarketPrice(Product product, List<Sku> skuList) {
        // 对传入的sku集合进行校验,sku的价格不可以大于商品原价
        if (null == product.getMarketPrice()) {
            throw new BizException(GlobalErrorCode.INVALID_ARGUMENT, "商品原价不能为空");
        }

        for (Sku temp : skuList) {
            if (null == temp.getPrice()) {
                throw new BizException(GlobalErrorCode.INVALID_ARGUMENT, "sku价格不能为空");
            }

            // 如果sku价格大于商品原价，则向上抛出异常
            if (temp.getPrice().compareTo(product.getMarketPrice()) == 1) {
                throw new BizException(GlobalErrorCode.INVALID_ARGUMENT, "Sku价格不得大于商品原价");
            }
        }
    }

    @Override
    public Product loadProductById(Long productId) {
        return productMapper.selectByPrimaryKey(productId);
    }

    @Override
    public void saveSkuAndMapping(Product product, List<Sku> skuList, List<SkuMapping> skuMappingList, Integer bomsFlag) {
        Product oldProduct = loadProductById(product.getId());

        // 更新日志
        String preLog = JSONObject.toJSONString(oldProduct);

        // 检查sku和mapping是否合法，传入的数据校验
        checkSkuAndSkuMapping(skuList, skuMappingList);

        // 清除规格名规格值前后的空格
        trimSkuAndMapping(skuList, skuMappingList);

        // 检查sku和mapping是否合法，与商品已存在的sku和sku mapping校验，最终返回不重复的SKU集合
        List<Sku> saveSkuList = checkSkuAndSkuMappingByProduct(product, skuList, skuMappingList);

        // 给sku写入规格spec字符串
        initSkuSpec(saveSkuList, skuMappingList);
        // 适配老的客户端
        skuMappingList = adaptaOldClient(saveSkuList, skuMappingList);

        // 保存sku
        if (CollectionUtils.isNotEmpty(saveSkuList)) {
            saveProductSku(product, saveSkuList);
        }

        // 商品已有的SkuMapping集合
        List<SkuMapping> currentSkuMappingList = this.loadSkuMapping(product.getId());
        if (CollectionUtils.isEmpty(currentSkuMappingList)) {
            // 保存sku mapping
            saveProductSkuMapping(product, skuMappingList);
        }

        // 使用已经入库的商品规格值，生成带sku规格值的笛卡尔集
        List<Sku> descaresSkuList = generateDescaresSku(product);
        if (CollectionUtils.isNotEmpty(descaresSkuList)) {
            initSkuSpec(descaresSkuList, skuMappingList);

            List<Sku> currentSkuList = this.selectSkuListByProductId(product.getId(), SkuType.NORMAL);
            // 筛选出没有入库的笛卡尔集Sku集合
            List<Sku> generateSkuList = reserveDecaresSkuList(descaresSkuList, currentSkuList);

            // 入库
            saveProductSku(product, generateSkuList);
        }

        // 统一设置Sku Order值
        unifiedSkuOrder(product);

        // 更新商品
        productMapper.updateByPrimaryKeySelective(product);

        // 更新商品发货类型和仓库，根据ERP SKU身上的仓库值
        // updateProductInfoByErpWarehouse(product.getId(), warehouseValue);

        // 更新商品的库存和价格，库存为显示的sku库存总和，价格为sku中的最低价格
        updateProductAmountAndPriceIncludeBom(product.getId());

        // 清除商品缓存
        clearProductCache(product);

        // 商品变更通知社区搜索
        noticeProductUpdateToMeila(product.getCode());

        // 通知OMS更新商品信息
        if (null != bomsFlag && bomsFlag == 0) {
            this.syncProductToOMS(product.getId(), product.getShopId());
        }

        // 记录日志
        HashMap<String, Object> afterMap = Maps.newHashMap();
        afterMap.put("product", product);
        afterMap.put("saveSkuList", saveSkuList);
        afterMap.put("skuMappingList", skuMappingList);
        String afterLog = JSONObject.toJSONString(afterMap);
        log.debug("update product log,productId:{},log:{}", product.getId(), afterLog);
        productUpdateLogMapper
            .insert(new ProductUpdateLog(0, preLog, afterLog, product.getUserId(), ProductUpdateLog.SystemEnum.SELLERPC, product.getId()));

    }

    private void unifiedSkuOrder(Product product) {
        log.debug("统一设置Sku Order值 unifiedSkuOrder,productId:{}", product.getId());

        // 排序值
        int order = 1;

        List<Sku> skuList = this.selectSkuListByProductId(product.getId(), null);

        for (Sku sku : skuList) {
            sku.setSkuOrder(order++);
            if (null != sku.getId()) {
                skuMapper.updateByPrimaryKeySelective(sku);
            }
        }
    }

    private List<Sku> reserveDecaresSkuList(List<Sku> decaresSkuList, List<Sku> currentSkuList) {
        List<Sku> saveSkuList = Lists.newArrayList();

        if (CollectionUtils.isNotEmpty(currentSkuList)) {
            // 已存在的Sku的规格长度
            int currentSkuSpecSize = 0;
            // 传入的Sku的规格长度
            int skuSpecSize = 0;
            // 比较Sku规格值相同的次数
            int compareSpecSize = 0;

            // 遍历Sku，剔除重复规格值的Sku
            for (Sku sku : decaresSkuList) {
                // 当前sku和已有的sku进行比较，记录重复的次数
                int validLength = 0;

                for (Sku currentSku : currentSkuList) {
                    // 比较每行每列规格值是否完全一致，一致则剔除
                    for (int index = 1; index <= skuMappingMaxLen; index++) {
                        String currentSpecValue = (String) Reflections.getFieldValue(currentSku, "spec" + index);
                        String specValue = (String) Reflections.getFieldValue(currentSku, "spec" + index);

                        // 空值比较会返回true，需要进行空值判断
                        if (StringUtils.equals(currentSpecValue, specValue) && StringUtils.isNotBlank(currentSpecValue)
                                && StringUtils.isNotBlank(specValue)) {
                            compareSpecSize++;
                        }

                        if (StringUtils.isNotBlank(currentSpecValue)) {
                            currentSkuSpecSize++;
                        }

                        if (StringUtils.isNotBlank(specValue)) {
                            skuSpecSize++;
                        }
                    }

                    // 规格值长度不一致，参数有问题
                    if (currentSkuSpecSize != skuSpecSize) {
                        throw new BizException(GlobalErrorCode.INVALID_ARGUMENT, "传入的sku规格值长度与已有的sku规格值长度不一致");
                    }

                    // 规格值完全一致，跳出循环
                    if (currentSkuSpecSize == compareSpecSize) {
                        validLength++;
                        break;
                    }

                    // 重置计数器
                    currentSkuSpecSize = 0;
                    skuSpecSize = 0;
                    compareSpecSize = 0;
                }

                // 如果完全没有重复，则加入待入库Sku集合
                if (validLength == 0) {
                    saveSkuList.add(sku);
                }
            }

            return saveSkuList;
        } else {
            return decaresSkuList;
        }
    }

    private List<Sku> generateDescaresSku(Product product) {
        // 原始规格值集合
        List<List<String>> sourceList = Lists.newArrayList();

        // 商品已有的Sku集合
        List<Sku> currentSkuList = this.selectSkuListByProductId(product.getId(), SkuType.NORMAL);

        // 规格值是一个不可重复的集合
        Set<String> specValue1Set = Sets.newHashSet();
        Set<String> specValue2Set = Sets.newHashSet();
        Set<String> specValue3Set = Sets.newHashSet();
        Set<String> specValue4Set = Sets.newHashSet();
        Set<String> specValue5Set = Sets.newHashSet();

        for (Sku sku : currentSkuList) {
            for (int index = 1; index <= skuMappingMaxLen; index++) {
                String specValue = (String) Reflections.getFieldValue(sku, "spec" + index);

                if (StringUtils.isNotBlank(specValue)) {
                    switch (index) {
                        case 1:
                            specValue1Set.add(specValue);
                            break;
                        case 2:
                            specValue2Set.add(specValue);
                            break;
                        case 3:
                            specValue3Set.add(specValue);
                            break;
                        case 4:
                            specValue4Set.add(specValue);
                            break;
                        case 5:
                            specValue5Set.add(specValue);
                            break;
                        default:
                            break;
                    }

                }
            }
        }

        // 转换为集合
        List<String> specValue1List = Lists.newArrayList(specValue1Set);
        List<String> specValue2List = Lists.newArrayList(specValue2Set);
        List<String> specValue3List = Lists.newArrayList(specValue3Set);
        List<String> specValue4List = Lists.newArrayList(specValue4Set);
        List<String> specValue5List = Lists.newArrayList(specValue5Set);

        if (specValue1List.size() > 0) {
            sourceList.add(specValue1List);
        }

        if (specValue2List.size() > 0) {
            sourceList.add(specValue2List);
        }

        if (specValue3List.size() > 0) {
            sourceList.add(specValue3List);
        }

        if (specValue4List.size() > 0) {
            sourceList.add(specValue4List);
        }

        if (specValue5List.size() > 0) {
            sourceList.add(specValue5List);
        }

        List<List<String>> result = Lists.newArrayList();

        if (CollectionUtils.isNotEmpty(sourceList)) {
            // 生成笛卡尔集
            descares(sourceList, result, 0, new ArrayList<String>());
        }

        // 生成的新Sku集合
        List<Sku> newSkuList = Lists.newArrayList();

        if (CollectionUtils.isNotEmpty(result)) {

            for (List<String> list : result) {
                Sku sku = new Sku();
                sku.setPrice(new BigDecimal("0"));
                sku.setAmount(0);
                sku.setIsDisplay(SkuDisplayType.HIDE);
                sku.setProductId(product.getId());

                for (int i = 1; i <= list.size(); i++) {
                    // 依次给新的sku设置规格值
                    Reflections.setFieldValue(sku, "spec" + i, list.get(i - 1));
                }

                newSkuList.add(sku);
            }
        }

        return newSkuList;
    }

    private void descares(List<List<String>> dimvalue, List<List<String>> result, int layer, List<String> curList) {
        // 大于一个集合时
        if (layer < dimvalue.size() - 1) {
            // 大于一个集合时，第一个集合为空
            if (dimvalue.get(layer).size() == 0) {
                descares(dimvalue, result, layer + 1, curList);
            } else {
                for (int i = 0; i < dimvalue.get(layer).size(); i++) {
                    List<String> list = Lists.newArrayList(curList);
                    list.add(dimvalue.get(layer).get(i));
                    descares(dimvalue, result, layer + 1, list);
                }
            }
        }
        // 只有一个集合时：
        else if (layer == dimvalue.size() - 1) {
            // 只有一个集合，且集合中没有元素
            if (dimvalue.get(layer).size() == 0) {
                result.add(curList);
            } else {
                // 只有一个集合，且集合中有元素时：其笛卡尔积就是这个集合元素本身
                for (int i = 0; i < dimvalue.get(layer).size(); i++) {
                    List<String> list = Lists.newArrayList(curList);
                    list.add(dimvalue.get(layer).get(i));
                    result.add(list);
                }
            }
        }
    }

    private void saveProductSkuMapping(Product product, List<SkuMapping> skuMappingList) {
        // 排序值
        int order = 1;

        for (SkuMapping skuMapping : skuMappingList) {
            skuMapping.setOrder(order++);

            if (null == skuMapping.getId()) {
                skuMapping.setProductId(product.getId());
                skuMappingMapper.insert(skuMapping);
            } else {
                skuMappingMapper.updateByPrimaryKeySelective(skuMapping);
            }
        }
    }

    @Override
    public void saveProductSku(Product product, List<Sku> skuList) {
        // 排序值
        int order = 1;

        for (Sku sku : skuList) {
            sku.setSkuOrder(order++);

            // 如果sku没有设置显示属性，则默认为显示
            if (null == sku.getIsDisplay()) {
                sku.setIsDisplay(SkuDisplayType.SHOW);
            }

            // 如果sku没有设置sku_type属性，则默认为NORMAL
            if (null == sku.getSkuType()) {
                sku.setSkuType(SkuType.NORMAL);
            }

            // 如果sku中的market_price为空，则把商品中的market_price赋给sku
            if (null == sku.getMarketPrice()) {
                sku.setMarketPrice(product.getMarketPrice());
            }

            if (null == sku.getId()) {
                sku.setProductId(product.getId());
                this.saveSku(sku);
            } else {
                int count = skuMapper.updateByPrimaryKeySelective(sku);

                if (count == 0) {
                    throw new BizException(GlobalErrorCode.INVALID_ARGUMENT, "sku [" + sku.getSpec() + "]更新失败");
                }
            }

            // 保存仓库信息 TODO
            this.saveSkuExt(sku);
        }
    }

    private void saveSkuExt(Sku sku) {
        if (null == sku || null == sku.getSkuExt()) {
            return;
        }

        List<SkuExt> skuExtList = null;
        if (null != sku.getId()) {
            // 此处请注意Ext正常情况下应该是一对一，List接收是为了防止重复数据出错
            skuExtList = skuExtMapper.selectBySkuId(sku.getId());
        }

        if (CollectionUtils.isNotEmpty(skuExtList)) {
            SkuExt ext = skuExtList.get(0);

            ext.setOutsideSkuCode(sku.getSkuExt().getOutsideSkuCode());

            log.debug("update sku ext,id:{},skuId:{},outSideCode:{}", ext.getId(), sku.getId(), sku.getSkuExt().getOutsideSkuCode());

            this.skuExtMapper.updateByPrimaryKeySelective(ext);
            return;
        } else {
            SkuExt skuExt = sku.getSkuExt();

            skuExt.setSkuId(sku.getId());
            skuExt.setCreatedAt(new Date());

            log.debug("insert sku ext,skuId:{},warehouseCode:{},outSideCode:{}", sku.getId(), sku.getSkuExt().getOutsideSkuCode());

            skuExtMapper.insert(sku.getSkuExt());
        }
    }

    private List<SkuMapping> adaptaOldClient(List<Sku> skus, List<SkuMapping> mappings) {

        if (mappings != null && mappings.size() > 0)
            return mappings;

        List<SkuMapping> skuMappings = new ArrayList<SkuMapping>();

        if (skus.size() == 1 && "无".equals(skus.get(0).getSpec()) || "无".equals(skus.get(0).getSpec1())) {
            skus.get(0).setSpec("无");
            skus.get(0).setSpec1("无");
            return mappings;
        }

        for (Sku sku : skus) {
            sku.setSpec1(sku.getSpec());
            sku.setSpec2(null);
        }

        SkuMapping skuMapping = new SkuMapping();
        skuMapping.setSpecKey("spec1");
        skuMapping.setSpecName("型号");
        skuMappings.add(skuMapping);

        return skuMappings;
    }

    private void initSkuSpec(List<Sku> skus, List<SkuMapping> skuMappings) {
        if (skuMappings == null || skuMappings.size() == 0) {
            return;
        }
        StringBuffer spec = null;
        for (Sku sku : skus) {
            spec = null;
            for (SkuMapping skuMapping : skuMappings) {
                if (spec == null) {
                    spec = new StringBuffer("");
                } else {
                    spec.append(";");
                }
                spec.append(skuMapping.getSpecName() + ":" + (String) Reflections.getFieldValue(sku, skuMapping.getSpecKey()));
            }
            sku.setSpec(spec.toString());
        }
    }

    private List<Sku> checkSkuAndSkuMappingByProduct(Product product, List<Sku> skuList, List<SkuMapping> skuMappingList) {
        // 商品已有的SkuMapping集合
        List<SkuMapping> currentSkuMappingList = this.loadSkuMapping(product.getId());

        if (CollectionUtils.isNotEmpty(currentSkuMappingList)) {
            // 已存在的规格长度
            int currentMappingSize = currentSkuMappingList.size();
            // 传入的规格长度
            int mappingListSize = skuMappingList.size();

            // 长度不一致，则视为非法参数
            if (currentMappingSize != mappingListSize) {
                throw new BizException(GlobalErrorCode.INVALID_ARGUMENT, "传入的规格长度与已有的规格长度不一致");
            }

            // 如果长度一致，则校验规格名称以及key是否一致
            for (int index = 0; index < currentMappingSize; index++) {
                SkuMapping currentSkuMapping = currentSkuMappingList.get(index);
                SkuMapping skuMapping = skuMappingList.get(index);

                if (!StringUtils.equals(currentSkuMapping.getSpecKey(), skuMapping.getSpecKey())) {
                    throw new BizException(GlobalErrorCode.INVALID_ARGUMENT, "传入的SpecKey与已有的SpecKey不一致");
                }

                if (!StringUtils.equals(currentSkuMapping.getSpecName(), skuMapping.getSpecName())) {
                    throw new BizException(GlobalErrorCode.INVALID_ARGUMENT, "传入的SpecName与已有的SpecName不一致");
                }

            }
        }

        checkProductMarketPrice(product, skuList);

        // 商品已有的Sku集合
        List<Sku> currentSkuList = this.selectSkuListByProductId(product.getId(), SkuType.NORMAL);

        // 首先对传入的集合进行去重
        skuList = uniqueDuplicationList(skuList);

        // 然后处理传入的集合和已有的sku集合重复项，删除重复项
        List<Sku> duplicationList = removeDuplicationList(skuList, currentSkuList);

        return duplicationList;

    }

    /**
     * 删除重复的Sku，返回干净的Sku集合
     * 
     * @param skuList 新的sku集合
     * @param currentSkuList 原有的sku集合
     * @return List&lt;Sku&gt; 干净的Sku集合
     * @exception {说明在某情况下,将发生什么异常}
     */
    private List<Sku> removeDuplicationList(List<Sku> skuList, List<Sku> currentSkuList) {
        List<Sku> saveSkuList = Lists.newArrayList();

        if (CollectionUtils.isNotEmpty(currentSkuList)) {
            // 已存在的Sku的规格长度
            int currentSkuSpecSize = 0;
            // 传入的Sku的规格长度
            int skuSpecSize = 0;
            // 比较Sku规格值相同的次数
            int compareSpecSize = 0;

            // 遍历Sku，剔除重复规格值的Sku
            for (Sku sku : skuList) {
                // 当前sku和已有的sku进行比较，记录重复的次数
                int validLength = 0;

                for (Sku currentSku : currentSkuList) {
                    // 比较每行每列规格值是否完全一致，一致则剔除
                    for (int index = 1; index <= skuMappingMaxLen; index++) {
                        String currentSpecValue = (String) Reflections.getFieldValue(currentSku, "spec" + index);
                        String specValue = (String) Reflections.getFieldValue(sku, "spec" + index);

                        // 空值比较会返回true，需要进行空值判断
                        if (StringUtils.equals(currentSpecValue, specValue) && StringUtils.isNotBlank(currentSpecValue)
                                && StringUtils.isNotBlank(specValue)) {
                            compareSpecSize++;
                        }

                        if (StringUtils.isNotBlank(currentSpecValue)) {
                            currentSkuSpecSize++;
                        }

                        if (StringUtils.isNotBlank(specValue)) {
                            skuSpecSize++;
                        }
                    }

                    // 规格值长度不一致，参数有问题
                    if (currentSkuSpecSize != skuSpecSize) {
                        throw new BizException(GlobalErrorCode.INVALID_ARGUMENT, "传入的sku规格值长度与已有的sku规格值长度不一致");
                    }

                    // 规格值完全一致
                    if (currentSkuSpecSize == compareSpecSize) {
                        validLength++;

                        if (!saveSkuList.contains(sku)) {
                            sku.setId(currentSku.getId());
                            saveSkuList.add(sku);
                        }
                    }

                    // 重置计数器
                    currentSkuSpecSize = 0;
                    skuSpecSize = 0;
                    compareSpecSize = 0;
                }

                // 如果完全没有重复，则加入待入库Sku集合
                if (validLength == 0) {
                    saveSkuList.add(sku);
                }
            }

            return saveSkuList;
        } else {
            return skuList;
        }
    }

    /**
     * 集合去重
     * 
     * @param skuList sku集合
     * @return List&lt;Sku&gt;去重后的Sku集合
     * @exception {说明在某情况下,将发生什么异常}
     */
    private List<Sku> uniqueDuplicationList(List<Sku> skuList) {
        List<Sku> saveSkuList = Lists.newArrayList();

        if (CollectionUtils.isNotEmpty(skuList)) {
            // 使用HashSet去重复，需要重写Sku的equals和hashcode方法
            /*
             * HashSet<Sku> set = new HashSet<Sku>(skuList); saveSkuList.addAll(set);
             */

            // 判断是否已经存在相同的sku规格值在临时集合中
            for (Sku sku : skuList) {
                if (!containSkuForList(sku, saveSkuList)) {
                    saveSkuList.add(sku);
                }
            }

        }

        return saveSkuList;
    }

    /**
     * sku是否已经存在集合中
     * 
     * @param sku 最小库存单位
     * @param saveSkuList 被检查的sku集合
     * @return boolean 布尔值
     * @exception {说明在某情况下,将发生什么异常}
     */
    private boolean containSkuForList(Sku sku, List<Sku> saveSkuList) {
        // sku的规格值长度
        int skuSpecSize = 0;
        // sku的规格值比较相同次数
        int compareSpecCount = 0;
        // 是否存在相同的sku标识位
        int containLength = 0;

        for (Sku validSku : saveSkuList) {
            for (int index = 1; index <= skuMappingMaxLen; index++) {
                String currentSpecValue = (String) Reflections.getFieldValue(sku, "spec" + index);
                String specValue = (String) Reflections.getFieldValue(validSku, "spec" + index);

                if (StringUtils.equals(currentSpecValue, specValue) && StringUtils.isNotBlank(currentSpecValue)
                        && StringUtils.isNotBlank(specValue)) {
                    compareSpecCount++;
                }

                if (StringUtils.isNotBlank(currentSpecValue)) {
                    skuSpecSize++;
                }
            }

            if (skuSpecSize == compareSpecCount) {
                containLength++;
            }

            skuSpecSize = 0;
            compareSpecCount = 0;
        }

        if (containLength > 0) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * 清除规格名规格值前后的空格
     * 
     * @param skuList SKU集合
     * @param skuMappingList SKU Mapping集合
     * @return void 空
     * @exception {说明在某情况下,将发生什么异常}
     */
    private void trimSkuAndMapping(List<Sku> skuList, List<SkuMapping> skuMappingList) {
        if (CollectionUtils.isNotEmpty(skuMappingList)) {
            for (SkuMapping skuMapping : skuMappingList) {
                skuMapping.setSpecKey(StringUtils.trim(skuMapping.getSpecKey()));
                skuMapping.setSpecName(StringUtils.trim(skuMapping.getSpecName()));
            }
        }

        if (CollectionUtils.isNotEmpty(skuList)) {
            for (Sku sku : skuList) {
                for (SkuMapping skuMapping : skuMappingList) {
                    String currentSpec = (String) Reflections.getFieldValue(sku, skuMapping.getSpecKey());
                    Reflections.setFieldValue(sku, skuMapping.getSpecKey(), StringUtils.trim(currentSpec));
                }
            }
        }
    }

    /**
     * 检查sku和skuMapping是否符合
     * 
     * @param skus
     * @param skuMappings
     * @return
     */
    private boolean checkSkuAndSkuMapping(List<Sku> skus, List<SkuMapping> skuMappings) {
        if (skuMappings == null || skuMappings.size() == 0)
            return true;

        /**
         * sku和skuMapping是否按顺序设置
         */
        String specPrefix = "spec";
        for (int i = skuMappingMaxLen; i > 0; i--) {
            for (SkuMapping skuMapping : skuMappings) {
                if (skuMapping.getSpecKey().equals(specPrefix + "i") && i > skuMappings.size()) {
                    throw new BizException(GlobalErrorCode.INVALID_ARGUMENT, "请依次设置sku mapping的spec值");
                }

                if (StringUtils.isBlank(skuMapping.getSpecName()) || StringUtils.isBlank(skuMapping.getSpecKey())) {
                    throw new BizException(GlobalErrorCode.INVALID_ARGUMENT, "skuMapping specName 和specKey 不能为空");
                }

            }
            for (Sku sku : skus) {
                if (StringUtils.isNoneBlank(sku.getSpec())) {
                    throw new BizException(GlobalErrorCode.INVALID_ARGUMENT, "sku的spec不能有值");
                }

                if (StringUtils.isNotBlank((String) Reflections.getFieldValue(sku, "spec" + i)) && i > skuMappings.size()) {
                    throw new BizException(GlobalErrorCode.INVALID_ARGUMENT, "请依次设置sku的spec值或者spec的数量大于mapping的数量");
                }
            }
        }

        /**
         * 检查skuMapping有无对应的sku的spec1/2/3/4/5
         */
        for (Sku sku : skus) {
            for (SkuMapping skuMapping : skuMappings) {
                if (StringUtils.isBlank((String) Reflections.getFieldValue(sku, skuMapping.getSpecKey())))
                    throw new BizException(GlobalErrorCode.INVALID_ARGUMENT,
                        "sku的" + skuMapping.getSpecName() + "的" + skuMapping.getSpecKey() + "不能为空");
            }

        }
        return true;
    }

    @Override
    public List<Sku> selectSkuExtBySkuList(List<Sku> skuList) {
        if (CollectionUtils.isEmpty(skuList)) {
            return Collections.emptyList();
        }

        List<Long> skuIdList = Lists.newArrayList();

        for (Sku sku : skuList) {
            skuIdList.add(sku.getId());
        }

        log.debug("select sku ext by sku list,sku id list:{}", skuIdList);
        List<SkuExt> skuExtList = skuExtMapper.selectBySkuIdList(skuIdList);

        if (CollectionUtils.isEmpty(skuExtList)) {
            return skuList;
        }

        // setSkuExtToSku(skuList, skuExtList);

        return skuList;
    }

    @Override
    public List<SkuMapping> loadSkuMapping(Long productId) {
        List<SkuMapping> skuMappings = skuMappingMapper.selectByProductId(productId);
        return skuMappings;
    }

    @Override
    public void getErpSkuWarehouseInfo(List<Sku> saveSkuist) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Product> selectProductListByShopId(Long id) {
        return productMapper.selectProductListByShopId(id);
    }

    @Override
    public ProductInfo selectProductInfoBySkuId(Long subSkuId) {
        return productInfoMapper.selectProductInfoBySkuId(subSkuId);
    }

    @Override
    public ProductInfo loadProduvtExtByProductId(Long productId) {
        return productInfoMapper.selectByProductId(productId);

    }

    /**
     * 处理WMS通知的库存变化信息
     */
    @Override
    public void updateInv(DubboInvNotify temp) {
        SkuWMSInvLog skuWMSInvLog = BeanMapper.map(temp, SkuWMSInvLog.class);
        skuWMSInvLog.setReqCreateTime(temp.getCreateTime());
        skuWMSInvLog.setCreateTime(new Date(System.currentTimeMillis()));
        skuWMSInvLogMapper.insertSelective(skuWMSInvLog);

        // 当销售订单出库时进行锁定库存释放
        Integer lockNum = 0;
        if (SkuInvChangeType.CM == temp.getType()) {
            lockNum = temp.getChangeNum();
        }
        int updateNum = skuWMSInvMapper.updateInv(temp.getSkuId(), temp.getChangeNum(), lockNum);
        // 如果数据库中原本没有数据,则初始化数据为0
        if (0 == updateNum) {
            SkuWMSInv record = new SkuWMSInv();
            record.setSkuId(temp.getSkuId());
            record.setArchive(false);
            record.setLockInv(0);
            record.setRealInv(0);
            record.setCreateTime(new Date(System.currentTimeMillis()));
            record.setUpdateTime(new Date(System.currentTimeMillis()));
            skuWMSInvMapper.insertSelective(record);
            // 更新数据
            skuWMSInvMapper.updateInv(temp.getSkuId(), temp.getChangeNum(), lockNum);
        }

    }

    /**
     * 处理库存转移的情况
     */
    @Override
    public void updateInvOfTR(DubboInvNotify temp) {
        String[] skuIds = temp.getSkuId().split("\\|");
        if (skuIds.length != 2) {
            throw new ServiceException("skuID信息错误");
        }

        SkuWMSInvLog skuWMSInvLog = BeanMapper.map(temp, SkuWMSInvLog.class);
        skuWMSInvLog.setReqCreateTime(temp.getCreateTime());
        skuWMSInvLog.setCreateTime(new Date(System.currentTimeMillis()));
        skuWMSInvLogMapper.insertSelective(skuWMSInvLog);
        Integer lockNum = 0;

        int updateNum = skuWMSInvMapper.updateInv(skuIds[0], temp.getChangeNum(), lockNum);

        if (0 == updateNum) {
            SkuWMSInv record = new SkuWMSInv();
            record.setSkuId(skuIds[0]);
            record.setArchive(false);
            record.setLockInv(0);
            record.setRealInv(0);
            record.setCreateTime(new Date(System.currentTimeMillis()));
            record.setUpdateTime(new Date(System.currentTimeMillis()));
            skuWMSInvMapper.insertSelective(record);

            // 更新数据
            skuWMSInvMapper.updateInv(skuIds[0], temp.getChangeNum(), lockNum);
        }

        updateNum = skuWMSInvMapper.updateInv(skuIds[1], -temp.getChangeNum(), lockNum);

        if (0 == updateNum) {
            SkuWMSInv record = new SkuWMSInv();
            record.setSkuId(skuIds[1]);
            record.setArchive(false);
            record.setLockInv(0);
            record.setRealInv(0);
            record.setCreateTime(new Date(System.currentTimeMillis()));
            record.setUpdateTime(new Date(System.currentTimeMillis()));
            skuWMSInvMapper.insertSelective(record);

            // 更新数据
            skuWMSInvMapper.updateInv(skuIds[1], -temp.getChangeNum(), lockNum);
        }
    }

    @Override
    public int instock(Long productId, Long userId) {
        Product product = load(productId);

        if (Boolean.TRUE.equals(product.getUpdateLock())) {
            throw new ServiceException("商品参与的促销活动活动正在进行中，商品不能编辑");
        }

        if (!product.getUserId().equals(userId)) {
            throw new ServiceException("当前用户与卖家不匹配");
        }

        // List<Product> aList = new ArrayList<Product>();
        // aList.add(product);
        // pushSyncQueue(KDSyncData.XIANGQU_DST, SyncEventType.STATUS_INSTOCK, aList);

        int row = productMapper.updateForInstock(productId);

        // 商品变更通知社区搜索
        noticeProductUpdateToMeila(product.getCode());

        clearProductCache(product);

        return row;
    }

    private Product load(Long id) {
        Product product = productMapper.selectByPrimaryKey(id);
        return product;
    }

    @Override
    public int putOnShelves(Long productId, Long userId) {
        Product product = this.loadProductById(productId);
        if (null == product) {
            return 0;
        }

        // 商品不属于当前用户则不可操作
        if (!product.getUserId().equals(userId)) {
            return 0;
        }

        // 查找该商品下的sku集合
        List<Sku> skuList = selectSkuListByProductId(productId, null);
        if (CollectionUtils.isEmpty(skuList)) {
            return 0;
        }

        int row = productMapper.updateForOnsale(productId);

        // 商品变更通知社区搜索
        noticeProductUpdateToMeila(product.getCode());

        clearProductCache(product);

        // this.syncProductToOMS(id);

        return row;
    }

    @Override
    public List<Product> listProductsBySales(Long shopId, Map<String, Long> page, Direction direction) {
        return productMapper.listProductsBySales(shopId, page, direction);

    }

    @Override
    public List<Product> listProductsBySales1(Long shopId, Map<String, Object> page, Direction direction) {
        return productMapper.listProductsBySales1(shopId, page, direction);

    }

    @Override
    public List<Product> listProductsByAmount(Long shopId, Map<String, Long> page, Direction direction) {
        return productMapper.listProductsByAmount(shopId, page, direction);

    }

    @Override
    public List<Product> listProductsByAmount1(Long shopId, Map<String, Object> page, Direction direction) {
        return productMapper.listProductsByAmount1(shopId, page, direction);

    }

    @Override
    public List<Product> listProductsBySoldout(Long shopId, Map<String, Long> page, Direction direction) {
        return productMapper.listProductsBySoldout(shopId, page, direction);
    }

    @Override
    public List<Product> listProductsBySoldout1(Long shopId, Map<String, Object> page, Direction direction) {
        return productMapper.listProductsBySoldout1(shopId, page, direction);
    }

    @Override
    public List<Product> listProductsByStatusDraft(Long shopId, Map<String, Long> page) {
        return productMapper.listProductsByStatusDraft(shopId, page);

    }

    @Override
    public List<Product> listProductsByStatusDraft1(Long shopId, Map<String, Object> page) {
        return productMapper.listProductsByStatusDraft1(shopId, page);

    }

    @Override
    public List<Product> listProductsByOutOfStock(Long shopId, Map<String, Long> page) {
        return productMapper.listProductsByOutOfStock(shopId, page);

    }

    @Override
    public List<Product> listProductsByOutOfStock1(Long shopId, Map<String, Object> page) {
        return productMapper.listProductsByOutOfStock1(shopId, page);

    }

    @Override
    public List<Product> listProductsByPostAge(Long shopId, Map<String, Long> pageable, Direction direction) {
        if (shopId == null)
            return null;

        List<Product> list = listProductsByOnsaleAt(shopId, null, new HashMap<String, Object>());
        ShopPostAge sp = shopPostAgeService.getPostAgeByShop(shopId);
        List<Product> frees = new ArrayList<Product>();
        List<Product> others = new ArrayList<Product>();
        if (sp != null && sp.getFreeShippingGoods() != null) {
            for (Product p : list) {
                if (sp.getFreeShippingGoods().contains(p.getId())) {
                    p.setFreePostage(true);
                    frees.add(p);
                } else {
                    p.setFreePostage(false);
                    others.add(p);
                }
            }
        } else if (sp.getFreeShippingGoods() == null) {
            return list;
        }
        if (Direction.DESC.equals(direction)) {
            others.addAll(frees);
            return others;
        } else {
            frees.addAll(others);
            return frees;
        }
    }

    @Override
    public List<Product> listProductsByOnsaleAt(Long shopId, Map<String, Long> page) {
        return listProductsByOnsaleAt(shopId, page, new HashMap<String, Object>());

    }

    @Override
    public List<Product> searchProduct(Map<String, Object> params, Map<String, Long> page) {
        return productMapper.searchProduct(params, page);
    }

    private List<Product> listProductsByOnsaleAt(Long shopId, Map<String, Long> page, HashMap<String, Object> params) {
        return productMapper.listProductsByOnsaleAt(shopId, page, params);

    }

    @Override
    public Long getLastTotalCnt(Long shopId, String catType, HashMap<String, Object> params) {
        return productMapper.selectLastCnt(shopId, catType, params);
    }

    @Override
    public Long querySpuPageNum(Product product, Map<String, Long> page) {
        return productMapper.countBySelective(product, page);
    }

    public List<Product> selectBySelective(Product record) {
        HashMap<String, Long> params = Maps.newHashMap();
        return productMapper.selectBySelective(record, params);
    }

    @Override
    public List<Product> selectByPage(Product record, Map<String, Long> params) {
        return productMapper.selectBySelective(record, params);
    }

    @Override
    public int updateProductLog(DubboUpdateProductAndExtRequest req, ProductUpdateLog plog, Map<String, Object> infoMap, Product beforeProduct) {
        if (req == null || plog == null) {
            return 0;
        }
        // 0:更新轮播图首图
        updCarouselImg(req.getImg(), req.getProductId());

        // 1:更新商品信息 vdlm_product
        int i = 0;

        if (req.getOnlyUpdSales()) {
            if (req.getFakeSales() == null) {
                req.setFakeSales(0);
            }
            i = productMapper.updateFakeSales(req.getProductId(), req.getFakeSales());
        } else {

            Product record = BeanMapper.map(req, Product.class);
            i = productMapper.updateByPrimaryKeySelective(record);
        }

        ProductStatus pStatus = null;
        if (!StringUtils.isEmpty(req.getStatus())) {
            pStatus = ProductStatus.valueOf(req.getStatus());
        }

        /*
         * 2:修改商品状态时对应更新上下架时间
         */
        if (pStatus != beforeProduct.getStatus()) {
            if (pStatus == ProductStatus.ONSALE) {

                List<Sku> skuIdList = skuMapper.selectByProductId(req.getProductId());
                ProductInfo productInfo = productInfoMapper.selectByProductId(req.getProductId());
                Shop shop = shopMapper.selectByPrimaryKey(beforeProduct.getShopId());

                String sellerSource = shop.getSellerSource();
                if (!StringUtils.isEmpty(sellerSource)) {
                    String deliveryType = productInfo.getDeliveryType();
                    String warehouse = productInfo.getWarehouse();
                    if (StringUtils.isEmpty(deliveryType)) {
                        throw new ServiceException(ProductReturnCode.SPU_INSTOCK_FAILED, "发货方式不能为空");
                    }

                    if ("OUTSIDE".equals(sellerSource)) {
                        if ("MEILA".equals(deliveryType) && StringUtils.isEmpty(warehouse)) {
                            throw new ServiceException(ProductReturnCode.SPU_INSTOCK_FAILED, "美啦代发货,仓库信息不能为空");

                        }

                    } else if ("INSIDE".equals(sellerSource)) {
                        if (StringUtils.isEmpty(warehouse)) {
                            throw new ServiceException(ProductReturnCode.SPU_INSTOCK_FAILED, "内部卖家仓库信息不能为空");

                        }
                    } else {
                        throw new ServiceException(ProductReturnCode.SPU_INSTOCK_FAILED, "卖家类型不能为空");

                    }

                } else {
                    throw new ServiceException(ProductReturnCode.SPU_INSTOCK_FAILED, "卖家来源不能为空");

                }

                if (Collections3.isEmpty(skuIdList)) {
                    throw new ServiceException(ProductReturnCode.SPU_INSTOCK_FAILED, "sku不能为空");
                }

                // 更新上架时间
                productMapper.updateForOnsale(req.getProductId());

            } else if (pStatus == ProductStatus.INSTOCK) {
                // 更新下架时间
                productMapper.updateForInstock(req.getProductId());
            }
        }

        // 3:更新商品更多信息表 vdlm_product_info
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("short_intro", req.getShortIntro());
        params.put("short_name", req.getShortName());
        params.put("productPrefix", req.getProductPrefix());
        params.put("productSuffix", req.getProductSuffix());
        /*
         * params.put("ms_price",p.getMs_price()); params.put("start_time",p.getStart_time());
         * params.put("end_time",p.getEnd_time());
         */
        params.put("product_id", req.getProductId());// 商品id

        int j = 0;

        if (infoMap != null) {
            j = productUpdateLogMapper.updateSelectiveInfo(params);
        } else {
            j = productUpdateLogMapper.insertInfo(params);
        }
        if (i > 0) {
            // 2：插入记录表信息
            Product product2 = productMapper.selectByPrimaryKey(req.getProductId());
            product2.setDescription("");// 不记录描述信息
            HashMap<String, Object> afterMap = new HashMap<String, Object>();
            afterMap.put("product", product2);
            if (!req.getOnlyUpdSales()) {
                afterMap.put("infoMap", params);
            }
            plog.setAfterUpdate(JSONObject.toJSONString(afterMap));
            j = productUpdateLogMapper.insert(plog);
        }

        // 编辑商品需清除缓存 add at 2015-11-6
        clearProductCache(beforeProduct);
        return j;
    }

    private int updCarouselImg(String key, long id) {
        if (StringUtils.isBlank(key)) {
            return 0;
        }
        List<ProductImage> list = productImageMapper.selectByProductId(id);
        ProductImage firstImg = new ProductImage();
        int minOrder;
        if (list.size() > 0) {
            firstImg = list.get(0);
            minOrder = firstImg.getImgOrder();
            for (ProductImage img : list) {
                if (img.getImgOrder() < minOrder) {
                    minOrder = img.getImgOrder();
                    firstImg = img;
                }
            }
        }
        int i = 0;
        if (StringUtils.isNotBlank(firstImg.getImg())) {
            i = productUpdateLogMapper.updateImageById(firstImg.getId(), key);
        }
        return i;
    }

    @Override
    public void noticeProductUpdateToMeila(final Long id) {

        syncTaskExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    meilaClient.noticeProductUpdateToMeila(id);
                } catch (Exception e) {
                    log.error("商品变更通知社区失败: ", e);
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    public void noticeProductUpdateToOms(final Long productId) {
        syncTaskExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    List<Long> productIds = new ArrayList<Long>();
                    productIds.add(productId);
                    Product product = productMapper.selectByPrimaryKey(productId);
                    Map<String, Object> params = new HashMap<String, Object>();
                    log.debug("[shopId:{},productId:{}]", product.getShopId(), productId);
                    params.put("shopId", product.getShopId());
                    params.put("deliveryType", "MEILA");
                    Long cnt = shopMapper.countShopsByAdmin(params);
                    log.debug("wms商品同步[cnt,{}]", cnt);
                    if (cnt == 0) {
                        log.error("该商品所属店铺不是美啦代发货类型，不能同步到wms");
                    } else {
                        OmsJsonResult result = meiLaOmsClient.syncProduct(productIds);
                        log.debug("\n-------OmsJsonResult-------{}", JSONObject.toJSONString(result));
                        if (result.isSuccess()) {
                            log.debug("====通知oms处理成功====");
                        }
                    }
                } catch (Exception e) {
                    log.error("商品变更通知oms失败: ", e);
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    public List<Sku> querySkuPage(Sku sku, Map<String, Long> page) {
        return null;
    }

    @Override
    public Long querySkuPageNum(Sku sku, Map<String, Long> page) {
        return null;
    }

    @Override
    public List<Sku> querySkuByProductIds(List<Long> productIds) {
        List<Sku> skuList = skuMapper.querySkuByProductIds(productIds);
        return skuList;
    }

    @Override
    public List<Sku> querySku(List<Long> productIds, String skuType) {
        List<Sku> skuList = skuMapper.querySku(productIds, skuType);
        return skuList;
    }

    @Override
    public Long countProduct(Map<String, Object> params) {
        return productMapper.countProductBySearchParmas(params);
    }

    @Override
    public void lockInvBySkuId(DubboSkuAmountInfo temp) {
        SkuWMSInv skuWMSInvRecord = new SkuWMSInv();
        skuWMSInvRecord.setSkuId(temp.getSkuId());
        skuWMSInvRecord.setArchive(false);
        List<SkuWMSInv> resultList = skuWMSInvMapper.selectByselective(skuWMSInvRecord);

        if (Collections3.isEmpty(resultList)) {
            // return new DubboBasicResponse(ProductReturnCode.SKU_BUNDLE_EXIST, "没有库存信息");
            throw new ServiceException(ProductReturnCode.SKU_INVENTORY_NOT_ENOUGH, "没有库存信息");
        }
        SkuWMSInv skuWMSInv = resultList.get(0);

        int realInv = skuWMSInv.getRealInv();
        int lockInv = skuWMSInv.getLockInv();
        if (lockInv < 0) {
            lockInv = 0;
        }

        if (realInv - lockInv >= temp.getAmount()) {
            skuWMSInvRecord.setLockInv(lockInv + temp.getAmount());
            skuWMSInvRecord.setSkuInvId(skuWMSInv.getSkuInvId());
            Map<String, Object> params = Maps.newHashMap();
            params.put("oriLockInv", skuWMSInv.getLockInv());
            int updateNum = skuWMSInvMapper.lockInv(skuWMSInvRecord, params);
            if (0 == updateNum) {
                lockInvBySkuId(temp);
            }
        } else {
            throw new ServiceException(ProductReturnCode.SKU_INVENTORY_NOT_ENOUGH, "库存不够");
        }
    }

    @Override
    public void recoveryInvBySkuId(DubboSkuAmountInfo temp) {

        SkuWMSInv skuWMSInvRecord = new SkuWMSInv();
        skuWMSInvRecord.setSkuId(temp.getSkuId());
        List<SkuWMSInv> resultList = skuWMSInvMapper.selectByselective(skuWMSInvRecord);

        if (Collections3.isEmpty(resultList)) {
            // return new DubboBasicResponse(ProductReturnCode.SKU_BUNDLE_EXIST, "没有库存信息");
            throw new ServiceException(ProductReturnCode.SKU_BUNDLE_EXIST, "没有库存信息");
        }
        SkuWMSInv skuWMSInv = resultList.get(0);

        int realInv = skuWMSInv.getRealInv();
        int lockInv = skuWMSInv.getLockInv();

        skuWMSInvRecord.setLockInv(temp.getAmount());
        skuWMSInvRecord.setSkuInvId(skuWMSInv.getSkuInvId());
        skuWMSInvMapper.unlockInv(skuWMSInvRecord);

    }

    @Override
    public void lockInv(DubboLockInvRequest req) {
        SkuInvOperateLog record = new SkuInvOperateLog();
        record.setOrderNo(req.getOrderNo());
        record.setOperateType(SkuInvOperateType.LOCK.name());
        List<SkuInvOperateLog> skuInvOperateLogList = skuInvOperateLogMapper.selectBySelective(record);

        if (Collections3.isEmpty(skuInvOperateLogList)) {
            record.setCreateTime(new Date(System.currentTimeMillis()));
            record.setOperateType(SkuInvOperateType.LOCK.name());
            record.setArchive(false);
            skuInvOperateLogMapper.insert(record);
        } else {
            throw new ServiceException(ProductReturnCode.SUCCESS, "已经锁定库存");
        }

        List<DubboSkuAmountInfo> skuAmountInfoList = req.getSkuAmountInfoList();
        List<Long> ids = Lists.newArrayList();

        for (DubboSkuAmountInfo temp : skuAmountInfoList) {

            ids.add(Long.valueOf(temp.getSkuId()));
        }

        List<Sku> skuList = skuMapper.selectByIdList(ids);
        List<Long> productIdList = Lists.newArrayList();
        for (Sku temp : skuList) {
            productIdList.add(temp.getId());
        }

        Map<Long, Sku> skuMap = Maps.newHashMap();
        for (Sku temp : skuList) {
            skuMap.put(temp.getId(), temp);
        }

        List<ProductInfo> productInfoList = productInfoMapper.selectByProductIdList(productIdList);

        Map<Long, ProductInfo> productInfoMap = Maps.newHashMap();

        for (ProductInfo temp : productInfoList) {
            productInfoMap.put(temp.getProductId(), temp);
        }

        for (DubboSkuAmountInfo temp : skuAmountInfoList) {
            Sku sku = skuMap.get(Long.valueOf(temp.getSkuId()));
            if (null == sku) {
                throw new ServiceException(ProductReturnCode.SKU_NOT_EXIST, "sku不存在");
            }
            ProductInfo productInfo = productInfoMap.get(sku.getProductId());
            if (null != productInfo && productInfo.getStorageType() != null && productInfo.getStorageType().equals(StorageType.SPOT)) {
                if (StringUtils.isNoneBlank(sku.getErpSkuId())) {
                    temp.setSkuId(sku.getErpSkuId());

                }
                lockInvBySkuId(temp);
            }
        }
    }

    @Override
    public void recovery(DubboRecoveryInvRequest req) {
        SkuInvOperateLog record = new SkuInvOperateLog();
        record.setOrderNo(req.getOrderNo());
        record.setOperateType(SkuInvOperateType.UNLOCK.name());
        List<SkuInvOperateLog> skuInvOperateLogList = skuInvOperateLogMapper.selectBySelective(record);

        if (Collections3.isEmpty(skuInvOperateLogList)) {
            record.setCreateTime(new Date(System.currentTimeMillis()));
            record.setOperateType(SkuInvOperateType.UNLOCK.name());
            record.setArchive(false);

            skuInvOperateLogMapper.insert(record);
        } else {
            throw new ServiceException(ProductReturnCode.SUCCESS, "库存已经回退");
        }

        List<DubboSkuAmountInfo> skuAmountInfoList = req.getSkuAmountInfoList();
        List<Long> ids = Lists.newArrayList();

        for (DubboSkuAmountInfo temp : skuAmountInfoList) {

            ids.add(Long.valueOf(temp.getSkuId()));
        }

        List<Sku> skuList = skuMapper.selectByIdList(ids);
        List<Long> productIdList = Lists.newArrayList();
        for (Sku temp : skuList) {
            productIdList.add(temp.getId());
        }

        Map<Long, Sku> skuMap = Maps.newHashMap();
        for (Sku temp : skuList) {
            skuMap.put(temp.getId(), temp);
        }

        List<ProductInfo> productInfoList = productInfoMapper.selectByProductIdList(productIdList);

        Map<Long, ProductInfo> productInfoMap = Maps.newHashMap();

        for (ProductInfo temp : productInfoList) {
            productInfoMap.put(temp.getProductId(), temp);
        }

        for (DubboSkuAmountInfo temp : skuAmountInfoList) {
            Sku sku = skuMap.get(Long.valueOf(temp.getSkuId()));
            ProductInfo productInfo = productInfoMap.get(sku.getProductId());
            if (null != productInfo && productInfo.getStorageType() != null && productInfo.getStorageType().equals(StorageType.SPOT)) {
                if (StringUtils.isNotBlank(sku.getErpSkuId())) {
                    temp.setSkuId(sku.getErpSkuId());
                }
                recoveryInvBySkuId(temp);
            }
        }
    }

    @Override
    public void fixProductType(List<DubboProductV1> productList) {
        for (DubboProductV1 temp : productList) {
            if (StringUtils.isNotBlank(temp.getProductType())) {
                break;
            }
            List<Sku> skuList = skuMapper.selectByProductId(temp.getProductId());

            for (Sku tempSku : skuList) {
                if (StringUtils.isNotBlank(tempSku.getErpSkuId())) {
                    temp.setProductType(ProductType.ERP.name());
                    break;
                }
            }
            temp.setProductType(ProductType.NORMAL.name());
        }
    }

    @Override
    public void fixProductInfo(List<DubboProductV1> productList) {
        if (Collections3.isEmpty(productList)) {
            return;
        }

        List<Long> productIdList = Lists.newArrayList();
        for (DubboProductV1 temp : productList) {
            productIdList.add(temp.getProductId());
        }
        Map<Long, ProductInfo> productInfoMap = getProductInfoMap(productIdList);

        for (DubboProductV1 temp : productList) {
            ProductInfo productInfo = productInfoMap.get(temp.getProductId());
            if (null != productInfo) {
                productInfo.setCreatedAt(null);
                productInfo.setUpdatedAt(null);
                BeanMapper.copy(productInfo, temp);
            }
        }

        fixProductType(productList);
    }

    @Override
    public Map<Long, ProductInfo> getProductInfoMap(List<Long> productIdList) {
        Map<Long, ProductInfo> resultMap = Maps.newHashMap();
        List<ProductInfo> productInfoList = productInfoMapper.selectByProductIdList(productIdList);

        if (Collections3.isNotEmpty(productInfoList)) {
            for (ProductInfo temp : productInfoList) {
                resultMap.put(temp.getProductId(), temp);
            }
        }
        return resultMap;
    }

    @Override
    public void updateProductStatus(Long userId, Long productId, ProductStatus status, Date forsaleAt) {
        Product product = load(productId);

        if (ProductStatus.FORSALE.equals(status) && null == forsaleAt) {
            throw new ServiceException(ProductReturnCode.FAILED, "计划上架时间不能为空");
        }

        if (Boolean.TRUE.equals(product.getUpdateLock())) {
            throw new ServiceException(ProductReturnCode.FAILED, "商品参与的促销活动活动正在进行中，商品不能编辑");
        }

        if (!product.getUserId().equals(userId)) {
            throw new ServiceException(ProductReturnCode.FAILED, "当前用户与卖家不匹配");
        }

        if (ProductStatus.FORSALE.equals(status) || ProductStatus.ONSALE.equals(status)) {
            List<Sku> selectByProductId = skuMapper.selectByProductId(productId);
            if (Collections3.isEmpty(selectByProductId)) {
                throw new ServiceException(ProductReturnCode.FAILED, "没有sku不能上架");
            }
        }

        Product record = new Product();
        if (ProductStatus.FORSALE.equals(status)) {
            record.setForsaleAt(new Date(System.currentTimeMillis()));
        }
        if (ProductStatus.ONSALE.equals(status)) {
            record.setOnsaleAt(new Date(System.currentTimeMillis()));
        }

        if (ProductStatus.INSTOCK.equals(status)) {
            record.setInstockAt(new Date(System.currentTimeMillis()));
        }

        record.setId(productId);
        record.setStatus(status);
        record.setUpdatedAt(new Date(System.currentTimeMillis()));
        if (ProductStatus.FORSALE.equals(status)) {
            record.setForsaleAt(forsaleAt);
        }

        productMapper.updateByPrimaryKeySelective(record);

        // 商品变更通知社区搜索
        noticeProductUpdateToMeila(product.getCode());
        clearProductCache(product);
    }
}
