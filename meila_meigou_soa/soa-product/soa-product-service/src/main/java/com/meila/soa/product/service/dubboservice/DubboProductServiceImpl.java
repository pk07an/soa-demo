package com.meila.soa.product.service.dubboservice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Sort.Direction;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.meila.common.bean.utils.BeanMapper;
import com.meila.common.collection.utils.Collections3;
import com.meila.common.exceptions.ServiceException;
import com.meila.common.utils.StringUtils;
import com.meila.common.utils.date.DateUtil;
import com.meila.dubbo.base.constant.DubboReturnCode;
import com.meila.dubbo.base.model.DubboBasicPageRequest2.DubboSort;
import com.meila.dubbo.base.model.DubboBasicResponse;
import com.meila.soa.meila.client.service.MeiLaOmsClient;
import com.meila.soa.order.api.DubboOrderService;
import com.meila.soa.order.api.model.dto.OrderStatusEnum;
import com.meila.soa.order.api.model.request.DubboQueryOrderSellNumRequest;
import com.meila.soa.order.api.model.response.DubboQueryOrderSellNumResponse;
import com.meila.soa.product.api.DubboProductService;
import com.meila.soa.product.api.constant.ProductReturnCode;
import com.meila.soa.product.api.model.dto.DubboCategory;
import com.meila.soa.product.api.model.dto.DubboProduct;
import com.meila.soa.product.api.model.dto.DubboProductInvStatistic;
import com.meila.soa.product.api.model.dto.DubboProductSku;
import com.meila.soa.product.api.model.dto.DubboSku;
import com.meila.soa.product.api.model.dto.DubboSkuBasicInfo;
import com.meila.soa.product.api.model.dto.DubboSkuBundle;
import com.meila.soa.product.api.model.dto.DubboSkuBundleInfo;
import com.meila.soa.product.api.model.dto.DubboSpuBasicInfo;
import com.meila.soa.product.api.model.dto.DubboUpdateSku;
import com.meila.soa.product.api.model.dto.product.v1.DubboBundleInfoV1;
import com.meila.soa.product.api.model.dto.product.v1.DubboBundleV1;
import com.meila.soa.product.api.model.dto.product.v1.DubboProductImg;
import com.meila.soa.product.api.model.dto.product.v1.DubboProductV1;
import com.meila.soa.product.api.model.dto.product.v1.DubboSkuMappingV1;
import com.meila.soa.product.api.model.dto.product.v1.DubboSkuV1;
import com.meila.soa.product.api.model.request.DubboAddSkuBundleRequest;
import com.meila.soa.product.api.model.request.DubboBatchInstockRequest;
import com.meila.soa.product.api.model.request.DubboBatchOnsaleRequest;
import com.meila.soa.product.api.model.request.DubboCronInvRequest;
import com.meila.soa.product.api.model.request.DubboListProductOfShopRequest;
import com.meila.soa.product.api.model.request.DubboProductStatRequest;
import com.meila.soa.product.api.model.request.DubboQueryCachedInvRequest;
import com.meila.soa.product.api.model.request.DubboQueryCategoryRequest;
import com.meila.soa.product.api.model.request.DubboQueryErpSkuListRequest;
import com.meila.soa.product.api.model.request.DubboQueryProductByLatestSellNumRequest;
import com.meila.soa.product.api.model.request.DubboQuerySkuListRequest;
import com.meila.soa.product.api.model.request.DubboQuerySpuByCodeRequest;
import com.meila.soa.product.api.model.request.DubboQuerySpuByIdRequest;
import com.meila.soa.product.api.model.request.DubboQuerySpuListRequest;
import com.meila.soa.product.api.model.request.DubboSearchSpuListRequest;
import com.meila.soa.product.api.model.request.DubboSyncCategoryRequest;
import com.meila.soa.product.api.model.request.DubboSyncInventoryRequest;
import com.meila.soa.product.api.model.request.DubboSyncProductRequest;
import com.meila.soa.product.api.model.request.inventory.DubboLockInvRequest;
import com.meila.soa.product.api.model.request.inventory.DubboRecoveryInvRequest;
import com.meila.soa.product.api.model.request.inventory.DubboWmsInvNotifyRequest;
import com.meila.soa.product.api.model.request.inventory.DubboWmsInvNotifyRequest.DubboInvNotify;
import com.meila.soa.product.api.model.request.product.DubboAddSpuRequest;
import com.meila.soa.product.api.model.request.product.DubboQueryBundleRequest;
import com.meila.soa.product.api.model.request.product.DubboQueryProductByIdListRequest;
import com.meila.soa.product.api.model.request.product.DubboQueryProductBySkuIdRequest;
import com.meila.soa.product.api.model.request.product.DubboQueryProductRequest;
import com.meila.soa.product.api.model.request.product.DubboQuerySkuByIdListRequest;
import com.meila.soa.product.api.model.request.product.DubboQuerySkuByUserIdRequest;
import com.meila.soa.product.api.model.request.product.DubboSearchProductRequest;
import com.meila.soa.product.api.model.request.product.DubboUpdateProductAndExtRequest;
import com.meila.soa.product.api.model.request.product.DubboUpdateProductStatusRequest;
import com.meila.soa.product.api.model.request.product.DubboUpdateSkuRequest;
import com.meila.soa.product.api.model.request.product.DubboUpdateSpuRequest;
import com.meila.soa.product.api.model.request.product.v1.DubboQuerySkuRequestV1;
import com.meila.soa.product.api.model.response.DubboBatchInstockResponse;
import com.meila.soa.product.api.model.response.DubboBatchInstockResponse.InstockResult;
import com.meila.soa.product.api.model.response.DubboBatchOnsaleResponse;
import com.meila.soa.product.api.model.response.DubboBatchOnsaleResponse.OnsaleResult;
import com.meila.soa.product.api.model.response.DubboCronInvResponse;
import com.meila.soa.product.api.model.response.DubboListProductOfShopResponse;
import com.meila.soa.product.api.model.response.DubboProductStatResponse;
import com.meila.soa.product.api.model.response.DubboQueryCachedInvResponse;
import com.meila.soa.product.api.model.response.DubboQueryCategoryResponse;
import com.meila.soa.product.api.model.response.DubboQueryErpSkuListResponse;
import com.meila.soa.product.api.model.response.DubboQueryProductByLatestSellNumResponse;
import com.meila.soa.product.api.model.response.DubboQuerySkuListResponse;
import com.meila.soa.product.api.model.response.DubboQuerySpuListResponse;
import com.meila.soa.product.api.model.response.DubboQuerySpuResponse;
import com.meila.soa.product.api.model.response.DubboSyncCategoryResponse;
import com.meila.soa.product.api.model.response.DubboSyncCategoryResponse.DubboSyncCategoryResult;
import com.meila.soa.product.api.model.response.DubboSyncInventoryResponse;
import com.meila.soa.product.api.model.response.DubboSyncInventoryResponse.DubboSyncInventoryResult;
import com.meila.soa.product.api.model.response.DubboSyncProductResponse;
import com.meila.soa.product.api.model.response.DubboSyncProductResponse.DubboSyncProductResult;
import com.meila.soa.product.api.model.response.inventory.DubboWmsInvNotifyResponse;
import com.meila.soa.product.api.model.response.inventory.DubboWmsInvNotifyResponse.InvNotifyResult;
import com.meila.soa.product.api.model.response.product.DubboAddProductResponse;
import com.meila.soa.product.api.model.response.product.DubboQueryProductResponse;
import com.meila.soa.product.api.model.response.product.DubboQuerySkuBundleResponse;
import com.meila.soa.product.api.model.response.product.DubboSearchProductResponse;
import com.meila.soa.product.api.model.response.product.v1.DubboQuerySkuResponseV1;
import com.meila.soa.product.dal.dao.erp.ErpCategoryMapper;
import com.meila.soa.product.dal.dao.erp.ErpInventoryMapper;
import com.meila.soa.product.dal.dao.erp.ErpSkuMapper;
import com.meila.soa.product.dal.dao.product.ProductImageMapper;
import com.meila.soa.product.dal.dao.product.ProductInfoMapper;
import com.meila.soa.product.dal.dao.product.ProductMapper;
import com.meila.soa.product.dal.dao.product.SkuBomMapper;
import com.meila.soa.product.dal.dao.product.SkuInvOperateLogMapper;
import com.meila.soa.product.dal.dao.product.SkuMapper;
import com.meila.soa.product.dal.dao.product.SkuMappingMapper;
import com.meila.soa.product.dal.dao.product.SkuWMSInvLogMapper;
import com.meila.soa.product.dal.dao.product.SkuWMSInvMapper;
import com.meila.soa.product.dal.dao.product.StatisticSkuInvShortageMapper;
import com.meila.soa.product.dal.dao.product.StatisticSpuSellnumMapper;
import com.meila.soa.product.dal.dao.shop.ShopExtMapper;
import com.meila.soa.product.dal.dao.shop.ShopMapper;
import com.meila.soa.product.dal.entity.erp.ErpCategory;
import com.meila.soa.product.dal.entity.erp.ErpInventory;
import com.meila.soa.product.dal.entity.erp.ErpSku;
import com.meila.soa.product.dal.entity.product.Product;
import com.meila.soa.product.dal.entity.product.ProductImage;
import com.meila.soa.product.dal.entity.product.ProductInfo;
import com.meila.soa.product.dal.entity.product.ProductUpdateLog;
import com.meila.soa.product.dal.entity.product.Sku;
import com.meila.soa.product.dal.entity.product.SkuBom;
import com.meila.soa.product.dal.entity.product.SkuExt;
import com.meila.soa.product.dal.entity.product.SkuMapping;
import com.meila.soa.product.dal.entity.product.StatisticSkuInvShortage;
import com.meila.soa.product.dal.entity.product.StatisticSpuSellnum;
import com.meila.soa.product.dal.entity.shop.Shop;
import com.meila.soa.product.dal.entity.shop.ShopExt;
import com.meila.soa.product.dal.entity.user.User;
import com.meila.soa.product.dal.type.DeliveryType;
import com.meila.soa.product.dal.type.ProductStatus;
import com.meila.soa.product.dal.type.PurchaseSourceEnum;
import com.meila.soa.product.dal.type.ShopStatus;
import com.meila.soa.product.dal.type.SkuType;
import com.meila.soa.product.dal.type.StorageType;
import com.meila.soa.product.dal.type.WmsStatus;
import com.meila.soa.product.service.innerservice.ProductService;
import com.meila.soa.product.service.innerservice.ShopService;
import com.meila.soa.product.service.innerservice.UserService;
import com.meila.soa.product.service.innerservice.product.SkuService;
import com.meila.soa.product.service.model.SkuMappingModel;

/**
 ************************************************************
 * @类名 : DubboProductServiceImpl.java
 *
 * @DESCRIPTION : 商品接口实现类
 * @AUTHOR : hawk
 * @DATE : 2016年1月15日
 ************************************************************
 */
public class DubboProductServiceImpl implements DubboProductService {

