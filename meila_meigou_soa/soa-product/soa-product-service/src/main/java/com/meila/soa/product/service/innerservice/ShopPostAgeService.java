package com.meila.soa.product.service.innerservice;

import com.meila.soa.product.service.model.ShopPostAge;

public interface ShopPostAgeService {

    ShopPostAge getPostAgeByShop(Long shopId);

    Boolean setPostAgeByShop(ShopPostAge shopPostAge);

}
