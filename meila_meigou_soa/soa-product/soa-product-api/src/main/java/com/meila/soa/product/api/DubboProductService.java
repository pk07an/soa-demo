package com.meila.soa.product.api;

import com.meila.dubbo.base.model.DubboBasicResponse;
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
import com.meila.soa.product.api.model.response.DubboBatchOnsaleResponse;
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
import com.meila.soa.product.api.model.response.DubboSyncInventoryResponse;
import com.meila.soa.product.api.model.response.DubboSyncProductResponse;
import com.meila.soa.product.api.model.response.inventory.DubboWmsInvNotifyResponse;
import com.meila.soa.product.api.model.response.product.DubboAddProductResponse;
import com.meila.soa.product.api.model.response.product.DubboQueryProductResponse;
import com.meila.soa.product.api.model.response.product.DubboQuerySkuBundleResponse;
import com.meila.soa.product.api.model.response.product.DubboSearchProductResponse;
import com.meila.soa.product.api.model.response.product.v1.DubboQuerySkuResponseV1;

public interface DubboProductService {

    /**
     * 
     * 功能描述：同步Erp Sku信息,代理层调用
     * 
     * @param req
     * @return DubboSyncProductResponse
     *
     */
    public DubboSyncProductResponse syncErpSku(DubboSyncProductRequest req);

    /**
     *
     * 功能描述：查询商品列表
     * 
     * @param req
     * @return DubboQueryErpSkuListResponse
     *
     */
    public DubboQueryErpSkuListResponse queryErpSkuList(DubboQueryErpSkuListRequest req);

    /**
     * 
     * 功能描述：查询SPU信息
     * 
     * @param req
     * @return DubboQuerySpuResponse
     *
     */
    public DubboQuerySpuResponse querySpuById(DubboQuerySpuByIdRequest req);

    /**
     * 
     * 功能描述：查询商品基础信息
     * 
     * @param req
     * @return DubboQuerySpuResponse
     *
     */
    public DubboQuerySpuResponse querySpuBaseInfoById(DubboQuerySpuByIdRequest req);

    /**
     * 
     * 功能描述：根据code列表查询SPU信息
     * 
     * @param req
     * @return DubboQuerySpuResponse
     *
     */
    public DubboQuerySpuResponse querySpuByCode(DubboQuerySpuByCodeRequest req);

    /**
     *
     * 功能描述：同步分类树
     * 
     * @param req
     * @return DubboSyncCategoryResponse
     *
     */
    public DubboSyncCategoryResponse syncCategory(DubboSyncCategoryRequest req);

    /**
     * 
     * 功能描述：查询分类树
     * 
     * @param req
     * @return DubboQueryCategoryResponse
     *
     */
    public DubboQueryCategoryResponse queryCategory(DubboQueryCategoryRequest req);

    /**
     * 
     * 功能描述：同步库存
     * 
     * @param req
     * @return DubboSyncInventoryResponse
     *
     */
    public DubboSyncInventoryResponse syncInventory(DubboSyncInventoryRequest req);

    /*
     * 功能描述：添加商品套餐
     * 
     * 0:success 3:参数错误(保税仓报关价格不能为空并且必须大于0或者价格不一致的时候返回) 10004:多规格商品不可编辑套餐 10005:套餐名已存在 10006:商品不存在 30001:店铺不存在
     * 
     * @param req
     * 
     * @return DubboAddProductBomResponse
     *
     */
    DubboBasicResponse addSkuBundle(DubboAddSkuBundleRequest req);

    /**
     * 
     * 功能描述： 保存SKU接口，对应pc中保存ERP SKU接口
     * 
     * @param req
     * @return DubboBasicResponse
     *
     */
    DubboBasicResponse updateSku(DubboUpdateSkuRequest req);

    /**
     * 
     * 功能描述：搜索SPU
     * 
     * @param req
     * @return DubboQuerySpuListResponse
     *
     */
    DubboQuerySpuListResponse searchSpu(DubboSearchSpuListRequest req);

    /**
     * 
     * 功能描述： 查询SPU
     * 
     * @param req
     * @return DubboQuerySpuListResponse
     *
     */
    DubboQuerySpuListResponse querySpu(DubboQuerySpuListRequest req);