    private static Logger logger = LoggerFactory.getLogger(DubboProductServiceImpl.class);

    @Resource
    private ErpSkuMapper erpSkuEntityMapper;

    @Resource
    private ErpCategoryMapper erpCategoryEntityMapper;

    @Resource
    private ErpInventoryMapper erpInventoryEntityMapper;

    @Resource
    private ProductMapper productMapper;

    @Resource
    private SkuMapper skuMapper;

    @Resource
    private SkuBomMapper skuBomMapper;

    @Resource
    private ShopMapper shopMapper;

    @Resource
    private SkuMappingMapper skuMappingMapper;

    @Resource
    private ProductInfoMapper productInfoMapper;

    @Resource
    private StatisticSkuInvShortageMapper statisticSkuInvShortageMapper;

    @Resource
    private ShopExtMapper shopExtMapper;

    @Resource
    private ProductService productService;

    @Resource
    private ShopService shopService;

    @Resource
    private UserService userService;

    @Resource
    private DubboOrderService dubboOrderService;

    @Resource
    private MeiLaOmsClient meiLaOmsClient;

    @Resource
    private SkuWMSInvLogMapper skuWMSInvLogMapper;

    @Resource
    private SkuWMSInvMapper skuWMSInvMapper;

    @Resource
    private ProductImageMapper productImageMapper;

    @Resource
    private StatisticSpuSellnumMapper statisticSpuSellnumMapper;

    @Resource
    private SkuInvOperateLogMapper skuInvOperateLogMapper;

    @Resource
    private SkuService skuService;

    @Value("${warehouse.info.map}")
    private String warehouseInfo;

    private Map<String, String> warehouseMap;

    private static final Object lock = new Object();

    /**
     * 同步erp sku
     */
    @Override
    public DubboSyncProductResponse syncErpSku(DubboSyncProductRequest req) {
        List<ErpSku> productEntityList = BeanMapper.map(req.getProductSkuList(), ErpSku.class);

        List<DubboSyncProductResult> syncResult = new ArrayList<DubboSyncProductResult>();

        // 添加默认状态
        for (ErpSku temp : productEntityList) {
            fillDefaultValue(temp);
        }
        // 删除原有数据
        erpSkuEntityMapper.deleteByIdList(productEntityList);

        try {
            erpSkuEntityMapper.insertList(productEntityList);
        } catch (Exception e) {
            for (ErpSku temp : productEntityList) {
                try {
                    erpSkuEntityMapper.insert(temp);
                } catch (Exception e1) {
                    DubboSyncProductResult resultTemp = new DubboSyncProductResult();
                    resultTemp.setErpSkuId(temp.getErpSkuId());
                    resultTemp.setErrorCode("data_error");
                    resultTemp.setErrorMsg(e1.getMessage());
                    syncResult.add(resultTemp);
                }
            }
        }

        DubboSyncProductResponse dubboResp = new DubboSyncProductResponse();
        if (syncResult.size() > 0) {
            dubboResp.setResultList(syncResult);
        }
        // 全部失败则返回失败
        if (syncResult.size() == productEntityList.size()) {
            dubboResp.setCode(DubboReturnCode.FAILED);
            dubboResp.setDesc("同步商品失败");
        }

        return dubboResp;
    }

