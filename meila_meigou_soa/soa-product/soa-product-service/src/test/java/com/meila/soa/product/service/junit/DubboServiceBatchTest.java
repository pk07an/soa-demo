package com.meila.soa.product.service.junit;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.meila.common.bean.utils.BeanMapper;
import com.meila.dubbo.base.constant.DubboReturnCode;
import com.meila.dubbo.base.model.DubboBasicPageRequest2.DubboSort;
import com.meila.dubbo.base.model.DubboBasicResponse;
import com.meila.soa.product.api.DubboCartService;
import com.meila.soa.product.api.DubboFragmentService;
import com.meila.soa.product.api.DubboProductService;
import com.meila.soa.product.api.DubboShopService;
import com.meila.soa.product.api.constant.ProductReturnCode;
import com.meila.soa.product.api.constant.SkuInvChangeType;
import com.meila.soa.product.api.model.dto.DubboCategory;
import com.meila.soa.product.api.model.dto.DubboInventory;
import com.meila.soa.product.api.model.dto.DubboProductImage;
import com.meila.soa.product.api.model.dto.DubboProductSku;
import com.meila.soa.product.api.model.dto.DubboSkuBundle;
import com.meila.soa.product.api.model.dto.DubboSkuBundleInfo;
import com.meila.soa.product.api.model.dto.fragment.DubboFragmentImage;
import com.meila.soa.product.api.model.dto.product.v1.DubboProductImg;
import com.meila.soa.product.api.model.request.DubboAddFragmentRequest;
import com.meila.soa.product.api.model.request.DubboAddProductFragmentInfoRequest;
import com.meila.soa.product.api.model.request.DubboAddShopRequest;
import com.meila.soa.product.api.model.request.DubboAddSkuBundleRequest;
import com.meila.soa.product.api.model.request.DubboAddToCartBySkuCodRequest;
import com.meila.soa.product.api.model.request.DubboAddToCartRequest;
import com.meila.soa.product.api.model.request.DubboBatchInstockRequest;
import com.meila.soa.product.api.model.request.DubboBatchOnsaleRequest;
import com.meila.soa.product.api.model.request.DubboCronInvRequest;
import com.meila.soa.product.api.model.request.DubboListProductOfShopRequest;
import com.meila.soa.product.api.model.request.DubboQueryCachedInvRequest;
import com.meila.soa.product.api.model.request.DubboQueryCategoryRequest;
import com.meila.soa.product.api.model.request.DubboQueryErpSkuListRequest;
import com.meila.soa.product.api.model.request.DubboQueryFragmentRequest;
import com.meila.soa.product.api.model.request.DubboQueryProductByLatestSellNumRequest;
import com.meila.soa.product.api.model.request.DubboQueryShopRequest;
import com.meila.soa.product.api.model.request.DubboQuerySpuByCodeRequest;
import com.meila.soa.product.api.model.request.DubboQuerySpuByIdRequest;
import com.meila.soa.product.api.model.request.DubboQuerySpuListRequest;
import com.meila.soa.product.api.model.request.DubboSearchSpuListRequest;
import com.meila.soa.product.api.model.request.DubboSyncCategoryRequest;
import com.meila.soa.product.api.model.request.DubboSyncInventoryRequest;
import com.meila.soa.product.api.model.request.DubboSyncProductRequest;
import com.meila.soa.product.api.model.request.inventory.DubboWmsInvNotifyRequest;
import com.meila.soa.product.api.model.request.inventory.DubboWmsInvNotifyRequest.DubboInvNotify;
import com.meila.soa.product.api.model.request.product.DubboAddSpuRequest;
import com.meila.soa.product.api.model.request.product.DubboUpdateSpuRequest;
import com.meila.soa.product.api.model.response.DubboAddFragmentResponse;
import com.meila.soa.product.api.model.response.DubboBatchInstockResponse;
import com.meila.soa.product.api.model.response.DubboBatchOnsaleResponse;
import com.meila.soa.product.api.model.response.DubboCronInvResponse;
import com.meila.soa.product.api.model.response.DubboListProductOfShopResponse;
import com.meila.soa.product.api.model.response.DubboQueryCategoryResponse;
import com.meila.soa.product.api.model.response.DubboQueryErpSkuListResponse;
import com.meila.soa.product.api.model.response.DubboQueryFragmentResponse;
import com.meila.soa.product.api.model.response.DubboQueryProductByLatestSellNumResponse;
import com.meila.soa.product.api.model.response.DubboQuerySpuResponse;
import com.meila.soa.product.api.model.response.DubboSyncInventoryResponse;
import com.meila.soa.product.api.model.response.DubboSyncProductResponse;
import com.meila.soa.product.api.model.response.inventory.DubboWmsInvNotifyResponse;
import com.meila.soa.product.dal.entity.product.Product;
import com.meila.soa.product.dal.mybatis.IdTypeHandler;
import com.meila.soa.product.dal.type.DeliveryType;
import com.meila.soa.product.dal.type.ProductStatus;
import com.meila.soa.product.dal.type.StorageType;

