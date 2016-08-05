/**
 * 
 */
package com.meila.soa.openapi.thrift.product.impl;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.alibaba.dubbo.rpc.RpcException;
import com.meila.dubbo.base.constant.DubboReturnCode;
import com.meila.soa.openapi.thrift.core.ThriftReturnCode;
import com.meila.soa.openapi.thrift.product.model.CartOperationType;
import com.meila.soa.openapi.thrift.product.model.ThriftCartItemResult;
import com.meila.soa.openapi.thrift.product.model.ThriftPageShopModel;
import com.meila.soa.openapi.thrift.product.model.ThriftPageSimpleProductModel;
import com.meila.soa.openapi.thrift.product.model.ThriftProductModel;
import com.meila.soa.openapi.thrift.product.model.ThriftShopModel;
import com.meila.soa.openapi.thrift.product.model.ThriftSimpleProductModel;
import com.meila.soa.product.api.DubboCartService;
import com.meila.soa.product.api.DubboProductService;
import com.meila.soa.product.api.DubboShopService;
import com.meila.soa.product.api.model.dto.DubboProduct;
import com.meila.soa.product.api.model.dto.DubboShop;
import com.meila.soa.product.api.model.dto.DubboShopAdmin;
import com.meila.soa.product.api.model.dto.DubboSpuBasicInfo;
import com.meila.soa.product.api.model.request.DubboAddToCartBySkuCodRequest;
import com.meila.soa.product.api.model.request.DubboQueryProductByLatestSellNumRequest;
import com.meila.soa.product.api.model.request.DubboQuerySpuByCodeRequest;
import com.meila.soa.product.api.model.request.DubboQuerySpuByIdRequest;
import com.meila.soa.product.api.model.request.DubboQuerySpuListRequest;
import com.meila.soa.product.api.model.request.DubboSearchShopRequest;
import com.meila.soa.product.api.model.request.shop.DubboQueryShopByOwnerIdListRequest;
import com.meila.soa.product.api.model.response.DubboAddCartResponse;
import com.meila.soa.product.api.model.response.DubboQueryProductByLatestSellNumResponse;
import com.meila.soa.product.api.model.response.DubboQueryShopResponse;
import com.meila.soa.product.api.model.response.DubboQuerySpuListResponse;
import com.meila.soa.product.api.model.response.DubboQuerySpuResponse;
import com.meila.soa.product.api.model.response.DubboSearchShopResponse;

/**
 ************************************************************
 * @类名 : ThriftProductServiceImpl.java
 *
 * @DESCRIPTION :
 * @AUTHOR : flong
 * @DATE : 2016年1月20日
 ************************************************************
 */
public class ThriftProductServiceImpl implements com.meila.soa.openapi.thrift.product.ThriftProductService.Iface {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Value("${thrift.application.name:thrift-product-service}")
    private String appName;

    @Autowired
    private DubboProductService productService;
    @Autowired
    private DubboCartService cartService;
    @Autowired
    private DubboShopService shopService;

    /**
     * 优惠券管理平台使用商品id列表查询商品图片及所属店铺名称等属性
     */
    @Override
    public List<ThriftProductModel> findProductByIds(List<Long> ids) throws TException {
        List<ThriftProductModel> productList = new ArrayList<ThriftProductModel>();
        DubboQuerySpuByIdRequest request = new DubboQuerySpuByIdRequest();
        request.setProductIdList(ids);
        DubboQuerySpuResponse dubboQuerySPUResponse = null;
        try {
            dubboQuerySPUResponse = productService.querySpuById(request);
        } catch (RpcException e) {
            logger.error("调用productService.querySpuById失败", e);
            return productList;
        }
        if (dubboQuerySPUResponse.getCode() == DubboReturnCode.SUCCESS) {
            ThriftProductModel model = null;
            if (dubboQuerySPUResponse.getProductList() != null) {
                for (DubboProduct dubboProduct : dubboQuerySPUResponse.getProductList()) {
                    model = ThriftProductConverter.spudubbo2thrift(dubboProduct);
                    productList.add(model);
                }
            }
        }
        return productList;
    }