    /**
     * 
     * 功能描述：查询SKU信息
     * 
     * @param req
     * @return DubboQuerySkuListResponse
     *
     */
    DubboQuerySkuListResponse querySku(DubboQuerySkuListRequest req);

    /**
     * 
     * 功能描述：根据商品ID查询sku
     * 
     * @param req
     * @return DubboQuerySkuResponseV1
     *
     */
    DubboQuerySkuResponseV1 querySkuV1(DubboQuerySkuRequestV1 req);

    /**
     * 
     * 功能描述：查询
     * 
     * @param req
     * @return DubboQuerySkuBundleResponse
     *
     */
    DubboQuerySkuBundleResponse queryBundle(DubboQueryBundleRequest req);

    DubboQuerySkuListResponse querySkuByIdList(DubboQuerySkuByIdListRequest req);

    DubboQuerySkuResponseV1 searchSkuByUserId(DubboQuerySkuByUserIdRequest req);

    /**
     * 
     * 功能描述：添加spu基础信息
     * 
     * @param req
     * @return DubboBasicResponse
     *
     */
    DubboAddProductResponse addProduct(DubboAddSpuRequest req);

    /**
     * 
     * 功能描述：更新SPU
     * 
     * @param req
     * @return DubboBasicResponse
     *
     */
    DubboBasicResponse updateSpu(DubboUpdateSpuRequest req);

    DubboBasicResponse updateProductAndExt(DubboUpdateProductAndExtRequest req);

    /**
     * 
     * 功能描述：查询缓存的实际库存信息
     * 
     * @param req
     * @return DubboQueryCachedInvResponse
     *
     */
    public DubboQueryCachedInvResponse queryCachedInv(DubboQueryCachedInvRequest req);

    /**
     * 
     * 功能描述：定时任务统计库存缺口信息
     * 
     * @param req
     * @return DubboBasicResponse
     *
     */
    public DubboCronInvResponse cronQueryInvShort(DubboCronInvRequest req);

    /**
     * 
     * 功能描述：库存变化通知接口
     * 
     * @param req
     * @return DubboWmsInvNotifyResponse
     *
     */
    DubboWmsInvNotifyResponse invNotify(DubboWmsInvNotifyRequest req);

    /**
     * 
     * 功能描述：批量下架
     * 
     * @param req
     * @return DubboBatchInstockResponse
     *
     */
    DubboBatchInstockResponse batchInstock(DubboBatchInstockRequest req);

    DubboBatchOnsaleResponse batchOnsale(DubboBatchOnsaleRequest req);

    DubboListProductOfShopResponse listProductOfShop(DubboListProductOfShopRequest req);

    /**
     * 
     * 功能描述：查询销量最高产品
     * 
     * @param req
     * @return DubboQueryProductByLatestSellNumResponse
     *
     */
    DubboQueryProductByLatestSellNumResponse queryProductByLatestSellNum(DubboQueryProductByLatestSellNumRequest req);

    /**
     * 
     * 功能描述：下单时锁库存接口
     * 
     * @param req
     * @return DubboBasicResponse
     *
     */
    DubboBasicResponse lockInv(DubboLockInvRequest req);

    /**
     * 
     * 功能描述：回退锁库存接口
     * 
     * @param req
     * @return DubboBasicResponse
     *
     */
    DubboBasicResponse recoveryInv(DubboRecoveryInvRequest req);

    DubboCronInvResponse cronStatisticProductSellNum(DubboCronInvRequest req);

    DubboSearchProductResponse searchProduct(DubboSearchProductRequest req);

    DubboQueryProductResponse queryProductByIdList(DubboQueryProductByIdListRequest req);

    DubboQueryProductResponse queryProduct(DubboQueryProductRequest req);

    /**
     * 
     * 功能描述：查询sku对应的product
     * 
     * @param req
     * @return DubboQueryProductResponse
     *
     */
    DubboQueryProductResponse queryProductBySkuId(DubboQueryProductBySkuIdRequest req);

    /**
     *
     * 功能描述：统计商品信息, 如在售商品等
     * 
     * @param request
     * @return DubboProductStatResponse
     *
     */
    DubboProductStatResponse queryProductStatCount(DubboProductStatRequest request);

    DubboBasicResponse updateProductStatus(DubboUpdateProductStatusRequest request);
}