import junit.framework.TestCase;

/**
 ************************************************************
 * @类名 : TestDubboOrderService.java
 *
 * @DESCRIPTION : 单元测试
 * @AUTHOR : hawk
 * @DATE : 2016年1月19日
 ************************************************************
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 本地单元测试
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
// 真实服务器测试
// @ContextConfiguration(locations = { "classpath:dubbo-consumer-3.0.0.xml" })
// @ContextConfiguration(locations = { "classpath:dubbo-consumer-1.0.0.xml" })
public class DubboServiceBatchTest extends TestCase {
    @Resource
    private DubboProductService dubboProductService;
    @Resource
    private DubboCartService dubboCartService;

    @Resource
    private DubboShopService dubboShopService;

    @Resource
    private DubboFragmentService dubboFragmentService;

    @Test
    public void testSyncErpSku() {
        DubboSyncProductRequest req = new DubboSyncProductRequest();
        List<DubboProductSku> productSkuList = new ArrayList<DubboProductSku>();

        for (int i = 0; i < 40; i++) {
            DubboProductSku temp = new DubboProductSku();
            temp.setBelongAccount("123");
            temp.setBrandNameCn("brandNameCn");
            temp.setBrandNameEn("brandNameEn");
            temp.setCategoryCode("化妆品");
            temp.setErpSkuCode("erpcode" + i);
            temp.setErpSkuId("erpskuid" + i);
            temp.setWmsSyncTime(new Date());
            temp.setProductionPlace("深圳");
            temp.setPurchasePlace("日本");
            BigDecimal t = new BigDecimal(10.0);
            temp.setSalePrice(t);
            temp.setSkuBarCode("skubarcode" + i);
            temp.setSkuId(11L);
            temp.setSkuNameCn("中文" + i);
            temp.setSkuNameEn("英文名字" + i);
            temp.setSpec1Name("spec1name" + i);
            temp.setSpec1Value("spec1value" + i);
            temp.setSpec2Name("spec2name" + i);
            temp.setSpec2Value("spec2value" + i);

            temp.setSpec3Name("spec3name" + i);
            temp.setSpec3Value("spec3value" + i);

            temp.setSpec4Name("spec4name" + i);
            temp.setSpec4Value("spec4value" + i);
            temp.setSpec5Name("spec5name" + i);
            temp.setSpec5Value("spec5value" + i);

            temp.setUnitName("单元名称");
            temp.setWarehouseCode("warehousecode" + i);
            temp.setWmsRemark("remark");
            temp.setWmsStatus("失效");
            temp.setWmsSyncTime(new Date());
            temp.setErpSyncTime(new Date());

            // 0：有效 1：无效
            temp.setArchive(0);
            productSkuList.add(temp);
        }

        req.setProductSkuList(productSkuList);
        DubboSyncProductResponse dubboResp = dubboProductService.syncErpSku(req);
        Assert.assertEquals(DubboReturnCode.SUCCESS, dubboResp.getCode());
    }

    @Test
    public void testSyncCategory() {
        DubboSyncCategoryRequest req = new DubboSyncCategoryRequest();
        List<DubboCategory> categoryList = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            DubboCategory temp = new DubboCategory();
            temp.setCategoryCode("code" + i);
            temp.setCategoryName("name" + i);
            temp.setParentCode("code" + (i - 1));
            categoryList.add(temp);
        }

        DubboCategory temp = new DubboCategory();

        temp.setCategoryName("name");
        temp.setParentCode("code");
        categoryList.add(temp);

        req.setCategoryList(categoryList);
        dubboProductService.syncCategory(req);
    }

    @Test
    public void testSyncInventory() {
        DubboSyncInventoryRequest req = new DubboSyncInventoryRequest();
        List<DubboInventory> inventoryList = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            DubboInventory temp = new DubboInventory();
            temp.setWarehouse("warehouse" + i);
            temp.setArchive(true);
            temp.setBatchNo("12341");
            temp.setErpSkuId("erpskuid" + i);
            temp.setRealAmount(100);
            inventoryList.add(temp);
        }
        DubboInventory temp = new DubboInventory();
        temp.setWarehouse("warehouse");
        temp.setArchive(true);
        temp.setBatchNo("12341");
        temp.setRealAmount(100);
        inventoryList.add(temp);

        req.setInventoryList(inventoryList);
        DubboSyncInventoryResponse dubboResp = dubboProductService.syncInventory(req);

    }

    // 查询所有
    @Test
    public void testQueryErpSku() {
        DubboQueryErpSkuListRequest req = new DubboQueryErpSkuListRequest();
        req.setErpSkuId("ERP_100001");
        DubboQueryErpSkuListResponse dubboResp = dubboProductService.queryErpSkuList(req);
        System.out.println(JSON.toJSONString(dubboResp));
        Assert.assertEquals(DubboReturnCode.SUCCESS, dubboResp.getCode());
    }

    // 根据skuNameCn进行模糊匹配
    @Test
    public void testQueryErpSku1() {
        DubboQueryErpSkuListRequest req = new DubboQueryErpSkuListRequest();
        req.setSkuNameCn("ERP");
        DubboQueryErpSkuListResponse dubboResp = dubboProductService.queryErpSkuList(req);
        Assert.assertEquals(DubboReturnCode.SUCCESS, dubboResp.getCode());
    }

    @Test
    public void testQuerySpuById() {
        DubboQuerySpuByIdRequest req = new DubboQuerySpuByIdRequest();
        List<Long> productIdList = new ArrayList<>();
        productIdList.add(1L);
        productIdList.add(2L);
        productIdList.add(3L);
        productIdList.add(4L);
        productIdList.add(5L);
        req.setProductIdList(productIdList);
        DubboQuerySpuResponse dubboResp = dubboProductService.querySpuById(req);
        Assert.assertEquals(DubboReturnCode.SUCCESS, dubboResp.getCode());
    }

    @Test
    public void testQuerySpuById1() {
        DubboQuerySpuByIdRequest req = new DubboQuerySpuByIdRequest();
        Long[] ids = new Long[] { 10394L, 10395L };

        List<Long> productIdList = new ArrayList<>();
        productIdList.addAll(Arrays.asList(ids));
        req.setProductIdList(productIdList);
        DubboQuerySpuResponse dubboResp = dubboProductService.querySpuById(req);
        Assert.assertEquals(DubboReturnCode.SUCCESS, dubboResp.getCode());
    }

    @Test
    public void testQuerySpuById2() {
        DubboQuerySpuByIdRequest req = new DubboQuerySpuByIdRequest();
        List<Long> productIdList = new ArrayList<>();
        productIdList.add(10173L);
        productIdList.add(10172L);
        productIdList.add(10002L);
        productIdList.add(600L);
        productIdList.add(460L);
        req.setProductIdList(productIdList);
        DubboQuerySpuResponse dubboResp = dubboProductService.querySpuById(req);
        Assert.assertEquals(DubboReturnCode.SUCCESS, dubboResp.getCode());
    }

    @Test
    public void testQuerySpuById3() {
        DubboQuerySpuByIdRequest req = new DubboQuerySpuByIdRequest();
        Long[] ids = new Long[] { 224L, 2817L, 1826L, 259L, 2340L, 3798L, 199L, 3242L, 1805L, 2767L, 2352L, 2769L, 2355L, 404L, 405L, 1782L, 1977L,
                2777L, 1755L, 1821L };

        List<Long> productIdList = new ArrayList<>();
        productIdList.addAll(Arrays.asList(ids));
        req.setProductIdList(productIdList);
        DubboQuerySpuResponse dubboResp = dubboProductService.querySpuById(req);
        Assert.assertEquals(DubboReturnCode.SUCCESS, dubboResp.getCode());
    }

    @Test
    public void testQuerySpuById4() {

        while (true) {
            try {
                for (Long i = 0L; i < 1000L; i++) {
                    DubboQuerySpuByIdRequest req = new DubboQuerySpuByIdRequest();
                    req.setTid(UUID.randomUUID().toString().replace("_", ""));
                    List<Long> productIdList = new ArrayList<>();
                    for (Long j = 1L; j <= 50L; j++) {
                        productIdList.add(50 * i + j);
                    }
                    req.setProductIdList(productIdList);
                    DubboQuerySpuResponse dubboResp = dubboProductService.querySpuById(req);
                    System.out.println(i);
                    Assert.assertEquals(DubboReturnCode.SUCCESS, dubboResp.getCode());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testQuerySpuById5() {
        DubboQuerySpuByIdRequest req = new DubboQuerySpuByIdRequest();
        List<Long> productIdList = new ArrayList<>();
        productIdList.add(10397L);
        req.setProductIdList(productIdList);
        DubboQuerySpuResponse dubboResp = dubboProductService.querySpuById(req);
        Assert.assertEquals(DubboReturnCode.SUCCESS, dubboResp.getCode());
    }

    @Test
    public void testQuerySpuById6() {
        DubboQuerySpuByIdRequest req = new DubboQuerySpuByIdRequest();
        Long[] ids = new Long[] { 2101L, 2102L, 2103L, 2104L, 2105L, 2106L, 2107L, 2108L, 2109L, 2110L, 2111L, 2112L, 2113L, 2114L, 2115L, 2116L,
                2117L, 2118L, 2119L, 2120L, 2121L, 2122L, 2123L, 2124L, 2125L, 2126L, 2127L, 2128L, 2129L, 2130L };

        List<Long> productIdList = new ArrayList<>();
        productIdList.addAll(Arrays.asList(ids));
        req.setProductIdList(productIdList);
        DubboQuerySpuResponse dubboResp = dubboProductService.querySpuById(req);
        Assert.assertEquals(DubboReturnCode.SUCCESS, dubboResp.getCode());
    }

    @Test
    public void testQuerySpuById7() {
        DubboQuerySpuByIdRequest req = new DubboQuerySpuByIdRequest();
        List<Long> productIdList = new ArrayList<>();
        productIdList.add(2195L);
        req.setProductIdList(productIdList);
        DubboQuerySpuResponse dubboResp = dubboProductService.querySpuBaseInfoById(req);
        Assert.assertEquals(DubboReturnCode.SUCCESS, dubboResp.getCode());
    }

    @Test
    public void testQuerySpuByCode() {
        DubboQuerySpuByCodeRequest req = new DubboQuerySpuByCodeRequest();
        List<String> codeList = new ArrayList<>();
        codeList.add("3lu0");
        // codeList.add("09b97b01");
        // codeList.add("ba7c3e5e");
        req.setCodeList(codeList);
        DubboQuerySpuResponse dubboResp = dubboProductService.querySpuByCode(req);
        Assert.assertEquals(DubboReturnCode.SUCCESS, dubboResp.getCode());
    }

    @Test
    public void testQueryCategory() {
        DubboQueryCategoryRequest req = new DubboQueryCategoryRequest();
        // req.setCategoryId(10L);
        DubboQueryCategoryResponse dubboResp = dubboProductService.queryCategory(req);
        Assert.assertEquals(DubboReturnCode.SUCCESS, dubboResp.getCode());
    }

    @Test
    public void testAddToCart() {
        {
            DubboAddToCartRequest req = new DubboAddToCartRequest();
            req.setAmount(33);
            req.setCartType(0);
            req.setSkuId(10L);
            req.setUserId(9988L);
            req.setFromSource("1111");
            DubboBasicResponse dubboResp = dubboCartService.addToCart(req);
            System.out.println(dubboResp);
            Assert.assertEquals(DubboReturnCode.SUCCESS, dubboResp.getCode());
        }
        {
            DubboAddToCartRequest req = new DubboAddToCartRequest();
            req.setAmount(10);
            req.setCartType(1);
            req.setSkuId(9L);
            req.setUserId(9988L);
            DubboBasicResponse dubboResp = dubboCartService.addToCart(req);
            System.out.println(dubboResp);
            Assert.assertEquals(DubboReturnCode.SUCCESS, dubboResp.getCode());
        }
        {
            DubboAddToCartRequest req = new DubboAddToCartRequest();
            req.setAmount(10);
            req.setCartType(2);
            req.setSkuId(9L);
            req.setUserId(9988L);
            DubboBasicResponse dubboResp = dubboCartService.addToCart(req);
            System.out.println(dubboResp);
            Assert.assertEquals(DubboReturnCode.SUCCESS, dubboResp.getCode());
        }
    }

    @Test
    public void testAddToCartByCode()
    // 添加到普通购物车
    {
        DubboAddToCartBySkuCodRequest req = new DubboAddToCartBySkuCodRequest();
        req.setAmount(10);
        req.setCartType(0);
        req.setSkuCode("bf115fb8");
        req.setUserId(9988L);
        DubboBasicResponse dubboResp = dubboCartService.addToCartBySkuCode(req);
        System.out.println(dubboResp);
        Assert.assertEquals(DubboReturnCode.SUCCESS, dubboResp.getCode());
    }

    // 添加到秒杀购物车
    @Test
    public void testAddToCartByCode1() {
        DubboAddToCartBySkuCodRequest req = new DubboAddToCartBySkuCodRequest();
        req.setAmount(10);
        req.setCartType(1);
        req.setSkuCode("bf115fb8");
        req.setUserId(9988L);
        DubboBasicResponse dubboResp = dubboCartService.addToCartBySkuCode(req);
        System.out.println(dubboResp);
        Assert.assertEquals(DubboReturnCode.SUCCESS, dubboResp.getCode());
    }

    // 添加到立即购买购物车
    @Test
    public void testAddToCartByCode2() {
        DubboAddToCartBySkuCodRequest req = new DubboAddToCartBySkuCodRequest();
        req.setAmount(10);
        req.setCartType(2);
        req.setSkuCode("bf115fb8");
        req.setUserId(9988L);
        DubboBasicResponse dubboResp = dubboCartService.addToCartBySkuCode(req);
        System.out.println(dubboResp);
        Assert.assertEquals(DubboReturnCode.SUCCESS, dubboResp.getCode());
    }

    // 添加到购物车，skucode不存在
    @Test
    public void testAddToCartByCode3() {
        DubboAddToCartBySkuCodRequest req = new DubboAddToCartBySkuCodRequest();
        req.setAmount(10);
        req.setCartType(2);
        req.setSkuCode("aaaaaaaa");
        req.setUserId(9988L);
        DubboBasicResponse dubboResp = dubboCartService.addToCartBySkuCode(req);
        System.out.println(dubboResp);
        Assert.assertEquals(ProductReturnCode.SKU_NOT_EXIST, dubboResp.getCode());
    }

    // 添加到购物车，skucode不存在
    @Test
    public void testAddToCartByCode4() {
        DubboAddToCartBySkuCodRequest req = new DubboAddToCartBySkuCodRequest();
        req.setAmount(10);
        req.setCartType(2);
        req.setSkuCode("bf115fb8");
        req.setUserId(911988L);
        DubboBasicResponse dubboResp = dubboCartService.addToCartBySkuCode(req);
        System.out.println(dubboResp);
        Assert.assertEquals(ProductReturnCode.USER_NOT_EXIST, dubboResp.getCode());
    }

    @Test
    public void testQueryCachedInv() {
        DubboQueryCachedInvRequest req = new DubboQueryCachedInvRequest();
        req.setSellerId(10L);
        req.setProductName("111");
        DubboBasicResponse dubboResp = dubboProductService.queryCachedInv(req);
        System.out.println(dubboResp);
    }

    @Test
    public void testBeanMapper() {
        for (int i = 0; i < 10; i++) {
            DubboSearchSpuListRequest temp = new DubboSearchSpuListRequest();
            temp.setProductName(System.currentTimeMillis() + "1111" + i);
            temp.setCurrentPage((long) (10 * i));
            temp.setOnSaleAtBegin("123412341324" + i);
            long start = System.currentTimeMillis();
            Product map = BeanMapper.map(temp, Product.class);
            System.out.println(System.currentTimeMillis() - start);
        }

    }

    @Test
    public void testAddSkuBundle() {
        DubboAddSkuBundleRequest req = new DubboAddSkuBundleRequest();
        req.setProductId(1L);
        List<DubboSkuBundle> dubboSkuBundleList = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            DubboSkuBundle temp = new DubboSkuBundle();
            temp.setAmount(1);
            temp.setIsDisplay("SHOW");
            temp.setPrice(new BigDecimal("10.0"));
            temp.setSkuBundleId(10L);
            temp.setSkuBundleName("我的套餐");
            List<DubboSkuBundleInfo> skuBundleInfoList = new ArrayList<>();
            temp.setSkuBundleInfoList(skuBundleInfoList);

            DubboSkuBundleInfo temp1 = new DubboSkuBundleInfo();
            temp1.setArchive(false);
            temp1.setClearancePrice(new BigDecimal("10.0"));
            temp1.setMatchCount(10);
            temp1.setSkuBundleId(10L);
            temp1.setSubSkuId(1L);
            skuBundleInfoList.add(temp1);

            DubboSkuBundleInfo temp2 = new DubboSkuBundleInfo();
            temp2.setArchive(false);
            temp2.setClearancePrice(new BigDecimal("10.0"));
            temp2.setMatchCount(10);
            temp2.setSkuBundleId(10L);
            temp2.setSubSkuId(1L);
            skuBundleInfoList.add(temp2);

            dubboSkuBundleList.add(temp);
        }

        req.setDubboSkuBundleList(dubboSkuBundleList);

        DubboBasicResponse dubboResp = dubboProductService.addSkuBundle(req);
        Assert.assertEquals(ProductReturnCode.SUCCESS, dubboResp.getCode());
    }

    @Test
    public void testAddShop() {
        DubboAddShopRequest req = new DubboAddShopRequest();
        req.setExtUserId("100065");
        req.setSellerSource("OUTSIDE");

        DubboBasicResponse dubboResp = dubboShopService.addShop(req);
        Assert.assertEquals(ProductReturnCode.SUCCESS, dubboResp.getCode());
    }

    @Test
    public void testQueryShop() {

        DubboQueryShopRequest req = new DubboQueryShopRequest();
        req.setShopId(1L);
        DubboBasicResponse dubboResp = dubboShopService.queryShop(req);
        Assert.assertEquals(ProductReturnCode.SUCCESS, dubboResp.getCode());
    }

    @Test
    public void testQuerySpu() {
        DubboQuerySpuListRequest req = new DubboQuerySpuListRequest();
        req.setStatus("FORSALE");
        req.setProductId(1L);
        req.setCurrentPage(1L);
        req.setPageSize(2L);
        DubboBasicResponse dubboResp = dubboProductService.querySpu(req);
        Assert.assertEquals(ProductReturnCode.SUCCESS, dubboResp.getCode());
    }

    @Test
    public void testSearchSpu() {
        DubboSearchSpuListRequest req = new DubboSearchSpuListRequest();
        req.setProductName("呵呵");
        req.setPageSize(10L);
        req.setCurrentPage(10L);
        DubboBasicResponse dubboResp = dubboProductService.searchSpu(req);
        Assert.assertEquals(ProductReturnCode.SUCCESS, dubboResp.getCode());
    }

    @Test
    public void testQueryFragment() {
        DubboQueryFragmentRequest req = new DubboQueryFragmentRequest();
        req.setFragmentId(10L);
        DubboQueryFragmentResponse dubboResp = dubboFragmentService.queryFragment(req);
        Assert.assertEquals(ProductReturnCode.SUCCESS, dubboResp.getCode());
    }

    @Test
    public void testAddFragment() {
        DubboAddFragmentRequest req = new DubboAddFragmentRequest();
        req.setShowModel(true);
        req.setShopId(10L);
        req.setName("1111" + System.currentTimeMillis());
        List<DubboFragmentImage> fragmentImageList = new ArrayList<>();
        req.setFragmentImageList(fragmentImageList);
        for (int i = 0; i < 2; i++) {
            DubboFragmentImage img = new DubboFragmentImage();
            img.setImg("/1234132" + i + System.currentTimeMillis());
            img.setImgHeight(50);
            img.setImgHeight(50);
            img.setIdx(1);
            fragmentImageList.add(img);
        }

        DubboAddFragmentResponse dubboResp = dubboFragmentService.addFragment(req);
        Assert.assertEquals(ProductReturnCode.SUCCESS, dubboResp.getCode());
    }

    @Test
    public void testAddProductFragmentInfo() {
        DubboAddProductFragmentInfoRequest req = new DubboAddProductFragmentInfoRequest();
        req.setProductId(100L);
        req.setShopId(6L);
        List<Long> fragmentIdList = new ArrayList<>();

        fragmentIdList.add(90327L);
        fragmentIdList.add(90326L);
        fragmentIdList.add(90325L);

        req.setFragmentIdList(fragmentIdList);
        DubboBasicResponse dubboResp = dubboFragmentService.addProductFragmentInfo(req);
        Assert.assertEquals(ProductReturnCode.SUCCESS, dubboResp.getCode());
    }

    @Test
    public void testCronQueryInvShort() {
        for (int i = 35;; i++) {
            DubboCronInvRequest req = new DubboCronInvRequest();
            req.setPageSize(1L);
            req.setCurrentPage((long) i);
            DubboCronInvResponse dubboResp = dubboProductService.cronQueryInvShort(req);
            if (!dubboResp.getContinueFlag()) {
                break;
            }
            System.out.println(i);
            Assert.assertEquals(ProductReturnCode.SUCCESS, dubboResp.getCode());
        }
    }

    @Test
    public void testSubList() {
        while (true) {
            List<Long> longList = new ArrayList<>();
            longList.add(1L);
            longList.add(2L);
            longList.add(3L);
            longList.add(4L);
            longList.add(5L);
            longList.add(6L);
            longList.add(7L);

            List<Long> subList = longList.subList(0, 1);

            subList = longList.subList(1, 2);
            System.out.println();
        }
    }

    @Test
    public void testInvNotify() {

        DubboWmsInvNotifyRequest req = new DubboWmsInvNotifyRequest();
        List<DubboInvNotify> invNotifyList = Lists.newArrayList();
        for (int i = 0; i < 2; i++) {
            DubboInvNotify temp = new DubboInvNotify();
            temp.setChangeNum(-2);
            temp.setSkuId("1");
            temp.setType(SkuInvChangeType.CM);
            temp.setTransactionId("transactionid1" + i);
            temp.setCreateTime(new Date(System.currentTimeMillis()));
            invNotifyList.add(temp);
        }

        for (int i = 0; i < 2; i++) {
            DubboInvNotify temp = new DubboInvNotify();
            temp.setChangeNum(3);
            temp.setSkuId("1|2");
            temp.setType(SkuInvChangeType.TR);
            temp.setTransactionId("transactionid2" + i);
            temp.setCreateTime(new Date(System.currentTimeMillis()));
            invNotifyList.add(temp);
        }

        req.setInvNotifyList(invNotifyList);
        DubboWmsInvNotifyResponse dubboResp = dubboProductService.invNotify(req);
        Assert.assertEquals(ProductReturnCode.SUCCESS, dubboResp.getCode());
    }

    @Test
    public void testBatchInstock() {
        DubboBatchInstockRequest req = new DubboBatchInstockRequest();
        List<Long> idList = Lists.newArrayList();
        idList.add(1L);
        idList.add(3L);
        req.setIdList(idList);
        req.setUserId(1359374L);
        DubboBatchInstockResponse dubboResp = dubboProductService.batchInstock(req);
        Assert.assertEquals(ProductReturnCode.SUCCESS, dubboResp.getCode());
    }

    @Test
    public void testBatchOnsale() {
        DubboBatchOnsaleRequest req = new DubboBatchOnsaleRequest();
        List<Long> idList = Lists.newArrayList();
        idList.add(1L);
        idList.add(3L);
        req.setIdList(idList);
        req.setUserId(1359374L);
        DubboBatchOnsaleResponse dubboResp = dubboProductService.batchOnsale(req);
        Assert.assertEquals(ProductReturnCode.SUCCESS, dubboResp.getCode());
    }

    @Test
    public void testListProductOfShop() {
        DubboListProductOfShopRequest req = new DubboListProductOfShopRequest();
        req.setShopId(1L);
        List<DubboSort> sortList = Lists.newArrayList();
        DubboSort sort = new DubboSort();
        sort.setProperty("sales");
        sort.setDirection("ASC");
        sortList.add(sort);
        req.setSortList(sortList);
        DubboListProductOfShopResponse dubboResp = dubboProductService.listProductOfShop(req);
        Assert.assertEquals(ProductReturnCode.SUCCESS, dubboResp.getCode());
    }

    @Test
    public void testListProductOfShop2() {
        DubboListProductOfShopRequest req = new DubboListProductOfShopRequest();
        req.setShopId(1L);
        List<DubboSort> sortList = Lists.newArrayList();
        DubboSort sort = new DubboSort();
        sort.setProperty("amount");
        sort.setDirection("ASC");
        sortList.add(sort);
        req.setSortList(sortList);
        DubboListProductOfShopResponse dubboResp = dubboProductService.listProductOfShop(req);
        Assert.assertEquals(ProductReturnCode.SUCCESS, dubboResp.getCode());
    }

    @Test
    public void testListProductOfShop3() {
        DubboListProductOfShopRequest req = new DubboListProductOfShopRequest();
        req.setShopId(1L);
        List<DubboSort> sortList = Lists.newArrayList();
        DubboSort sort = new DubboSort();
        sort.setProperty("soldout");
        sort.setDirection("ASC");
        sortList.add(sort);
        req.setSortList(sortList);
        DubboListProductOfShopResponse dubboResp = dubboProductService.listProductOfShop(req);
        Assert.assertEquals(ProductReturnCode.SUCCESS, dubboResp.getCode());
    }

    @Test
    public void testListProductOfShop4() {
        DubboListProductOfShopRequest req = new DubboListProductOfShopRequest();
        req.setShopId(1L);
        List<DubboSort> sortList = Lists.newArrayList();
        DubboSort sort = new DubboSort();
        sort.setProperty("statusDraft");
        sort.setDirection("ASC");
        sortList.add(sort);
        req.setSortList(sortList);
        DubboListProductOfShopResponse dubboResp = dubboProductService.listProductOfShop(req);
        Assert.assertEquals(ProductReturnCode.SUCCESS, dubboResp.getCode());
    }

    @Test
    public void testListProductOfShop5() {
        DubboListProductOfShopRequest req = new DubboListProductOfShopRequest();
        req.setShopId(1L);
        List<DubboSort> sortList = Lists.newArrayList();
        DubboSort sort = new DubboSort();
        sort.setProperty("outofstock");
        sort.setDirection("ASC");
        sortList.add(sort);
        req.setSortList(sortList);
        DubboListProductOfShopResponse dubboResp = dubboProductService.listProductOfShop(req);
        Assert.assertEquals(ProductReturnCode.SUCCESS, dubboResp.getCode());
    }

    @Test
    public void testListProductOfShop6() {
        DubboListProductOfShopRequest req = new DubboListProductOfShopRequest();
        req.setShopId(1L);
        List<DubboSort> sortList = Lists.newArrayList();
        DubboSort sort = new DubboSort();
        sort.setProperty("postage");
        sort.setDirection("ASC");
        sortList.add(sort);
        req.setSortList(sortList);
        DubboListProductOfShopResponse dubboResp = dubboProductService.listProductOfShop(req);
        Assert.assertEquals(ProductReturnCode.SUCCESS, dubboResp.getCode());

    }

    @Test
    public void testQueryProductByLatestSellNum() {
        DubboQueryProductByLatestSellNumRequest req = new DubboQueryProductByLatestSellNumRequest();
        req.setSellerId(1134122L);
        req.setPageSize(4L);
        req.setCurrentPage(1L);
        DubboQueryProductByLatestSellNumResponse dubboResp = dubboProductService.queryProductByLatestSellNum(req);
        Assert.assertEquals(ProductReturnCode.SUCCESS, dubboResp.getCode());
    }

    @Test
    public void testCronStatisticProductInv() {
        for (int i = 1;; i++) {
            try {
                DubboCronInvRequest req = new DubboCronInvRequest();
                req.setPageSize(2L);
                req.setCurrentPage((long) i);
                DubboCronInvResponse dubboResp = dubboProductService.cronStatisticProductSellNum(req);
                if (!dubboResp.getContinueFlag()) {
                    break;
                }
                Assert.assertEquals(ProductReturnCode.SUCCESS, dubboResp.getCode());
            } catch (Exception e) {

            }
        }
    }

    @Test
    public void testCronStatisticProductInv1() {
        List<Integer> idList = Lists.newArrayList(56449, 56461, 56462, 56463, 56476, 56477, 56478, 56499, 56812, 56817, 56912, 56968, 56981, 56983,
            57058, 57086, 57100, 57151, 57214, 57231, 57367, 57395, 57422, 57425, 57428, 57484, 57539, 57637, 57639, 57688, 57689, 57690, 57739,
            57787, 57788, 57829, 57846, 57851, 57852, 57853, 57854, 57857, 57862, 57871, 57952, 58022, 58024, 58026, 58027, 58029, 58043, 58045,
            58054, 58086, 58088, 58110, 58123, 58124, 58127, 58132, 58135, 58141, 58297, 58361, 58363, 58364, 58368, 58369, 58371, 58374, 58377,
            58424, 58425, 58428, 58429, 58436, 58514, 58533, 58534, 58535, 58536);

        for (Integer temp : idList) {
            System.out.println("UPDATE vdlm_sku SET `code`='" + IdTypeHandler.encode(temp) + "'" + " WHERE id =" + temp);
        }
    }
}
