package com.meila.soa.product.service.innerservice;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Sort.Direction;

import com.meila.soa.product.api.model.dto.DubboSku;
import com.meila.soa.product.api.model.dto.DubboSkuAmountInfo;
import com.meila.soa.product.api.model.dto.DubboSkuBundle;
import com.meila.soa.product.api.model.dto.product.v1.DubboProductV1;
import com.meila.soa.product.api.model.request.inventory.DubboLockInvRequest;
import com.meila.soa.product.api.model.request.inventory.DubboRecoveryInvRequest;
import com.meila.soa.product.api.model.request.inventory.DubboWmsInvNotifyRequest.DubboInvNotify;
import com.meila.soa.product.api.model.request.product.DubboUpdateProductAndExtRequest;
import com.meila.soa.product.dal.entity.product.Product;
import com.meila.soa.product.dal.entity.product.ProductImage;
import com.meila.soa.product.dal.entity.product.ProductInfo;
import com.meila.soa.product.dal.entity.product.ProductUpdateLog;
import com.meila.soa.product.dal.entity.product.Sku;
import com.meila.soa.product.dal.entity.product.SkuBom;
import com.meila.soa.product.dal.entity.product.SkuMapping;
import com.meila.soa.product.dal.entity.user.User;
import com.meila.soa.product.dal.type.DeliveryType;
import com.meila.soa.product.dal.type.ProductStatus;
import com.meila.soa.product.dal.type.SkuType;
import com.meila.soa.product.service.model.SkuMappingModel;

public interface ProductService {

    Map<String, Object> createProductDeliveryInfo(ProductInfo productInfo, DeliveryType deliveryType);

    List<SkuMappingModel> skuMappingToVO(Long productId, List<DubboSku> skus);

    boolean checkUserIdForBomLimit(Long userId);

    Sku findSpuByProductIdAndName(Long id, String skuBundleName);

    void saveOrUpdateBom(List<DubboSkuBundle> bomsList, String specName, Long productId);

    void saveSku(Sku sku);

    void addSkuCode(Long[] ids);

    Sku loadSku(Long skuId);

    void updateSku(Sku sku);

    void updateSkuBom(SkuBom bom);

    void insertSkuBom(SkuBom bom);

    List<Product> querySpuPage(Product product, Map<String, Long> page);

    List<Product> searchSpu(Product product, Map<String, Object> params);

    Long countSearchSpu(Product product, Map<String, Object> params);

    Product saveProduct(Product product, List<ProductImage> imgs, ProductInfo productInfo, User user);

    void generateShareImg(Product newProduct, Product oldProduct, ProductInfo productInfo);

    Map<String, Object> loadInfo(Long productId);

    void noticeProductUpdateToMeila(String productCode);

    List<Sku> selectSkuListByProductId(Long productId, SkuType normal);

    List<SkuBom> selectBomListBySkuList(List<Sku> skuList);

    List<ProductInfo> selectProductInfoListByBomList(List<SkuBom> bomList);

    void updateProduct(Product product, List<ProductImage> imgs, ProductInfo productInfo, User user);

    void clearProductCache(Product product);

    /**
     * 通过商品ID查找到对应的商品
     * 
     * @param productId 商品ID
     * @return Product 商品
     * @exception {说明在某情况下,将发生什么异常}
     */
    public Product loadProductById(Long productId);

    void saveSkuAndMapping(Product product, List<Sku> skuList, List<SkuMapping> skuMappingList, Integer bomsFlag);

    List<Sku> selectSkuExtBySkuList(List<Sku> saveSkuist);

    List<SkuMapping> loadSkuMapping(Long id);

    void getErpSkuWarehouseInfo(List<Sku> saveSkuist);

    List<Product> selectProductListByShopId(Long id);

    ProductInfo selectProductInfoBySkuId(Long subSkuId);

    ProductInfo loadProduvtExtByProductId(Long productId);

    void updateInv(DubboInvNotify temp);

    void updateInvOfTR(DubboInvNotify temp);

    int instock(Long productId, Long userId);

    int putOnShelves(Long string, Long userId);

    List<Product> listProductsBySales(Long shopId, Map<String, Long> pageable, Direction fromString);

    List<Product> listProductsBySales1(Long shopId, Map<String, Object> pageable, Direction fromString);

    List<Product> listProductsByAmount(Long shopId, Map<String, Long> pageable, Direction fromString);

    List<Product> listProductsByAmount1(Long shopId, Map<String, Object> pageable, Direction fromString);

    List<Product> listProductsBySoldout(Long shopId, Map<String, Long> pageable, Direction fromString);

    List<Product> listProductsBySoldout1(Long shopId, Map<String, Object> pageable, Direction fromString);

    List<Product> listProductsByStatusDraft(Long shopId, Map<String, Long> pageable);

    List<Product> listProductsByStatusDraft1(Long shopId, Map<String, Object> pageable);

    List<Product> listProductsByOutOfStock(Long shopId, Map<String, Long> pageable);

    List<Product> listProductsByOutOfStock1(Long shopId, Map<String, Object> pageable);

    List<Product> listProductsByPostAge(Long shopId, Map<String, Long> pageable, Direction fromString);

    List<Product> listProductsByOnsaleAt(Long shopId, Map<String, Long> pageable);

    List<Product> searchProduct(Map<String, Object> parmas, Map<String, Long> page);

    Long getLastTotalCnt(Long shopId, String order, HashMap<String, Object> hashMap);

    Long querySpuPageNum(Product product, Map<String, Long> page);

    List<Product> selectBySelective(Product record);

    List<Product> selectByPage(Product record, Map<String, Long> params);

    int updateProductLog(DubboUpdateProductAndExtRequest req, ProductUpdateLog productUpdateLog, Map<String, Object> infoMap, Product beforeProduct);

    void noticeProductUpdateToMeila(Long id);

    void noticeProductUpdateToOms(Long id);

    Long querySkuPageNum(Sku sku, Map<String, Long> page);

    List<Sku> querySkuPage(Sku sku, Map<String, Long> page);

    List<Sku> querySkuByProductIds(List<Long> productIds);

    List<Sku> querySku(List<Long> productIds, String skuType);

    Long countProduct(Map<String, Object> params);

    void lockInvBySkuId(DubboSkuAmountInfo temp);

    void recoveryInvBySkuId(DubboSkuAmountInfo temp);

    void lockInv(DubboLockInvRequest req);

    void recovery(DubboRecoveryInvRequest req);

    void fixProductType(List<DubboProductV1> productList);

    void fixProductInfo(List<DubboProductV1> productList);

    Map<Long, ProductInfo> getProductInfoMap(List<Long> productIdList);

    void updateProductStatus(Long userId, Long productId, ProductStatus status, Date forsaleAt);

    void saveProductSku(Product product, List<Sku> skuList);

}
