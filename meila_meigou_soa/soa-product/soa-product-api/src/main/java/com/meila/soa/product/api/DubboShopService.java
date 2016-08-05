package com.meila.soa.product.api;

import com.meila.dubbo.base.model.DubboBasicResponse;
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

public interface DubboShopService {

    /**
     * 功能描述：添加店铺信息
     * 
     * @param req
     * @return DubboBasicResponse
     *
     */
    DubboBasicResponse addShop(DubboAddShopRequest req);

    DubboBasicResponse updateShop(DubboUpdateShopRequest req);

    /**
     * 
     * 功能描述：更新店铺扩展信息
     * 
     * @param req
     * @return DubboBasicResponse
     *
     */
    DubboBasicResponse updateShopExt(DubboUpdateShopExtRequest req);

    /**
     * 功能描述：查询店铺信息
     * 
     * @param req
     * @return DubboQueryShopResponse
     *
     */
    DubboQueryShopResponse queryShop(DubboQueryShopRequest req);

    /**
     * 
     * 功能描述：根据卖家ID查询商铺信息
     * 
     * @param req
     * @return DubboQueryShopResponse
     *
     */
    DubboQueryShopResponse queryShopWithExtByOwnerId(DubboQueryShopByOwnerIdListRequest req);

    /**
     * 
     * 功能描述：搜索店铺信息
     * 
     * @param req
     * @return DubboSearchShopResponse
     *
     */
    DubboSearchShopResponse searchShop(DubboSearchShopRequest req);

    /**
     * 统计店铺信息 功能描述：
     * 
     * @param req
     * @return DubboStatisticsShopInfoResponse
     *
     */
    DubboStatisticsShopInfoResponse statisticsShopInfo(DubboStatisticsShopInfoRequest req);
}