    /**
     * V5.0中批量查询商品及所属sku列表
     */
    @Override
    public List<ThriftProductModel> findSkuByIds(List<String> codes) throws TException {

        List<ThriftProductModel> list = new ArrayList<ThriftProductModel>();
        if (codes == null || codes.size() == 0) {
            return list;
        }
        DubboQuerySpuByCodeRequest request = new DubboQuerySpuByCodeRequest();
        request.setCodeList(codes);
        DubboQuerySpuResponse response = null;
        try {
            response = productService.querySpuByCode(request);
        } catch (RpcException e) {
            logger.error("调用productService.querySpuByCode失败", e);
            return list;
        }
        if (response == null || response.getCode() != DubboReturnCode.SUCCESS) {
            return list;
        }
        if (response.getProductList() == null || response.getProductList().size() == 0) {
            return list;
        }
        ThriftProductModel model = null;
        for (DubboProduct dubboProduct : response.getProductList()) {
            model = ThriftProductConverter.spudubbo2thrift(dubboProduct);
            if (model != null) {
                list.add(model);
            }
        }
        return list;
    }

    @Override
    public ThriftCartItemResult addToCart(long userId, String skuCode, int buyNum, CartOperationType type, String sourceFrom) throws TException {
        ThriftCartItemResult result = new ThriftCartItemResult();
        DubboAddToCartBySkuCodRequest cartRequest = new DubboAddToCartBySkuCodRequest();
        cartRequest.setUserId(userId);
        cartRequest.setSkuCode(skuCode);
        cartRequest.setAmount(buyNum);
        cartRequest.setCartType(type.getValue());
        cartRequest.setFromSource(sourceFrom);
        DubboAddCartResponse dubboResponse = null;
        try {
            dubboResponse = cartService.addToCartBySkuCodeWithItemIdReturn(cartRequest);
        } catch (RpcException e) {
            Throwable throwable = e.getCause();
            if (throwable != null && throwable instanceof ConstraintViolationException) {
                result.setCode(ThriftReturnCode.INVALID_PARAMS);
                result.setDescription(ThriftReturnCode.getConstraintViolationException(throwable));
            } else {
                result.setCode(ThriftReturnCode.FAILED);
                result.setDescription("系统繁忙");
            }
            return result;
        }
        if (dubboResponse == null) {
            result.setCode(ThriftReturnCode.FAILED);
            result.setDescription("商品数据不存在");
            return result;
        }
        result.setCode(dubboResponse.getCode());
        result.setDescription(dubboResponse.getDesc());
        result.setTid(dubboResponse.getTid());
        result.setItemId(dubboResponse.getItemId() == null ? 0L : dubboResponse.getItemId());
        result.setProductId(dubboResponse.getProductId() == null ? 0L : dubboResponse.getProductId());
        result.setSkuId(dubboResponse.getSkuId() == null ? 0L : dubboResponse.getSkuId());
        result.setPrice(dubboResponse.getPrice() == null ? 0 : dubboResponse.getPrice().doubleValue());
        return result;
    }

    @Override
    public List<ThriftSimpleProductModel> findValidProductByIds(List<Long> ids) throws TException {
        List<ThriftSimpleProductModel> productList = new ArrayList<ThriftSimpleProductModel>();
        DubboQuerySpuByIdRequest request = new DubboQuerySpuByIdRequest();
        request.setProductIdList(ids);
        DubboQuerySpuResponse dubboQuerySPUResponse = null;
        try {
            dubboQuerySPUResponse = productService.querySpuBaseInfoById(request);
        } catch (RpcException e) {
            logger.error("调用productService.querySpuById失败", e);
            return productList;
        }
        if (dubboQuerySPUResponse.getCode() == DubboReturnCode.SUCCESS) {
            ThriftSimpleProductModel model = null;
            if (dubboQuerySPUResponse.getProductList() != null) {
                for (DubboProduct dubboProduct : dubboQuerySPUResponse.getProductList()) {
                    model = new ThriftSimpleProductModel();
                    model.setId(dubboProduct.getProductId());
                    model.setCode(dubboProduct.getCode());
                    productList.add(model);
                }
            }
        }
        return productList;
    }

    @Override
    public ThriftPageSimpleProductModel findTopProductBySellId(long sellerId, int dayNum, int pageNo, int pageSize) throws TException {
        ThriftPageSimpleProductModel result = new ThriftPageSimpleProductModel();
        DubboQueryProductByLatestSellNumRequest request = new DubboQueryProductByLatestSellNumRequest();
        request.setSellerId(sellerId);
        request.setDayNum(dayNum);
        request.setCurrentPage(new Long(pageNo));
        request.setPageSize(new Long(pageSize));
        DubboQueryProductByLatestSellNumResponse response = null;
        try {
            response = productService.queryProductByLatestSellNum(request);
        } catch (RpcException e) {
            logger.error("调用productService.findTopProductBySellId失败", e);
            return result;
        }
        if (response.getCode() == DubboReturnCode.SUCCESS) {
            result.setTotalNum(response.getTotalNum().intValue());
            result.setPageNo(pageNo);
            result.setPageSize(pageSize);
            List<ThriftSimpleProductModel> list = new ArrayList<ThriftSimpleProductModel>();
            if (response.getProductList() != null && response.getProductList().size() > 0) {
                for (DubboProduct dubboProduct : response.getProductList()) {
                    ThriftSimpleProductModel model = new ThriftSimpleProductModel();
                    model.setId(dubboProduct.getProductId());
                    model.setCode(dubboProduct.getCode());
                    list.add(model);
                }
            }
            result.setSpus(list);
        }
        return result;
    }