    private void fillDefaultValue(ErpSku temp) {
        temp.setWmsStatus(WmsStatus.WAIT.toString());
        if (StringUtils.isEmpty(temp.getSpec1Name())) {
            temp.setSpec1Name("规格");
            temp.setSpec1Value("默认");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(temp.getSpec1Name());
        sb.append(":");
        sb.append(temp.getSpec1Value());

        if (!StringUtils.isEmpty(temp.getSpec2Name()) && !StringUtils.isEmpty(temp.getSpec2Value())) {
            sb.append(",");
            sb.append(temp.getSpec2Name());
            sb.append(":");
            sb.append(temp.getSpec2Value());
        }
        if (!StringUtils.isEmpty(temp.getSpec3Name()) && !StringUtils.isEmpty(temp.getSpec3Value())) {
            sb.append(",");
            sb.append(temp.getSpec3Name());
            sb.append(":");
            sb.append(temp.getSpec3Value());
        }
        if (!StringUtils.isEmpty(temp.getSpec4Name()) && !StringUtils.isEmpty(temp.getSpec4Value())) {
            sb.append(",");
            sb.append(temp.getSpec4Name());
            sb.append(":");
            sb.append(temp.getSpec4Value());
        }
        if (!StringUtils.isEmpty(temp.getSpec5Name()) && !StringUtils.isEmpty(temp.getSpec5Value())) {
            sb.append(",");
            sb.append(temp.getSpec5Name());
            sb.append(":");
            sb.append(temp.getSpec5Value());
        }
        temp.setSkuStr(sb.toString());
    }

    @Override
    public DubboQueryErpSkuListResponse queryErpSkuList(DubboQueryErpSkuListRequest req) {
        ErpSku erpSku = BeanMapper.map(req, ErpSku.class);

        // 数据库中0代表有效，1代表无效
        erpSku.setArchive(false);

        Map<String, Object> param = new HashMap<>();
        param.put("beginId", req.getBeginId());
        param.put("pageSize", req.getPageSize());
        param.put("erpSyncTimeBegin", req.getErpSyncTimeBegin());
        param.put("erpSyncTimeEnd", req.getErpSyncTimeEnd());

        List<ErpSku> resultList = erpSkuEntityMapper.selectPageBySelective(erpSku, param);
        Long totalNum = erpSkuEntityMapper.selectPageTotalNumBySelective(erpSku, param);

        List<DubboProductSku> dubboProductSkuList = BeanMapper.map(resultList, DubboProductSku.class);

        for (DubboProductSku temp : dubboProductSkuList) {
            String warehouseCode = temp.getWarehouseCode();

            if (!StringUtils.isEmpty(warehouseCode)) {
                initWarehouseMap();

                String warehouseName = warehouseMap.get(warehouseCode);
                if (StringUtils.isEmpty(warehouseName)) {
                    warehouseName = warehouseCode;
                }
                temp.setWarehouseName(warehouseName);
            }
        }

        DubboQueryErpSkuListResponse dubboResp = new DubboQueryErpSkuListResponse();
        dubboResp.setProductSkuList(dubboProductSkuList);
        dubboResp.setCurrentPage(req.getCurrentPage());
        dubboResp.setPageSize(req.getPageSize());
        dubboResp.setTotalNum(totalNum);

        return dubboResp;
    }

    private void initWarehouseMap() {
        if (null == warehouseMap) {
            synchronized (lock) {
                warehouseMap = new HashMap<String, String>();
                if (!StringUtils.isEmpty(warehouseInfo)) {
                    String[] warehouseArr = warehouseInfo.split(";");

                    for (String str : warehouseArr) {
                        String[] strArr = str.split(":");
                        warehouseMap.put(strArr[0], strArr[1]);
                    }
                }
            }
        }
    }

    @Override
    public DubboSyncCategoryResponse syncCategory(DubboSyncCategoryRequest req) {
        List<ErpCategory> categoryEntityList = BeanMapper.map(req.getCategoryList(), ErpCategory.class);

        for (ErpCategory temp : categoryEntityList) {
            // 数据库中0代表有效,1代表无效
            temp.setArchive(false);
        }

        // 根据categoryCode删除原有分类树信息
        erpCategoryEntityMapper.deleteByIdList(categoryEntityList);

        List<DubboSyncCategoryResult> syncResult = new ArrayList<DubboSyncCategoryResult>();
        try {
            erpCategoryEntityMapper.insertList(categoryEntityList);
        } catch (Exception e) {
            for (ErpCategory temp : categoryEntityList) {
                try {
                    erpCategoryEntityMapper.insertSelective(temp);
                } catch (Exception e1) {
                    DubboSyncCategoryResult resultTemp = new DubboSyncCategoryResult();
                    resultTemp.setCategoryCode(temp.getCategoryCode());
                    resultTemp.setErrorCode("data_error");
                    resultTemp.setErrorMsg(e1.getMessage());
                    syncResult.add(resultTemp);
                }
            }
        }

        DubboSyncCategoryResponse dubboResp = new DubboSyncCategoryResponse();
        if (syncResult.size() > 0) {
            dubboResp.setResultList(syncResult);
        }
        // 全部失败则返回失败
        if (syncResult.size() == categoryEntityList.size()) {
            dubboResp.setCode(DubboReturnCode.FAILED);
            dubboResp.setDesc("同步分类树失败");
        }
        return dubboResp;
    }

    @Override
    public DubboQueryCategoryResponse queryCategory(DubboQueryCategoryRequest req) {
        ErpCategory erpCategory = BeanMapper.map(req, ErpCategory.class);
        List<ErpCategory> resultList = erpCategoryEntityMapper.selectPageBySelective(erpCategory);
        List<DubboCategory> dubboCategoryList = BeanMapper.map(resultList, DubboCategory.class);
        DubboQueryCategoryResponse dubboResp = new DubboQueryCategoryResponse();
        dubboResp.setCategoryList(dubboCategoryList);
        return dubboResp;
    }

    @Override
    public DubboSyncInventoryResponse syncInventory(DubboSyncInventoryRequest req) {
        List<ErpInventory> inventoryList = BeanMapper.map(req.getInventoryList(), ErpInventory.class);
        erpInventoryEntityMapper.deleteByIdList(inventoryList);
        List<DubboSyncInventoryResult> syncResult = new ArrayList<DubboSyncInventoryResult>();
        try {
            erpInventoryEntityMapper.insertList(inventoryList);
        } catch (Exception e) {
            for (ErpInventory temp : inventoryList) {
                try {
                    erpInventoryEntityMapper.insertSelective(temp);
                } catch (Exception e1) {
                    DubboSyncInventoryResult resultTemp = new DubboSyncInventoryResult();
                    resultTemp.setErpSkuId(temp.getErpSkuId());
                    resultTemp.setErrorCode("data_error");
                    resultTemp.setErrorMsg(e1.getMessage());
                    syncResult.add(resultTemp);
                }
            }
        }

        DubboSyncInventoryResponse dubboResp = new DubboSyncInventoryResponse();
        if (syncResult.size() > 0) {
            dubboResp.setResultList(syncResult);
        }
        // 全部失败则返回失败
        if (syncResult.size() == inventoryList.size()) {
            dubboResp.setCode(DubboReturnCode.FAILED);
            dubboResp.setDesc("同步库存失败");
        }
        return dubboResp;
    }

    @Override
    public DubboQuerySpuResponse querySpuById(DubboQuerySpuByIdRequest req) {
        List<Product> productEntityList = productMapper.selectByIdList(req.getProductIdList());
        return getSpuList(productEntityList);
    }

    @Override
    public DubboQuerySpuResponse querySpuBaseInfoById(DubboQuerySpuByIdRequest req) {
        List<Product> productEntityList = productMapper.selectByIdList(req.getProductIdList());
        DubboQuerySpuResponse dubboResp = new DubboQuerySpuResponse();

        List<DubboProduct> dubboProductList = BeanMapper.map(productEntityList, DubboProduct.class);
        dubboResp.setProductList(dubboProductList);
        return dubboResp;
    }

    /**
     * 功能描述：填充用户名
     * 
     * @param dubboProductList void
     *
     */
    private void fillShopInfo(List<DubboProduct> dubboProductList) {
        List<Long> shopIdList = new ArrayList<Long>();
        for (DubboProduct temp : dubboProductList) {
            shopIdList.add(temp.getShopId());
        }
        if (shopIdList.size() == 0) {
            return;
        }

        List<ShopExt> shopExtEntityList = shopExtMapper.selectByShopIds(shopIdList);
        List<Shop> shopEntityList = shopMapper.selectByList(shopIdList);

        Map<Long, Shop> shopEntityMap = new HashMap<Long, Shop>();
        Map<Long, ShopExt> shopExtEntityMap = new HashMap<Long, ShopExt>();

        for (Shop temp : shopEntityList) {
            shopEntityMap.put(temp.getId(), temp);
        }
        for (ShopExt temp : shopExtEntityList) {
            shopExtEntityMap.put(temp.getId(), temp);
        }

        for (DubboProduct temp : dubboProductList) {
            Shop shop = shopEntityMap.get(temp.getShopId());
            if (null != shop) {
                temp.setShopName(shop.getName());
                temp.setSellerSource(shop.getSellerSource());
            }

            ShopExt shopExt = shopExtEntityMap.get(temp.getShopId());
            if (null != shopExt) {
                DeliveryType deliveryType = shopExt.getDeliveryType();
                if (null != deliveryType) {
                    temp.setDeliveryType(deliveryType.name());
                } else {
                    temp.setDeliveryType(DeliveryType.MEILA.name());
                }
            } else {
                temp.setDeliveryType(DeliveryType.MEILA.name());
            }
        }
    }

    @Override
    public DubboQuerySpuResponse querySpuByCode(DubboQuerySpuByCodeRequest req) {
        List<Product> productEntityList = productMapper.selectByCodeList(req.getCodeList());
        return getSpuList(productEntityList);
    }

    private DubboQuerySpuResponse getSpuList(List<Product> productEntityList) {
        DubboQuerySpuResponse dubboResp = new DubboQuerySpuResponse();

        if (Collections3.isEmpty(productEntityList)) {
            return dubboResp;
        }

        List<DubboProduct> dubboProductList = BeanMapper.map(productEntityList, DubboProduct.class);
        fillShopInfo(dubboProductList);
        fillProductInfo(dubboProductList);

        List<Long> productIdList = new ArrayList<Long>();
        for (Product temp : productEntityList) {
            productIdList.add(temp.getId());
        }
        List<Sku> skuEntityList = skuMapper.selectByList(productIdList);

        if (Collections3.isEmpty(skuEntityList)) {
            skuEntityList = new ArrayList<>();
        }
        Map<Long, List<Sku>> skuEntityGroupMap = new HashMap<Long, List<Sku>>();
        for (Sku temp : skuEntityList) {
            List<Sku> list = skuEntityGroupMap.get(temp.getProductId());
            if (null == list) {
                list = new ArrayList<Sku>();
                list.add(temp);
                skuEntityGroupMap.put(temp.getProductId(), list);
            } else {
                list.add(temp);
            }
        }
        for (DubboProduct temp : dubboProductList) {
            List<Sku> tempList = skuEntityGroupMap.get(temp.getProductId());
            if (null != tempList) {
                temp.setSkuList(BeanMapper.map(tempList, DubboSku.class));
            }

            String ps = temp.getPurchaseSource();
            if (!StringUtils.isEmpty(ps)) {
                try {
                    temp.setPurchaseSource(PurchaseSourceEnum.valueOf(ps).getName() + "直采");
                } catch (Exception e) {

                }
            }
        }

        fillSpecInfo(dubboProductList);
        dubboResp.setProductList(dubboProductList);

        return dubboResp;
    }

    private void fillSpecInfo(List<DubboProduct> dubboProductList) {

        for (DubboProduct temp : dubboProductList) {
            List<SkuMappingModel> skuMappingToVO = productService.skuMappingToVO(temp.getProductId(), temp.getSkuList());

            Map<String, List<String>> specInfo = new LinkedHashMap<String, List<String>>();
            for (SkuMappingModel tempVo : skuMappingToVO) {
                specInfo.put(tempVo.getSpecName(), tempVo.getMappingValues());
            }
            temp.setSpecInfo(specInfo);
        }
    }

    /**
     * 功能描述：补充产品信息
     * 
     * @param dubboProductList void
     *
     */
    private void fillProductInfo(List<DubboProduct> dubboProductList) {
        List<Long> productIdList = new ArrayList<Long>();
        for (DubboProduct temp : dubboProductList) {
            productIdList.add(temp.getProductId());
        }
        List<ProductInfo> productInfoEntityList = productInfoMapper.selectByProductIdList(productIdList);

        Map<Long, ProductInfo> productInfoEntityMap = new HashMap<Long, ProductInfo>();

        for (ProductInfo temp : productInfoEntityList) {
            productInfoEntityMap.put(temp.getProductId(), temp);
        }
        for (DubboProduct temp : dubboProductList) {
            ProductInfo productInfo = productInfoEntityMap.get(temp.getProductId());
            if (null != productInfo) {
                temp.setPurchaseSource(productInfo.getPurchaseSource());
                StorageType storageType = productInfo.getStorageType();
                if (null != storageType) {
                    temp.setStorageType(storageType.name());
                } else {
                    temp.setStorageType(StorageType.NON_SPOT.name());
                }

                // DeliveryType deliveryType = productInfo.getDeliveryType();
                String deliveryTypeStr = productInfo.getDeliveryType();
                // if (null != deliveryType) {
                // deliveryTypeStr = deliveryType.toString();
                // }

                if (StringUtils.isEmpty(deliveryTypeStr)) {
                    deliveryTypeStr = temp.getDeliveryType();
                }
                temp.setDeliveryType(deliveryTypeStr);
                Map<String, Object> deliveryInfoMap = productService.createProductDeliveryInfo(productInfo, DeliveryType.valueOf(deliveryTypeStr));

                temp.setDeliveryDays((Integer) deliveryInfoMap.get("totalDays"));
                temp.setSendOutHours((Integer) deliveryInfoMap.get("sendOutHours"));
            } else {
                temp.setStorageType(StorageType.NON_SPOT.name());
                temp.setDeliveryDays(0);
            }
        }
    }

    @Override
    public DubboBasicResponse addSkuBundle(DubboAddSkuBundleRequest req) {
        Product product = productMapper.selectById(req.getProductId());
        if (null == product) {
            return new DubboBasicResponse(ProductReturnCode.SPU_NOT_EXIST, "商品不存在");
        }

        List<SkuMapping> skuMappingList = skuMappingMapper.selectByProductId(req.getProductId());
        if (skuMappingList.size() > 1) {
            return new DubboBasicResponse(ProductReturnCode.SKU_MAPPING_NUM_INVLAID, "多规格商品不可编辑套餐");
        }

        Shop shop = shopService.load(product.getShopId());
        if (null == shop) {
            return new DubboBasicResponse(ProductReturnCode.SHOP_NOT_EXIST, "店铺不存在");
        }

        // 校验bom关系的sku个数，最少2个sku
        for (DubboSkuBundle vo : req.getDubboSkuBundleList()) {
            if (vo.getSkuBundleInfoList().size() == 1) {
                DubboSkuBundleInfo skuBomInfoVO = vo.getSkuBundleInfoList().get(0);

                if (null != skuBomInfoVO.getMatchCount() && skuBomInfoVO.getMatchCount() <= 1) {
                    // return buildFinalResult("", vo.getSpuName() + " 下的商品搭配数量必须大于一");
                    return new DubboBasicResponse(ProductReturnCode.PARAMETER_ERR, vo.getSkuBundleName() + " 下的商品搭配数量必须大于一");

                }
            }
        }

        List<DubboSkuBundle> bomsList = req.getDubboSkuBundleList();
        // 内部卖家必须填写分摊价格
        if ("INSIDE".equals(shop.getSellerSource()) && productService.checkUserIdForBomLimit(shop.getOwnerId())) {
            // 严格限制套餐下商品的仓库必须与套餐所在商品仓库一致
            ProductInfo productInfo = productService.loadProduvtExtByProductId(req.getProductId());

            // 校验套餐的分摊价格（报关用）是否与套餐价格一致
            for (DubboSkuBundle vo : bomsList) {
                BigDecimal bomsPrice = vo.getPrice();
                BigDecimal totalPrice = BigDecimal.ZERO;

                for (DubboSkuBundleInfo skuBomInfoVO : vo.getSkuBundleInfoList()) {
                    if (null != skuBomInfoVO.getClearancePrice() && skuBomInfoVO.getClearancePrice().compareTo(BigDecimal.ZERO) == 1) {
                        if (skuBomInfoVO.getArchive() == false) {
                            BigDecimal matchCount = new BigDecimal(skuBomInfoVO.getMatchCount());
                            totalPrice = totalPrice.add(skuBomInfoVO.getClearancePrice().multiply(matchCount));
                        }
                    } else {
                        return new DubboBasicResponse(ProductReturnCode.PARAMETER_ERR, vo.getSkuBundleName() + " 下的保税仓报关价格不能为空并且必须大于0");

                    }

                    ProductInfo currentProductInfo = productService.selectProductInfoBySkuId(skuBomInfoVO.getSubSkuId());
                    if (null == currentProductInfo || productInfo == null
                            || !StringUtils.equals(productInfo.getWarehouse(), currentProductInfo.getWarehouse())) {

                        // 同一个商品或被删除的不做校验
                        if (currentProductInfo.getProductId().equals(productInfo.getProductId()) || skuBomInfoVO.getArchive() == true) {
                            continue;
                        }

                        // return buildFinalResult("", vo.getSpuName() + " 下的套餐商品所在仓库与当前商品不一致，请选择同一个仓库的商品");

                        return new DubboBasicResponse(ProductReturnCode.PARAMETER_ERR, vo.getSkuBundleName() + "下的套餐商品所在仓库与当前商品不一致，请选择同一个仓库的商品");

                    }
                }

                // 判断套餐价格与分摊价格统计是否一致
                if (totalPrice.compareTo(bomsPrice) != 0) {
                    return new DubboBasicResponse(ProductReturnCode.PARAMETER_ERR, vo.getSkuBundleName() + " 下的套餐价格和保税仓报关价格总计不一致");
                }
            }
        }

        // 校验bom关系套餐名，唯一校验
        for (DubboSkuBundle vo : bomsList) {
            Sku sku = productService.findSpuByProductIdAndName(product.getId(), vo.getSkuBundleName());

            // 如果查找的sku不为空，查找的skuId和提交的skuId一致，则放行
            if (null != sku) {
                if (!sku.getId().equals(vo.getSkuBundleId())) {
                    return new DubboBasicResponse(ProductReturnCode.SKU_BUNDLE_EXIST, "套餐名已存在");
                }
            }
        }

        // 规格名
        String specName = skuMappingList.get(0).getSpecName();

        // 商品ID
        Long productId = req.getProductId();

        // 保存或更新BOM关系
        productService.saveOrUpdateBom(bomsList, specName, productId);

        return new DubboBasicResponse();
    }

    @Override
    public DubboQuerySpuListResponse querySpu(DubboQuerySpuListRequest req) {
        Product product = BeanMapper.map(req, Product.class);

        Map<String, Long> page = Maps.newHashMap();
        page.put("beginId", req.getBeginId());
        page.put("pageSize", req.getPageSize());

        List<Product> productEntityList = productService.querySpuPage(product, page);

        Long totalNum = productService.querySpuPageNum(product, page);

        DubboQuerySpuListResponse dubboResp = new DubboQuerySpuListResponse();
        dubboResp.setCurrentPage(req.getCurrentPage());
        dubboResp.setPageSize(req.getPageSize());
        dubboResp.setTotalNum(totalNum);
        dubboResp.setSpuBasicInfoList(BeanMapper.map(productEntityList, DubboSpuBasicInfo.class));
        return dubboResp;
    }

    @Override
    public DubboQuerySkuListResponse querySku(DubboQuerySkuListRequest req) {

        // 1.基础参数设置
        DubboQuerySkuListResponse dubboResp = new DubboQuerySkuListResponse();

        // 商品名称
        String productName = req.getProductName();
        // 商店Id
        Long shopId = req.getShopId();
        // 商品状态：null or 1:仅上架商品 0:所有商品 0
        Integer onlyOnSale = req.getOnlyOnSale();
        // 排序商品创建时间created_at，或者上架时间onsale_at
        String orderField = StringUtils.isBlank(req.getOrderField()) ? "onsale_at" : req.getOrderField();
        // 排序方向
        String orderDirection = StringUtils.isBlank(req.getOrderDirection()) ? "desc" : req.getOrderDirection();

        // 2.依据商店Id、商品名称、商品状态查询商品数据
        List<Product> productList = productMapper.selectProductList(shopId, productName, onlyOnSale);

        if (Collections3.isEmpty(productList)) {
            return dubboResp;
        }

        Map<Long, Product> productMap = Maps.newHashMap();
        List<Long> productIdList = Lists.newArrayList();
        for (Product temp : productList) {
            productMap.put(temp.getId(), temp);
            productIdList.add(temp.getId());
        }

        List<ProductInfo> productInfoList = productInfoMapper.selectByProductIdList(productIdList);

        Map<Long, ProductInfo> productInfoMap = Maps.newHashMap();

        if (Collections3.isNotEmpty(productInfoList)) {
            for (ProductInfo temp : productInfoList) {
                productInfoMap.put(temp.getProductId(), temp);
            }
        }

        List<Long> productIds = new ArrayList<Long>();

        if (CollectionUtils.isNotEmpty(productList)) {
            for (Product temp : productList) {
                productIds.add(temp.getId());
            }
        } else {
            return dubboResp;
        }

        // 3.依据商品Ids、sku类型查询sku列表
        List<Sku> skuList = productService.querySku(productIds, req.getSkuType());
        List<DubboSkuBasicInfo> dubboSkuList = BeanMapper.map(skuList, DubboSkuBasicInfo.class);

        for (DubboSkuBasicInfo dubboSkuBasicInfo : dubboSkuList) {
            Product productObj = productMap.get(dubboSkuBasicInfo.getProductId());
            if (null != productObj) {
                dubboSkuBasicInfo.setProductName(productObj.getName());
                dubboSkuBasicInfo.setProductImg(productObj.getImg());
                dubboSkuBasicInfo.setProductStatus(productObj.getStatus().name());
                dubboSkuBasicInfo.setProductCreatedAt(productObj.getCreatedAt());
                dubboSkuBasicInfo.setProductOnsaleAt(productObj.getOnsaleAt());
                dubboSkuBasicInfo.setOrderField(orderField);
                dubboSkuBasicInfo.setOrderDirection(orderDirection);
            }

            ProductInfo productInfoObj = productInfoMap.get(dubboSkuBasicInfo.getProductId());
            if (null != productInfoObj) {
                dubboSkuBasicInfo.setDeliveryType(productInfoObj.getDeliveryType());
            }
        }

        List<DubboSkuBasicInfo> newDubboSkuList = Lists.newArrayList();
        String deliveryType = req.getDeliveryType();
        if (StringUtils.isNotBlank(deliveryType)) {
            for (DubboSkuBasicInfo dubboSkuBasicInfo : dubboSkuList) {
                if (deliveryType.equals(dubboSkuBasicInfo.getDeliveryType())) {
                    newDubboSkuList.add(dubboSkuBasicInfo);
                }

            }
        }

        // 4.排序商品上架时间
        if ("onsale_at".equals(orderField)) {
            Collections.sort(newDubboSkuList, new SortProductOnsaleAtClass());
        } else if ("create_at".equals(orderField)) {
            Collections.sort(newDubboSkuList, new SortProductCreateAtClass());
        }

        dubboResp.setDubboSkuBasicInfoList(newDubboSkuList);
        return dubboResp;
    }

    /*
     * 商品上架时间排序比较器
     */
    public class SortProductOnsaleAtClass implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            if (null != o1 && null != o2) {
                DubboSkuBasicInfo dubboSkuBasicInfoOne = (DubboSkuBasicInfo) o1;
                DubboSkuBasicInfo dubboSkuBasicInfoTwo = (DubboSkuBasicInfo) o2;

                if (dubboSkuBasicInfoOne.getProductOnsaleAt() == null || dubboSkuBasicInfoTwo.getProductOnsaleAt() == null) {
                    return 0;
                }

                Long timeOne = dubboSkuBasicInfoOne.getProductOnsaleAt().getTime();
                Long timeTwo = dubboSkuBasicInfoTwo.getProductOnsaleAt().getTime();

                int result = 0;
                if ("desc".equals(dubboSkuBasicInfoOne.getOrderDirection())) {
                    result = timeTwo > timeOne ? 1 : (timeOne.equals(timeTwo) ? 0 : -1);
                } else {
                    result = timeOne > timeTwo ? 1 : (timeOne.equals(timeTwo) ? 0 : -1);
                }

                return result;
            }
            return 0;
        }
    }

    /*
     * 商品创建时间正序排序
     */
    public class SortProductCreateAtClass implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            if (null != o1 && null != o2) {
                DubboSkuBasicInfo dubboSkuBasicInfoOne = (DubboSkuBasicInfo) o1;
                DubboSkuBasicInfo dubboSkuBasicInfoTwo = (DubboSkuBasicInfo) o2;

                if (dubboSkuBasicInfoOne.getCreatedAt() == null || dubboSkuBasicInfoTwo.getCreatedAt() == null) {
                    return 0;
                }

                Long timeOne = dubboSkuBasicInfoOne.getCreatedAt().getTime();
                Long timeTwo = dubboSkuBasicInfoTwo.getCreatedAt().getTime();

                int result = 0;
                if ("desc".equals(dubboSkuBasicInfoOne.getOrderDirection())) {
                    result = timeTwo > timeOne ? 1 : (timeOne.equals(timeTwo) ? 0 : -1);
                } else {
                    result = timeOne > timeTwo ? 1 : (timeOne.equals(timeTwo) ? 0 : -1);
                }

                return result;
            }
            return 0;
        }
    }

    /*
     * 商品创建时间倒序排序
     */
    public class SortProductCreateAtClassForDesc implements Comparator<DubboSkuBasicInfo> {
        @Override
        public int compare(DubboSkuBasicInfo o1, DubboSkuBasicInfo o2) {
            if (null != o1 && null != o2) {
                if (o1.getCreatedAt() == null || o2.getCreatedAt() == null) {
                    return 0;
                }

                Long timeOne = o1.getCreatedAt().getTime();
                Long timeTwo = o2.getCreatedAt().getTime();

                int result = timeOne > timeTwo ? 1 : (timeOne.equals(timeTwo) ? 0 : -1);

                return result;
            }
            return 0;
        }
    }

    @Override
    public DubboQuerySpuListResponse searchSpu(DubboSearchSpuListRequest req) {

        Product product = BeanMapper.map(req, Product.class);
        product.setArchive(false);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("onSaleAtBegin", req.getOnSaleAtBegin());
        params.put("onSaleAtEnd", req.getOnSaleAtEnd());

        params.put("beginId", req.getBeginId());
        params.put("pageSize", req.getPageSize());

        List<Product> productEntityList = productService.searchSpu(product, params);
        Long totalNum = productService.countSearchSpu(product, params);

        DubboQuerySpuListResponse dubboResp = new DubboQuerySpuListResponse();
        dubboResp.setSpuBasicInfoList(BeanMapper.map(productEntityList, DubboSpuBasicInfo.class));

        dubboResp.setCurrentPage(req.getCurrentPage());
        dubboResp.setPageSize(req.getPageSize());
        dubboResp.setTotalNum(totalNum);

        return dubboResp;
    }

    @Override
    public DubboBasicResponse updateSpu(DubboUpdateSpuRequest req) {

        User user = userService.load(req.getUserId());
        if (null == user.getShopId()) {
            // return buildFinalResult("", "当前用户不是卖家");
            return new DubboBasicResponse(ProductReturnCode.FAILED, "当前用户不是卖家");
        }

        if (req.getIsDelay() && req.getDelayDays() == 0) {
            // return buildFinalResult("", "已经选择了延迟发货，请设置延迟天数");
            return new DubboBasicResponse(ProductReturnCode.FAILED, "已经选择了延迟发货，请设置延迟天数");
        }

        Product product = BeanMapper.map(req, Product.class);

        logger.debug("userId:{},userName:{},进入更新商品逻辑,productId:{}", user.getId(), user.getName(), product.getId());

        // 设置计划发布时间
        if (ProductStatus.FORSALE.toString().equals(req.getStatus())) {
            product.setForsaleAt(new Date(req.getForsaleDate()));
        }

        // 初始化参数，处理表单类
        List<ProductImage> imgs = BeanMapper.map(req.getProductImgList(), ProductImage.class);

        ProductInfo productInfo = initProductInfo(req);

        // 查出商品下的SKU集合
        List<Sku> skuList = productService.selectSkuListByProductId(req.getProductId(), SkuType.NORMAL);
        if (CollectionUtils.isNotEmpty(skuList)) {
            // 查询商品的SKU所关联的BOM
            List<SkuBom> bomList = productService.selectBomListBySkuList(skuList);
            if (CollectionUtils.isNotEmpty(bomList)) {
                // 查询BOM所属的商品扩展类
                List<ProductInfo> productInfoList = productService.selectProductInfoListByBomList(bomList);

                for (ProductInfo bomProductInfo : productInfoList) {
                    if (null == bomProductInfo && !StringUtils.equals(productInfo.getWarehouse(), bomProductInfo.getWarehouse())) {
                        // return buildFinalResult("", "该商品已作为套餐商品销售，不可修改仓库");
                        return new DubboBasicResponse(ProductReturnCode.FAILED, "该商品已作为套餐商品销售，不可修改仓库");

                    }
                }
            }
        }

        productService.updateProduct(product, imgs, productInfo, user);

        return new DubboBasicResponse();
    }

    @Override
    public DubboAddProductResponse addProduct(DubboAddSpuRequest req) {
        DubboAddProductResponse dubboResp = new DubboAddProductResponse();

        User user = userService.load(req.getUserId());
        if (null == user.getShopId()) {
            dubboResp.setCode(ProductReturnCode.FAILED);
            dubboResp.setDesc("当前用户不是卖家");
            return dubboResp;
        }

        if (req.getIsDelay() && req.getDelayDays() == 0) {
            dubboResp.setCode(ProductReturnCode.FAILED);
            dubboResp.setDesc("已经选择了延迟发货，请设置延迟天数");
            return dubboResp;
        }

        Product product = BeanMapper.map(req, Product.class);

        // 设置计划发布时间
        if (ProductStatus.FORSALE.toString().equals(req.getProductStatus())) {
            product.setForsaleAt(new Date(req.getForsaleDate()));
        }

        // 初始化参数，处理表单类
        List<ProductImage> imgs = BeanMapper.map(req.getProductImgList(), ProductImage.class);

        ProductInfo productInfo = initProductInfo(req);

        Product saveProduct = productService.saveProduct(product, imgs, productInfo, user);

        DubboProductV1 dubboProduct = new DubboProductV1();
        dubboProduct.setProductId(product.getId());
        dubboResp.setProduct(dubboProduct);
        return dubboResp;
    }

    /**
     * 初始化商品扩展信息
     * 
     * @param form 表单类
     * @return ProductInfo 商品扩展信息
     * @exception {说明在某情况下,将发生什么异常}
     */
    private ProductInfo initProductInfo(DubboAddSpuRequest form) {
        ProductInfo info = new ProductInfo();
        info.setShortName(StringUtils.defaultString(form.getShortName(), ""));
        info.setShortIntro(StringUtils.defaultString(form.getShortIntro(), ""));

        info.setPurchaseSource(form.getPurchaseSource()); // 采购地

        info.setDeliveryType(form.getDeliveryType()); // 商品发货类型
        info.setProductType(form.getProductType());
        if (StringUtils.isNotBlank(form.getWarehouse())) {
            info.setWarehouse(form.getWarehouse()); // 商品发货仓库
        } else {
            info.setWarehouse("");
        }

        return info;
    }

    /**
     * 初始化商品扩展信息
     * 
     * @param form 表单类
     * @return ProductInfo 商品扩展信息
     * @exception {说明在某情况下,将发生什么异常}
     */
    private ProductInfo initProductInfo(DubboUpdateSpuRequest form) {
        ProductInfo info = new ProductInfo();
        info.setShortName(StringUtils.defaultString(form.getShortName(), ""));
        info.setShortIntro(StringUtils.defaultString(form.getShortIntro(), ""));

        info.setPurchaseSource(form.getPurchaseSource()); // 采购地
        info.setProductPrepareDays(form.getProductPrepareDays()); // 备货时间
        info.setLogisticsInternaDays(form.getLogisticsInternaDays()); // 国际物流时间

        info.setDeliveryType(form.getDeliveryType()); // 商品发货类型
        if (StringUtils.isNotBlank(form.getWarehouse())) {
            info.setWarehouse(form.getWarehouse()); // 商品发货仓库
        } else {
            info.setWarehouse("");
        }

        return info;
    }

    @Override
    public DubboQueryCachedInvResponse queryCachedInv(DubboQueryCachedInvRequest req) {
        StatisticSkuInvShortage statisticSkuInvShortage = BeanMapper.map(req, StatisticSkuInvShortage.class);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("beginId", req.getBeginId());
        params.put("pageSize", req.getPageSize());

        List<StatisticSkuInvShortage> productInvStatisticList = statisticSkuInvShortageMapper.selectBySearch(statisticSkuInvShortage, params);
        Long totalNum = statisticSkuInvShortageMapper.countBySearch(statisticSkuInvShortage);

        DubboQueryCachedInvResponse dubboResp = new DubboQueryCachedInvResponse();
        dubboResp.setProductInvStatisticList(BeanMapper.map(productInvStatisticList, DubboProductInvStatistic.class));

        dubboResp.setPageSize(req.getPageSize());
        dubboResp.setTotalNum(totalNum);
        dubboResp.setCurrentPage(req.getCurrentPage());

        return dubboResp;
    }

    @Override
    public DubboBasicResponse updateSku(DubboUpdateSkuRequest form) {
        // 初始化参数，处理表单类
        List<Sku> skuList = initSku(form);

        List<SkuMapping> skuMappingList = initSkuMapping(form);

        Product product = productService.loadProductById(form.getProductId());

        productService.saveSkuAndMapping(product, skuList, skuMappingList, form.getSkuBundleNum());
        return new DubboBasicResponse();
    }

    /**
     * 初始化sku mapping信息
     * 
     * @param form 表单类
     * @return List&lt;SkuMapping&gt; sku mapping集合
     * @exception {说明在某情况下,将发生什么异常}
     */
    private List<SkuMapping> initSkuMapping(DubboUpdateSkuRequest form) {
        return BeanMapper.map(form.getSkuMappingList(), SkuMapping.class);
    }

    /**
     * 初始化sku信息
     * 
     * @param req 表单类
     * @param user 用户对象
     * @return List&lt;Sku&gt; sku集合
     * @exception {说明在某情况下,将发生什么异常}
     */
    private List<Sku> initSku(DubboUpdateSkuRequest req) {
        List<Sku> skus = Lists.newArrayList();

        if (Collections3.isNotEmpty(req.getSkuList())) {
            SkuExt skuExt = null;
            for (DubboUpdateSku temp : req.getSkuList()) {
                Sku sku = BeanMapper.map(temp, Sku.class);

                if (StringUtils.isEmpty(sku.getImg())) {
                    sku.setImg("");
                    sku.setImgHeight(0);
                    sku.setImgWidth(0);
                }

                // 保存ERP Sku的仓库信息到本地
                if (StringUtils.isNotBlank(temp.getOutsideSkuCode())) {
                    skuExt = new SkuExt();

                    if (null != sku.getId()) {
                        skuExt.setSkuId(sku.getId());
                    }
                    skuExt.setOutsideSkuCode(temp.getOutsideSkuCode());

                    skuExt.setCreatedId(req.getUserId());

                    sku.setSkuExt(skuExt);
                }
                skus.add(sku);
            }
        }
        return skus;
    }

    @Override
    public DubboCronInvResponse cronQueryInvShort(DubboCronInvRequest req) {
        Map<String, Long> params = new HashMap<String, Long>();
        params.put("pageSize", req.getPageSize());
        params.put("beginId", req.getBeginId());
        Shop record = new Shop();
        record.setStatus(ShopStatus.ACTIVE);

        List<Shop> shopList = shopMapper.selectByPage(record, params);

        DubboCronInvResponse dubboResp = new DubboCronInvResponse();
        dubboResp.setContinueFlag(true);

        if (null == shopList || shopList.size() == 0) {
            dubboResp.setContinueFlag(false);
            return dubboResp;
        }

        for (Shop shop : shopList) {
            updateInvByShop(shop);
        }

        return dubboResp;
    }

    private void updateInvByShop(Shop shop) {
        // 查询店铺下所有商品
        List<Product> productList = productService.selectProductListByShopId(shop.getId());

        if (Collections3.isEmpty(productList)) {
            return;
        }

        // 生成店铺ID列表以及map信息
        List<Long> productIdList = new ArrayList<>();
        Map<Long, Product> productMap = new HashMap<Long, Product>();
        for (Product temp : productList) {
            productIdList.add(temp.getId());
            productMap.put(temp.getId(), temp);
        }

        Set<Long> productIdSet = new HashSet<>();
        productIdSet.addAll(productIdList);

        // 只处理内部卖家或者外部卖家中由美啦代发货的
        List<ProductInfo> productInfoList = productInfoMapper.selectByProductIdList(productIdList);
        Map<Long, ProductInfo> productInfoMap = new HashMap<Long, ProductInfo>();
        for (ProductInfo temp : productInfoList) {
            productInfoMap.put(temp.getProductId(), temp);
        }

        ShopExt shopExt = getShopExtByShopId(shop);
        for (ProductInfo productInfo : productInfoList) {
            String deliveryTypeStr = productInfo.getDeliveryType();
            if (StringUtils.isNull(deliveryTypeStr)) {
                if (null != shopExt) {
                    DeliveryType deliveryType = shopExt.getDeliveryType();
                    if (null != deliveryType) {
                        deliveryTypeStr = deliveryType.name();
                    } else {
                        deliveryTypeStr = DeliveryType.MEILA.name();
                    }
                } else {
                    deliveryTypeStr = DeliveryType.MEILA.name();
                }
            }

            if (!DeliveryType.MEILA.toString().equals(deliveryTypeStr)) {
                productIdSet.remove(productInfo.getProductId());
            }
        }

        productIdList.clear();
        productIdList.addAll(productIdSet);
        if (Collections3.isEmpty(productIdList)) {
            return;
        }
        List<Sku> skuList = skuMapper.selectByList(productIdList);

        if (Collections3.isEmpty(skuList)) {
            return;
        }

        List<Long> skuIdList = new ArrayList<>();
        for (Sku temp : skuList) {
            skuIdList.add(temp.getId());
        }
        // 查询库存
        Map<String, Integer> skuInventoryMap = queryInventoryBySkuIdList(shop, skuIdList);

        // 查询sku销量
        Map<Long, Integer> resultMap = batchQuerySellNumBySkuIdList(skuIdList);

        statisticSkuInvShortageMapper.deleteBySellerId(shop.getOwnerId());
        for (Sku tempSku : skuList) {
            StatisticSkuInvShortage record = new StatisticSkuInvShortage();
            record.setSellerId(shop.getOwnerId());
            int skuInventory = getSkuInventory(skuInventoryMap, tempSku.getId());
            int sellNum = getSellNum(resultMap, tempSku.getId());
            if (0 == skuInventory && 0 == sellNum) {
                continue;
            }

            int invShort = skuInventory - sellNum;
            record.setInventory(skuInventory);
            record.setOrderNum(sellNum);
            record.setInvShortage(invShort);
            record.setProductMainImg(productMap.get(tempSku.getProductId()).getImg());
            record.setProductName(productMap.get(tempSku.getProductId()).getName());
            record.setStorageType(getStorageType(productInfoMap, tempSku));
            record.setArchive(false);
            record.setCreateTime(new Date(System.currentTimeMillis()));
            record.setUpdateTime(new Date(System.currentTimeMillis()));
            record.setSkuSpec(tempSku.getSpec());
            record.setSkuId(tempSku.getId());
            statisticSkuInvShortageMapper.insert(record);
        }
    }

    // 分批进行调用
    private Map<String, Integer> queryInventoryBySkuIdList(Shop shop, List<Long> skuIdList) {
        Map<String, Integer> resultMap = new HashMap<String, Integer>();
        if (Collections3.isEmpty(skuIdList)) {
            return resultMap;
        }

        List<List<Long>> partition = Lists.partition(skuIdList, 50);
        for (List<Long> temp : partition) {
            try {
                Map<String, Integer> tempMap = meiLaOmsClient.getSkuInventory(shop.getOwnerId(), temp);
                resultMap.putAll(tempMap);
            } catch (Exception e) {
                logger.error("query sku invenroty faile {}", e);
            }
        }
        return resultMap;
    }

    /**
     * 
     * 功能描述：分批次查询sku销量
     * 
     * @param skuIdList
     * @return Map<Long,Integer>
     *
     */
    private Map<Long, Integer> batchQuerySellNumBySkuIdList(List<Long> skuIdList) {
        Map<Long, Integer> resultMap = new HashMap<Long, Integer>();
        if (Collections3.isEmpty(skuIdList)) {
            return resultMap;
        }

        List<List<Long>> partition = Lists.partition(skuIdList, 200);

        List<Long> reqSkuIdList = Lists.newArrayList();
        for (List<Long> temp : partition) {
            try {
                reqSkuIdList.clear();
                reqSkuIdList.addAll(temp);
                Map<Long, Integer> tempMap = querySellNumBySkuIdList(reqSkuIdList);
                resultMap.putAll(tempMap);
            } catch (Exception e) {
                logger.error("query sku invenroty faile {}", e);
            }
        }

        return resultMap;
    }

    private Map<Long, Integer> querySellNumBySkuIdList(List<Long> skuIdList) {
        DubboQueryOrderSellNumRequest req = new DubboQueryOrderSellNumRequest();
        req.setOrderStatus(OrderStatusEnum.PAID);
        req.setSkuIds(skuIdList);
        DubboQueryOrderSellNumResponse dubboResp = dubboOrderService.querySellNumBySkuIds(req);
        if (dubboResp.getCode() == ProductReturnCode.SUCCESS) {
            Map<Long, Integer> resultMap = dubboResp.getResultMap();
            return resultMap;
        }
        return new HashMap<Long, Integer>();
    }

    private String getStorageType(Map<Long, ProductInfo> productInfoMap, Sku skuId) {
        ProductInfo productInfo = productInfoMap.get(skuId.getProductId());
        if (null == productInfo) {
            return StorageType.NON_SPOT.name();
        }
        StorageType storageType = productInfo.getStorageType();
        if (null == storageType) {
            return StorageType.NON_SPOT.name();
        }
        return storageType.toString();
    }

    private ShopExt getShopExtByShopId(Shop shop) {
        List<Long> shopIdList = new ArrayList<>();
        shopIdList.add(shop.getId());
        List<ShopExt> shopExtEntityList = shopExtMapper.selectByShopIds(shopIdList);

        ShopExt shopExt = null;
        if (!Collections3.isEmpty(shopExtEntityList)) {
            shopExt = shopExtEntityList.get(0);
        }
        return shopExt;
    }

    private Integer getSellNum(Map<Long, Integer> resultMap, Long skuId) {
        Integer temp = resultMap.get(skuId);
        if (null == temp) {
            temp = 0;
        }
        return temp;
    }

    private Integer getSkuInventory(Map<String, Integer> resultMap, Long skuId) {
        Integer temp = resultMap.get(String.valueOf(skuId));
        if (null == temp) {
            temp = 0;
        }
        return temp;
    }

    @Override
    public DubboWmsInvNotifyResponse invNotify(DubboWmsInvNotifyRequest req) {
        DubboWmsInvNotifyResponse dubboResp = new DubboWmsInvNotifyResponse();
        List<InvNotifyResult> resultList = Lists.newArrayList();
        dubboResp.setResult(resultList);

        for (DubboInvNotify temp : req.getInvNotifyList()) {
            if (temp.getSkuId().contains("|")) {
                try {
                    productService.updateInvOfTR(temp);
                } catch (Exception e) {
                    if (!(e instanceof DuplicateKeyException)) {
                        InvNotifyResult result = new InvNotifyResult();
                        result.setTransactionId(temp.getTransactionId());
                        result.setDesc(e.getMessage());
                        resultList.add(result);
                    }
                }
            } else {
                try {
                    productService.updateInv(temp);
                } catch (Exception e) {
                    if (!(e instanceof DuplicateKeyException)) {
                        InvNotifyResult result = new InvNotifyResult();
                        result.setTransactionId(temp.getTransactionId());
                        result.setDesc(e.getMessage());
                        resultList.add(result);
                    }
                }
            }
        }
        return dubboResp;
    }

    @Override
    public DubboBatchInstockResponse batchInstock(DubboBatchInstockRequest req) {
        List<InstockResult> failList = Lists.newArrayList();

        List<Long> idList = req.getIdList();
        int size = idList.size();

        for (int i = 0; i < size; i++) {
            try {
                productService.instock(idList.get(i), req.getUserId());
            } catch (Exception e) {

                InstockResult intsockResult = new InstockResult();
                intsockResult.setProductId(idList.get(i));
                intsockResult.setDesc(e.getMessage());
                failList.add(intsockResult);
            }
        }
        DubboBatchInstockResponse dubboResp = new DubboBatchInstockResponse();
        dubboResp.setFailList(failList);
        return dubboResp;
    }

    @Override
    public DubboBatchOnsaleResponse batchOnsale(DubboBatchOnsaleRequest req) {
        List<Long> idList = req.getIdList();
        int size = idList.size();

        List<OnsaleResult> failList = Lists.newArrayList();

        for (int i = 0; i < size; i++) {
            try {
                productService.putOnShelves(idList.get(i), req.getUserId());
            } catch (Exception e) {
                OnsaleResult failMap = new OnsaleResult();
                failMap.setProductId(idList.get(i));
                failMap.setDesc(e.getMessage());
                failList.add(failMap);
            }
        }

        DubboBatchOnsaleResponse dubboResp = new DubboBatchOnsaleResponse();
        dubboResp.setFailList(failList);
        return dubboResp;
    }

    @Override
    public DubboListProductOfShopResponse listProductOfShop(DubboListProductOfShopRequest req) {
        String order = null;
        String direction = null;
        List<DubboSort> sortList = req.getSortList();
        if (!Collections3.isEmpty(sortList)) {
            DubboSort dubboSort = sortList.get(0);
            order = dubboSort.getProperty();
            direction = dubboSort.getDirection();
        }
        if (StringUtils.isNull(order)) {
            order = "onsaleAt";
        }

        if (StringUtils.isNull(direction)) {
            direction = "desc";
        }

        Long shopId = req.getShopId();

        Map<String, Long> page = new HashMap<String, Long>();
        page.put("offset", req.getBeginId());
        page.put("size", req.getPageSize());

        List<Product> products = null;
        switch (order) {
            // 按销量
            case "sales":
                products = productService.listProductsBySales(shopId, page, Direction.fromString(direction));
                break;
            // 按库存
            case "amount":
                products = productService.listProductsByAmount(shopId, page, Direction.fromString(direction));
                break;
            // 按下架时间
            case "soldout":
                products = productService.listProductsBySoldout(shopId, page, Direction.fromString(direction));
                break;
            // 按草稿
            case "statusDraft":
                products = productService.listProductsByStatusDraft(shopId, page);
                break;
            // 按缺货
            case "outofstock":
                products = productService.listProductsByOutOfStock(shopId, page);
                break;
            case "postage":
                products = productService.listProductsByPostAge(shopId, page, Direction.fromString(direction));
                break;
            default:
                products = productService.listProductsByOnsaleAt(shopId, page);
                break;
        }

        Long totalNum = productService.getLastTotalCnt(shopId, order, new HashMap<String, Object>());

        DubboListProductOfShopResponse dubboResp = new DubboListProductOfShopResponse();
        dubboResp.setProductList(BeanMapper.map(products, DubboProduct.class));
        dubboResp.setPageSize(req.getPageSize());
        dubboResp.setCurrentPage(req.getCurrentPage());
        dubboResp.setTotalNum(totalNum);
        return dubboResp;
    }

    @Override
    public DubboQueryProductByLatestSellNumResponse queryProductByLatestSellNum(DubboQueryProductByLatestSellNumRequest req) {
        DubboQueryProductByLatestSellNumResponse dubboResp = new DubboQueryProductByLatestSellNumResponse();

        User user = userService.load(req.getSellerId());
        if (null == user) {
            dubboResp.setCode(ProductReturnCode.USER_NOT_EXIST);
            dubboResp.setDesc("用户不存在");
            return dubboResp;
        }

        Product record = new Product();
        record.setShopId(user.getShopId());
        record.setStatus(ProductStatus.ONSALE);
        List<Product> productList = productService.selectBySelective(record);

        List<Product> resultProductList = Lists.newArrayList();
        Long totalNum = 0L;

        if (!Collections3.isEmpty(productList)) {
            Map<Long, Product> productMap = Maps.newHashMap();
            List<Long> productIdList = Lists.newArrayList();
            List<Long> productIdList1 = Lists.newArrayList();
            List<Long> productIdList2 = Lists.newArrayList();

            for (Product temp : productList) {
                productIdList.add(temp.getId());
                productMap.put(temp.getId(), temp);

                if (temp.getAmount() > 0) {
                    productIdList1.add(temp.getId());
                } else {
                    productIdList2.add(temp.getId());
                }
            }

            Map<String, Long> page = Maps.newHashMap();
            page.put("beginId", req.getBeginId());
            page.put("pageSize", req.getPageSize());

            Long totalNum1 = statisticSpuSellnumMapper.countByProductList(productIdList1);

            List<StatisticSpuSellnum> statisticSpuSellnumList = null;
            if (req.getBeginId() + req.getPageSize() <= totalNum1) {
                statisticSpuSellnumList = statisticSpuSellnumMapper.selectByProductList(productIdList1, page);
            } else if (req.getBeginId() >= totalNum1) {
                statisticSpuSellnumList = statisticSpuSellnumMapper.selectByProductList(productIdList2, page);
            } else {
                List<StatisticSpuSellnum> statisticSpuSellnumList1 = statisticSpuSellnumMapper.selectByProductList(productIdList1, page);
                page.put("beginId", req.getBeginId() + statisticSpuSellnumList1.size());
                page.put("pageSize", req.getPageSize() - statisticSpuSellnumList1.size());
                List<StatisticSpuSellnum> statisticSpuSellnumList2 = statisticSpuSellnumMapper.selectByProductList(productIdList2, page);

                statisticSpuSellnumList = Lists.newArrayList();
                statisticSpuSellnumList.addAll(statisticSpuSellnumList1);
                statisticSpuSellnumList.addAll(statisticSpuSellnumList2);
            }

            totalNum = statisticSpuSellnumMapper.countByProductList(productIdList);

            if (!Collections3.isEmpty(statisticSpuSellnumList)) {
                for (StatisticSpuSellnum tempStatisticSpuSellnum : statisticSpuSellnumList) {
                    resultProductList.add(productMap.get(tempStatisticSpuSellnum.getProductId()));
                }
            }

        }

        dubboResp.setPageSize(req.getPageSize());
        dubboResp.setCurrentPage(req.getCurrentPage());
        dubboResp.setTotalNum(totalNum);

        dubboResp.setProductList(BeanMapper.map(resultProductList, DubboProduct.class));
        return dubboResp;
    }

    @Override
    public DubboBasicResponse lockInv(DubboLockInvRequest req) {
        DubboBasicResponse dubboResp = new DubboBasicResponse();

        try {

            productService.lockInv(req);

        } catch (ServiceException e) {
            dubboResp.setCode(e.getCode());
            dubboResp.setDesc(e.getMessage());
        }

        return dubboResp;

    }

    @Override
    public DubboBasicResponse recoveryInv(DubboRecoveryInvRequest req) {
        DubboBasicResponse dubboResp = new DubboBasicResponse();

        try {
            productService.recovery(req);
        } catch (ServiceException e) {
            dubboResp.setCode(e.getCode());
            dubboResp.setDesc(e.getMessage());
        }

        return dubboResp;
    }

    @Override
    public DubboCronInvResponse cronStatisticProductSellNum(DubboCronInvRequest req) {
        Map<String, Long> params = new HashMap<String, Long>();
        params.put("pageSize", req.getPageSize());
        params.put("beginId", req.getBeginId());
        Product record = new Product();
        record.setStatus(ProductStatus.ONSALE);

        List<Product> productList = productService.selectByPage(record, params);

        DubboCronInvResponse dubboResp = new DubboCronInvResponse();
        dubboResp.setContinueFlag(true);

        if (Collections3.isEmpty(productList)) {
            dubboResp.setContinueFlag(false);
            return dubboResp;
        }
        for (Product temp : productList) {
            updateProductInv(temp);
        }

        return dubboResp;
    }

    private void updateProductInv(Product temp) {
        List<Sku> skuList = skuMapper.selectByProductId(temp.getId());

        Integer sellNum = querySellnum(skuList);
        statisticSpuSellnumMapper.deleteByProductId(temp.getId());

        StatisticSpuSellnum record = new StatisticSpuSellnum();
        record.setProductId(temp.getId());
        record.setSellNum(sellNum);
        record.setShopId(temp.getShopId());
        record.setArchive(false);
        record.setCreateTime(new Date(System.currentTimeMillis()));
        statisticSpuSellnumMapper.insertSelective(record);
    }

    private Integer querySellnum(List<Sku> skuList) {
        DubboQueryOrderSellNumRequest req = new DubboQueryOrderSellNumRequest();
        req.setBeginTime(DateUtil.getBeginTimeOfDay(new Date(System.currentTimeMillis() - 2592000000L)));
        req.setEndTime(DateUtil.getBeginTimeOfDay(new Date(System.currentTimeMillis())));
        req.setOrderStatus(OrderStatusEnum.SUCCESS);
        List<Long> skuIdList = Lists.newArrayList();

        for (Sku tempSku : skuList) {
            skuIdList.add(tempSku.getId());
        }

        List<List<Long>> partition = Lists.partition(skuIdList, 300);

        List<Long> reqList = Lists.newArrayList();
        Map<Long, Integer> resultMap = Maps.newHashMap();
        for (List<Long> temp : partition) {

            reqList.clear();
            reqList.addAll(temp);
            req.setSkuIds(reqList);
            DubboQueryOrderSellNumResponse dubboResp = dubboOrderService.querySellNumBySkuIds(req);

            if (dubboResp.getCode() != 0) {
                throw new ServiceException(ProductReturnCode.FAILED, "查询销量失败");
            }
            resultMap.putAll(dubboResp.getResultMap());

        }

        Integer sellNum = getSellNum(resultMap);
        return sellNum;
    }

    private Integer getSellNum(Map<Long, Integer> resultMap) {
        int result = 0;
        if (!Collections3.isEmpty(resultMap)) {
            Iterator<Entry<Long, Integer>> iterator = resultMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Integer value = iterator.next().getValue();
                result += value;
            }
        }
        return result;
    }

    @Override
    public DubboBasicResponse updateProductAndExt(DubboUpdateProductAndExtRequest req) {
        try {
            String type = req.getType();
            Boolean onlyUpdSales = req.getOnlyUpdSales();

            ProductUpdateLog productUpdateLog = new ProductUpdateLog();
            Long id = req.getProductId();
            Product beforeProduct = productService.loadProductById(id);// 更新前的商品基本信息
            Map<String, Object> infoMap = productService.loadInfo(id);// 更新前的商品更多信息表（用来存放美啦多出的字段）
            HashMap<String, Object> preMap = new HashMap<String, Object>(); // 格式形如：
            // {"table1":"{col1:AAA,col2:BBB}","table2":"{col1:CCC}"}

            Map<String, Object> tempMap = new HashMap<String, Object>();
            tempMap.put("short_intro", infoMap == null ? "" : infoMap.get("short_intro"));
            tempMap.put("short_name", infoMap == null ? "" : infoMap.get("short_name"));
            tempMap.put("product_prefix", infoMap == null ? "" : infoMap.get("product_prefix"));
            tempMap.put("product_suffix", infoMap == null ? "" : infoMap.get("product_suffix"));
            /*
             * tempMap.put("ms_price",infoMap==null?"":infoMap.get("ms_price"));
             * tempMap.put("start_time",infoMap==null?"":infoMap.get("start_time"));
             * tempMap.put("end_time",infoMap==null?"":infoMap.get("end_time"));
             */
            tempMap.put("sql_opt", infoMap == null ? "insert" : "update");
            tempMap.put("product_id", id);

            // 1：更新前操作
            beforeProduct.setDescription("");
            preMap.put("product", beforeProduct);
            if (!onlyUpdSales) {
                preMap.put("infoMap", tempMap);
            }

            productUpdateLog.setPreUpdate(JSONObject.toJSONString(preMap));
            productUpdateLog.setType(Integer.parseInt(type)); // 修改类型
            productUpdateLog.setSystem(ProductUpdateLog.SystemEnum.BOS);
            productUpdateLog.setProductId(beforeProduct.getId());
            productUpdateLog.setOpUserId(req.getOpUserId());// 当前运维人员

            // 2更新操作
            int ret = productService.updateProductLog(req, productUpdateLog, infoMap, beforeProduct);
            if (ret > 0) {
                Product newProduct = productService.loadProductById(id);
                // 更新二维码 2015-8-14
                productService.generateShareImg(newProduct, beforeProduct, null);
                // 商品变更通知社区搜索
                productService.noticeProductUpdateToMeila(newProduct.getId());
                // 商品变更通知oms
                productService.noticeProductUpdateToOms(newProduct.getId());
            }

        } catch (ServiceException se) {
            return new DubboBasicResponse(se.getCode(), se.getMessage());
        } catch (Exception e) {
            return new DubboBasicResponse(ProductReturnCode.FAILED, e.getMessage());
        }

        return new DubboBasicResponse();
    }

    @Override
    public DubboSearchProductResponse searchProduct(DubboSearchProductRequest req) {
        DubboSearchProductResponse dubboResp = new DubboSearchProductResponse();

        // 用户ID转化成shopId进行搜索
        Long userId = req.getUserId();
        Long shopId = req.getShopId();
        if (null != userId) {
            Shop shop = shopMapper.selectByUserId(userId);

            if (null == shop) {
                dubboResp.setCurrentPage(1L);
                dubboResp.setPageSize(req.getCurrentPage());
                dubboResp.setTotalNum(0L);
                return dubboResp;
            }
            shopId = shop.getId();
        }

        String order = req.getOrder();
        String direction = req.getDirection();
        if (StringUtils.isNull(order)) {
            order = "onsale_at";
        }

        if (StringUtils.isNull(direction)) {
            direction = "DESC";
        }

        Map<String, Object> params = Maps.newHashMap();
        params.put("name", req.getProductName());
        params.put("shopId", shopId);
        params.put("productStatus", req.getProductStatus());
        params.put("amountMax", req.getAmountMax());

        params.put("order", order);
        params.put("direction", direction);

        Map<String, Long> page = Maps.newHashMap();
        page.put("beginId", req.getBeginId());
        page.put("pageSize", req.getPageSize());

        List<Product> products = productService.searchProduct(params, page);
        Long totalNum = productService.countProduct(params);

        dubboResp.setProductList(BeanMapper.map(products, DubboProductV1.class));

        List<DubboProductV1> productList = dubboResp.getProductList();

        productService.fixProductInfo(productList);

        dubboResp.setPageSize(req.getPageSize());
        dubboResp.setCurrentPage(req.getCurrentPage());
        dubboResp.setTotalNum(totalNum);
        return dubboResp;
    }

    @Override
    public DubboQuerySkuListResponse querySkuByIdList(DubboQuerySkuByIdListRequest req) {
        DubboQuerySkuListResponse dubboResp = new DubboQuerySkuListResponse();
        List<Long> skuIdList = req.getSkuIdList();
        if (Collections3.isEmpty(skuIdList)) {
            return dubboResp;
        }
        List<Sku> selectByIdList = skuMapper.selectByIdList(skuIdList);
        dubboResp.setDubboSkuBasicInfoList(BeanMapper.map(selectByIdList, DubboSkuBasicInfo.class));
        return dubboResp;
    }

    @Override
    public DubboQueryProductResponse queryProductByIdList(DubboQueryProductByIdListRequest req) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DubboQueryProductResponse queryProduct(DubboQueryProductRequest req) {
        DubboQueryProductResponse dubboResp = new DubboQueryProductResponse();
        Product product = productMapper.selectById(req.getProductId());

        List<DubboProductV1> productList = Lists.newArrayList();
        dubboResp.setProductList(productList);
        if (null != product) {
            List<ProductImage> productImg = productImageMapper.selectByProductId(req.getProductId());
            ProductInfo productInfo = productInfoMapper.selectByProductId(req.getProductId());

            DubboProductV1 dubboV1Product = new DubboProductV1();
            // 先复制商品info信息,以免商品属性信息中时间字段替换商品时间
            BeanMapper.copy(productInfo, dubboV1Product);
            // 复制商品信息
            BeanMapper.copy(product, dubboV1Product);
            dubboV1Product.setProductImgList(BeanMapper.map(productImg, DubboProductImg.class));

            productList.add(dubboV1Product);
        }

        productService.fixProductType(productList);

        return dubboResp;
    }

    @Override
    public DubboQuerySkuResponseV1 querySkuV1(DubboQuerySkuRequestV1 req) {
        DubboQuerySkuResponseV1 dubboResp = new DubboQuerySkuResponseV1();

        List<Sku> skuList = null;
        if (StringUtils.isNotBlank(req.getSkuType())) {
            skuList = skuMapper.selectSkuListByProductId(req.getProductId(), SkuType.valueOf(req.getSkuType()));
        } else {
            skuList = skuMapper.selectByProductId(req.getProductId());
        }
        if (Collections3.isEmpty(skuList)) {
            return dubboResp;
        }
        List<SkuMapping> skuMappingList = skuMappingMapper.selectByProductId(skuList.get(0).getProductId());
        List<DubboSkuMappingV1> dubboSkuMappingList = BeanMapper.map(skuMappingList, DubboSkuMappingV1.class);

        for (DubboSkuMappingV1 temp : dubboSkuMappingList) {
            insertSpecValue(temp, skuList);
        }

        dubboResp.setSkuMappingList(dubboSkuMappingList);
        dubboResp.setSkuList(BeanMapper.map(skuList, DubboSkuV1.class));

        fillSkuExtInfo(dubboResp.getSkuList());

        return dubboResp;
    }

    /**
     * 
     * 功能描述：填充
     * 
     * @param skuList void
     *
     */
    private void fillSkuExtInfo(List<DubboSkuV1> skuList) {
        if (Collections3.isEmpty(skuList)) {
            return;
        }

        List<Long> skuIdList = Lists.newArrayList();
        for (DubboSkuV1 temp : skuList) {
            skuIdList.add(temp.getSkuId());
        }

        Map<Long, SkuExt> skuExtMap = skuService.getSkuExtMap(skuIdList);

        for (DubboSkuV1 temp : skuList) {
            SkuExt skuExt = skuExtMap.get(temp.getSkuId());
            if (null != skuExt) {
                temp.setOutsideSkuCode(skuExt.getOutsideSkuCode());
            }
        }
    }

    private void insertSpecValue(DubboSkuMappingV1 temp, List<Sku> skuList) {
        LinkedHashSet<String> mappingValuesSet = Sets.newLinkedHashSet();
        switch (temp.getSpecKey()) {
            case "spec1":
                for (Sku skuTemp : skuList) {
                    mappingValuesSet.add(skuTemp.getSpec1());
                }
                break;
            case "spec2":
                for (Sku skuTemp : skuList) {
                    mappingValuesSet.add(skuTemp.getSpec2());
                }
                break;
            case "spec3":
                for (Sku skuTemp : skuList) {
                    mappingValuesSet.add(skuTemp.getSpec3());
                }
                break;
            case "spec4":
                for (Sku skuTemp : skuList) {
                    mappingValuesSet.add(skuTemp.getSpec4());
                }
                break;
            case "spec5":
                for (Sku skuTemp : skuList) {
                    mappingValuesSet.add(skuTemp.getSpec5());
                }
                break;
        }
        temp.setMappingValues(Lists.newArrayList(mappingValuesSet));
    }

    @Override
    public DubboQuerySkuResponseV1 searchSkuByUserId(DubboQuerySkuByUserIdRequest req) {
        DubboQuerySkuResponseV1 dubboResp = new DubboQuerySkuResponseV1();
        Shop shop = shopMapper.selectByUserId(req.getUserId());
        if (null == shop) {
            dubboResp.setCode(ProductReturnCode.SHOP_NOT_EXIST);
            dubboResp.setDesc("店铺不存在");
            return dubboResp;
        }

        Product product = new Product();
        product.setShopId(shop.getId());
        product.setName(req.getProductName());

        List<Product> productList = productService.searchSpu(product, new HashMap<String, Object>());

        if (Collections3.isEmpty(productList)) {
            return dubboResp;
        }

        Map<Long, Product> productMap = Maps.newHashMap();

        for (Product temp : productList) {
            productMap.put(temp.getId(), temp);
        }

        List<Long> productIdList = Lists.newArrayList();

        for (Product temp : productList) {
            productIdList.add(temp.getId());
        }

        Map<Long, ProductInfo> productInfoMap = productService.getProductInfoMap(productIdList);

        Map<String, Long> page = Maps.newHashMap();
        page.put("beginId", req.getBeginId());
        page.put("pageSize", req.getPageSize());

        Map<String, Object> params = Maps.newHashMap();

        params.put("skuType", req.getSkuType());
        params.put("skuSource", req.getSkuSource());

        List<Sku> skuList = skuService.searchSkuByProductIdList(params, productIdList, page);
        Long totalNum = skuService.countSkuByProductIdLIst(params, productIdList);

        dubboResp.setSkuList(BeanMapper.map(skuList, DubboSkuV1.class));
        for (DubboSkuV1 temp : dubboResp.getSkuList()) {

            Product tempProduct = productMap.get(temp.getProductId());
            if (null != tempProduct) {
                temp.setProductName(tempProduct.getName());
            }
            ProductInfo productInfo = productInfoMap.get(temp.getProductId());
            if (null != productInfo) {
                String warehouse = productInfo.getWarehouse();
                if (!StringUtils.isBlank(warehouse)) {
                    temp.setWarehouse(warehouse);
                    initWarehouseMap();
                    temp.setWarehouseName(warehouseMap.get(warehouse));
                }
                temp.setDeliveryType(productInfo.getDeliveryType());
            }
        }

        fillSkuExtInfo(dubboResp.getSkuList());

        dubboResp.setPageSize(req.getPageSize());
        dubboResp.setCurrentPage(req.getCurrentPage());
        dubboResp.setTotalNum(totalNum);
        return dubboResp;

    }

    @Override
    public DubboProductStatResponse queryProductStatCount(DubboProductStatRequest request) {
        long startTime = System.currentTimeMillis();

        DubboProductStatResponse response = new DubboProductStatResponse();
        try {
            if (null == request) {
                throw new RuntimeException("DubboProductStatRequest 参数为 null");
            }

            Integer onSaleCount = productMapper.selectOnSaleProductCount(request.getSellerId());
            response.setOnSaleCount(null == onSaleCount ? Integer.valueOf(0) : onSaleCount);

            Integer soldOutCount = productMapper.selectSoldOutProductCount(request.getSellerId());
            response.setSoldOutCount(null == soldOutCount ? Integer.valueOf(0) : soldOutCount);

            response.setSellerId(request.getSellerId());
            logger.info("统计卖家在售商品数量 , request: {}, response:{}, {} ms.", JSONObject.toJSONString(request), JSONObject.toJSONString(response),
                (System.currentTimeMillis() - startTime));
            response.setCode(DubboReturnCode.SUCCESS);
            return response;
        } catch (Exception e) {
            logger.error("统计卖家在售商品数量异常: ", e);
            response.setCode(DubboReturnCode.FAILED);
            response.setDesc("统计失败");
            return response;
        }
    }

    @Override
    public DubboQuerySkuBundleResponse queryBundle(DubboQueryBundleRequest req) {

        DubboQuerySkuBundleResponse dubboResp = new DubboQuerySkuBundleResponse();
        List<Sku> skuList = skuMapper.selectSkuListByProductId(req.getProductId(), SkuType.SPU);
        if (Collections3.isEmpty(skuList)) {
            return dubboResp;
        }

        List<Long> skuIdList = Lists.newArrayList();
        for (Sku temp : skuList) {
            skuIdList.add(temp.getId());
        }

        List<SkuBom> skuBomList = skuBomMapper.selectBomListBySkuBundleIdList(skuIdList);
        if (Collections3.isEmpty(skuBomList)) {
            return dubboResp;
        }

        Map<Long, List<SkuBom>> skuBomMap = Maps.newHashMap();
        List<Long> subSkuIdList = Lists.newArrayList();

        for (SkuBom temp : skuBomList) {
            List<SkuBom> list = skuBomMap.get(temp.getSpuId());
            if (null == list) {
                list = Lists.newArrayList();
                skuBomMap.put(temp.getSpuId(), list);
            }
            list.add(temp);
            subSkuIdList.add(temp.getSubSkuId());
        }

        List<DubboBundleV1> dubboSkuBundleList = BeanMapper.map(skuList, DubboBundleV1.class);

        List<Sku> subSkuList = skuMapper.selectByIdList(subSkuIdList);
        Map<Long, Sku> subSkuMap = Maps.newHashMap();
        List<Long> productIdList = Lists.newArrayList();
        for (Sku temp : subSkuList) {
            productIdList.add(temp.getProductId());
            subSkuMap.put(temp.getId(), temp);
        }

        List<Product> productList = productMapper.selectByIdList(productIdList);
        Map<Long, Product> productMap = Maps.newHashMap();

        for (Product temp : productList) {
            productMap.put(temp.getId(), temp);
        }

        for (DubboBundleV1 temp : dubboSkuBundleList) {
            temp.setBundleInfoList(BeanMapper.map(skuBomMap.get(temp.getBundleId()), DubboBundleInfoV1.class));

            for (DubboBundleInfoV1 temp1 : temp.getBundleInfoList()) {
                temp1.setSubSku(BeanMapper.map(subSkuMap.get(temp1.getSubSkuId()), DubboSkuV1.class));
                temp1.setProductName(productMap.get(subSkuMap.get(temp1.getSubSkuId()).getProductId()).getName());
            }
        }

        dubboResp.setSkuBundleList(dubboSkuBundleList);
        return dubboResp;
    }

    @Override
    public DubboBasicResponse updateProductStatus(DubboUpdateProductStatusRequest req) {
        DubboBasicResponse dubboResp = new DubboBasicResponse();
        try {
            productService.updateProductStatus(req.getUserId(), req.getProductId(), ProductStatus.valueOf(req.getProductStatus()),
                req.getForsaleAt());
        } catch (ServiceException e) {
            dubboResp.setCode(e.getCode());
            dubboResp.setDesc(e.getMessage());
        }
        return dubboResp;
    }

    @Override
    public DubboQueryProductResponse queryProductBySkuId(DubboQueryProductBySkuIdRequest req) {
        DubboQueryProductResponse dubboResp = new DubboQueryProductResponse();

        Sku sku = skuMapper.selectByPrimaryKey(req.getSkuId());
        if (null == sku) {
            dubboResp.setCode(ProductReturnCode.SKU_NOT_EXIST);
            dubboResp.setDesc("sku不存在");
            return dubboResp;
        }

        Product product = productService.loadProductById(sku.getProductId());
        if (null == product) {
            dubboResp.setCode(ProductReturnCode.SPU_NOT_EXIST);
            dubboResp.setDesc("商品不存在");
            return dubboResp;

        }

        ProductInfo productInfo = productInfoMapper.selectByProductId(sku.getProductId());

        DubboProductV1 dubboProduct = new DubboProductV1();

        if (null != productInfo) {
            BeanMapper.copy(productInfo, dubboProduct);
        }

        BeanMapper.copy(product, dubboProduct);
        List<DubboProductV1> dubboProductList = Lists.newArrayList();
        dubboProductList.add(dubboProduct);

        dubboResp.setProductList(dubboProductList);
        return dubboResp;
    }
}
