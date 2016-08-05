package com.meila.soa.product.service.innerservice.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.meila.soa.product.dal.dao.shop.PostAgeSetMapper;
import com.meila.soa.product.dal.dao.shop.ShopMapper;
import com.meila.soa.product.dal.dao.zone.ZoneMapper;
import com.meila.soa.product.dal.entity.PostAgeSet;
import com.meila.soa.product.dal.entity.PostConf;
import com.meila.soa.product.dal.entity.Zone;
import com.meila.soa.product.dal.entity.shop.Shop;
import com.meila.soa.product.service.innerservice.ShopPostAgeService;
import com.meila.soa.product.service.innerservice.ShopService;
import com.meila.soa.product.service.model.AreaPair;
import com.meila.soa.product.service.model.AreaPostagePair;
import com.meila.soa.product.service.model.ShopPostAge;

@Service
public class ShopPostAgeServiceImpl implements ShopPostAgeService {

    @Autowired
    private PostAgeSetMapper postAgeSetMapper;

    @Autowired
    private ShopService shopService;

    @Autowired
    private ShopMapper shopMapper;

    @Autowired
    private ZoneMapper zoneMapper;

    @Override
    public ShopPostAge getPostAgeByShop(Long shopId) {
        if (shopId == null)
            return null;

        List<PostAgeSet> list = postAgeSetMapper.selectByShopId(shopId);
        if (list != null && list.size() != 0) { // 新的邮费设置, 从最近更新开始找到一个能正确解析的记录
            for (PostAgeSet pas : list) {
                ShopPostAge spa = resolvePostAge(pas);
                if (spa != null) {
                    return spa;
                } else {
                    // TODO: 不能正确解析该记录, 可能需要删除该记录?
                }
            }
        }
        // 否则使用老的设置
        return getOrigPostSet(shopId);
    }

    // 如果将来清除shop表中邮费字段, 这里相关代码也需删除
    private ShopPostAge getOrigPostSet(Long shopId) {
        ShopPostAge ret = new ShopPostAge();
        ret.setShopId(shopId);
        ret.setPostage(new BigDecimal("0"));
        ret.setPostageStatus(false);
        Shop shop = shopService.load(shopId);
        if (shop != null) {
            ret.setPostageStatus(shop.getPostageStatus());
            ret.setPostage(shop.getPostage());
            ret.setCustomizedPostage(generateCstmPostAge(shop));
        }
        return ret;
    }

    // 如果将来清除shop表中邮费字段, 这里相关代码也需删除
    private List<AreaPostagePair> generateCstmPostAge(Shop shop) {
        List<AreaPostagePair> ret = new ArrayList<AreaPostagePair>();
        AreaPostagePair pair = new AreaPostagePair();
        pair.setPoatage(new BigDecimal("0")); // 因为老版邮费只有包邮, 转为自定义邮费的0元区域

        List<AreaPair> aps = new ArrayList<AreaPair>();
        List<PostConf> list = zoneMapper.findPostArea(shop.getFreeZone());
        if (list != null && list.size() != 0) {
            for (PostConf pc : list) {
                Zone zone = zoneMapper.selectByPrimaryKey(pc.getAssociateId());
                if (zone == null)
                    continue;
                AreaPair ap = new AreaPair(zone.getId(), zone.getName());
                aps.add(ap);
            }
        } else {
            return null;
        }
        pair.setAreas(aps);
        ret.add(pair);
        return ret;
    }

    private ShopPostAge resolvePostAge(PostAgeSet postAgeSet) {
        if (postAgeSet == null || postAgeSet.getShopId() == null)
            return null;
        ShopPostAge ret = new ShopPostAge();
        String jsonStr = postAgeSet.getPostageSet();
        JSONObject object = JSONObject.parseObject(jsonStr);
        try {
            ret = object.parseObject(jsonStr, ShopPostAge.class);
        } catch (Exception e) {
            // logger.warn("postageset string can not resolve...");
            ret = null;
            // TODO: handle exception
        }
        if (ret != null && ret.getCustomizedPostage() != null && ret.getCustomizedPostage().size() != 0
                && ret.getCustomizedPostage().get(0).getAreas() == null) {
            ret.setCustomizedPostage(null);
        }
        return ret;
    }

    private List<AreaPostagePair> getCustomizedPostage(List<AreaPostagePair> list) {
        if (list == null)
            return null;

        if (list.size() != 0 && (list.get(0).getAreas() == null || list.get(0).getAreas().size() == 0)) {
            return null;
        } else {
            return list;
        }
    }

    @Override
    public Boolean setPostAgeByShop(ShopPostAge shopPostAge) {
        if (shopPostAge == null)
            return false;
        ShopPostAge spa = this.getPostAgeByShop(shopPostAge.getShopId());

        spa.setPostageStatus(shopPostAge.getPostageStatus());
        if (shopPostAge.getPostageStatus() != null && shopPostAge.getPostageStatus()) {
            if (shopPostAge.getPostage() != null) { // 可以设置0
                spa.setPostage(shopPostAge.getPostage());
            }
            if (shopPostAge.getFreeShippingPrice() != null) {
                if (shopPostAge.getFreeShippingPrice().compareTo(new BigDecimal("-1")) == 0) {
                    spa.setFreeShippingPrice(null);
                } else {
                    spa.setFreeShippingPrice(shopPostAge.getFreeShippingPrice());
                }
            }
            if (shopPostAge.getFreeShippingGoods() != null) {
                if (shopPostAge.getFreeShippingGoods().size() == 0
                        || (shopPostAge.getFreeShippingGoods().size() == 1 && shopPostAge.getFreeShippingGoods().get(0).equals("delete"))) { // delete
                    spa.setFreeShippingGoods(null);
                } else {
                    spa.setFreeShippingGoods(shopPostAge.getFreeShippingGoods());
                }
            }
            if (shopPostAge.getCustomizedPostage() != null) {
                spa.setCustomizedPostage(getCustomizedPostage(shopPostAge.getCustomizedPostage()));
            }
        } else {
            spa.setPostageStatus(false);
        }
        String jsonStr = JSONObject.toJSONString(spa);
        PostAgeSet pas = new PostAgeSet();
        pas.setShopId(shopPostAge.getShopId());
        pas.setPostageSet(jsonStr);
        postAgeSetMapper.insert(pas);
        List<PostAgeSet> list = postAgeSetMapper.selectByShopId(shopPostAge.getShopId());
        if (list != null && list.size() > 3) { // TODO: 暂时写死
            for (int i = 3; i < list.size(); i++) {
                postAgeSetMapper.deleteByPrimaryKey(list.get(i).getId());
            }
        }
        if (shopPostAge.getPostage() != null) {
            Shop shop = shopService.load(shopPostAge.getShopId());
            shop.setPostageStatus(shopPostAge.getPostageStatus()); // 不能一直维护老数据, 需要想办法去掉依赖
            shop.setPostage(shopPostAge.getPostage());
            shopMapper.updateByPrimaryKeySelective(shop);
        }
        return true;
    }

}