    @Override
    public List<ThriftShopModel> findShopBySellerId(List<Long> ids) throws TException {
        List<ThriftShopModel> result = new ArrayList<ThriftShopModel>();
        DubboQueryShopByOwnerIdListRequest request = new DubboQueryShopByOwnerIdListRequest();
        request.setOwnerIdList(ids);
        DubboQueryShopResponse response = null;
        try {
            response = shopService.queryShopWithExtByOwnerId(request);
        } catch (RpcException e) {
            logger.error("调用shopService.findShopBySellerId失败", e);
            return result;
        }
        if (response.getCode() == DubboReturnCode.SUCCESS) {
            ThriftShopModel model = null;
            if (response.getShopList() != null) {
                for (DubboShop dubboShop : response.getShopList()) {
                    model = new ThriftShopModel();
                    model.setShopId(dubboShop.getShopId());
                    model.setSellId(dubboShop.getOwnerId());
                    model.setName(dubboShop.getShopName());
                    model.setDescription(dubboShop.getDescription());
                    model.setImg(dubboShop.getShopImg());
                    model.setShortIntro(dubboShop.getShopExt().getShortIntro());
                    model.setSellerType(dubboShop.getShopExt().getSellerType() == null ? 1 : dubboShop.getShopExt().getSellerType());
                    model.setSellerCertification(dubboShop.getShopExt().getSellerCertification());
                    model.setSelfhoodName(dubboShop.getShopExt().getSelfhoodName());
                    result.add(model);
                }
            }
        }
        return result;
    }

    @Override
    public ThriftPageShopModel findPagedShop(int pageNo, int pageSize) throws TException {
        ThriftPageShopModel result = new ThriftPageShopModel();
        DubboSearchShopRequest request = new DubboSearchShopRequest();
        request.setCurrentPage(new Long(pageNo));
        request.setPageSize(new Long(pageSize));
        request.setShopStatus("ACTIVE");
        DubboSearchShopResponse response = shopService.searchShop(request);
        if (response != null) {
            result.setTotalNum(response.getTotalNum().intValue());
            result.setPageNo(pageNo);
            result.setPageSize(pageSize);
            List<ThriftShopModel> list = new ArrayList<ThriftShopModel>();
            if (response.getShopAdminList() != null && response.getShopAdminList().size() > 0) {
                for (DubboShopAdmin dubboShopAdmin : response.getShopAdminList()) {
                    list.add(ThriftProductConverter.shopAdminDubbo2Thrift(dubboShopAdmin));
                }
            }
            result.setShops(list);
        }
        return result;
    }

    @Override
    public ThriftPageSimpleProductModel findPagedProduct(int pageNo, int pageSize) throws TException {
        ThriftPageSimpleProductModel result = new ThriftPageSimpleProductModel();
        DubboQuerySpuListRequest request = new DubboQuerySpuListRequest();
        request.setCurrentPage(new Long(pageNo));
        request.setPageSize(new Long(pageSize));
        DubboQuerySpuListResponse response = null;
        try {
            response = productService.querySpu(request);
        } catch (RpcException e) {
            logger.error("调用productService.findPagedProduct失败", e);
            return result;
        }
        if (response.getCode() == DubboReturnCode.SUCCESS) {
            result.setTotalNum(response.getTotalNum().intValue());
            result.setPageNo(pageNo);
            result.setPageSize(pageSize);
            List<ThriftSimpleProductModel> list = new ArrayList<ThriftSimpleProductModel>();
            if (response.getSpuBasicInfoList() != null && response.getSpuBasicInfoList().size() > 0) {
                for (DubboSpuBasicInfo dubboSpuBasicInfo : response.getSpuBasicInfoList()) {
                    ThriftSimpleProductModel model = new ThriftSimpleProductModel();
                    model.setId(dubboSpuBasicInfo.getProductId());
                    model.setCode(dubboSpuBasicInfo.getProductCode());
                    list.add(model);
                }
            }
            result.setSpus(list);
        }
        return result;
    }
}
