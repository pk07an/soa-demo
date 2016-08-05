package com.meila.soa.order.service.dubboservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.meila.common.bean.utils.BeanMapper;
import com.meila.common.collection.utils.Collections3;
import com.meila.dubbo.base.constant.DubboReturnCode;
import com.meila.soa.meila.client.OmsClient;
import com.meila.soa.meila.client.dto.OrderAddressDto;
import com.meila.soa.order.api.DubboOrderAddressService;
import com.meila.soa.order.api.model.dto.DubboAddressZone;
import com.meila.soa.order.api.model.dto.DubboOrderAddressInfo;
import com.meila.soa.order.api.model.request.DubboQueryOrderAddressAllZoneListRequest;
import com.meila.soa.order.api.model.request.DubboQueryOrderAddressInfoByOrderIdRequest;
import com.meila.soa.order.api.model.request.DubboUpdateAddressRequest;
import com.meila.soa.order.api.model.response.DubboQueryOrderAddressAllZoneListResponse;
import com.meila.soa.order.api.model.response.DubboQueryOrderAddressInfoByOrderIdResponse;
import com.meila.soa.order.api.model.response.DubboUpdateAddressResponse;
import com.meila.soa.order.dal.dao.order.OrderAddressEntityMapper;
import com.meila.soa.order.dal.dao.order.ZoneEntityMapper;
import com.meila.soa.order.dal.entity.order.OrderAddressEntity;
import com.meila.soa.order.dal.entity.order.ZoneEntity;

/**
 * 
 ************************************************************
 * @类名 : DubboOrderAddressServiceImpl.java
 *
 * @DESCRIPTION : 订单地址服务
 * @AUTHOR : gogo
 * @DATE : 2016年5月16日
 ************************************************************
 */
public class DubboOrderAddressServiceImpl implements DubboOrderAddressService {

    @Autowired
    private OrderAddressEntityMapper orderAddressEntityMapper;
    @Autowired
    private OmsClient omsClient;
    @Autowired
    private ZoneEntityMapper zoneEntityMapper;

    @Override
    public DubboUpdateAddressResponse updateAddress(DubboUpdateAddressRequest request) {
        DubboUpdateAddressResponse response = new DubboUpdateAddressResponse();

        OrderAddressDto dto = new OrderAddressDto();
        dto.setOrderNo(request.getOrderNo());
        dto.setOrderId(request.getOrderId());
        dto.setSellerId(request.getSellerId());
        dto.setCardNo(request.getIdCard());
        dto.setOrderAddressId(request.getAddressId());
        dto.setPhone(request.getPhone());
        dto.setConsignee(request.getConsignee());
        dto.setCountry(request.getCountry());
        dto.setProvince(request.getProvince());
        dto.setCity(request.getCity());
        dto.setZone(request.getZone());
        dto.setDetailAddress(request.getStreet());

        if (!omsClient.sendSyncOrderAddress(dto)) {
            response.setCode(DubboReturnCode.SYNC_SERVER_ERR);
            response.setDesc("同步到OMS失败");
            return response;
        }

        OrderAddressEntity record = new OrderAddressEntity();
        record.setOrderId(request.getOrderId());
        record.setZoneId(request.getZoneId());
        record.setConsignee(request.getConsignee());
        record.setStreet(request.getStreet());
        record.setPhone(request.getPhone());
        record.setIdCard(request.getIdCard());

        orderAddressEntityMapper.updateByOrderId(record);
        return response;
    }

    @Override
    public DubboQueryOrderAddressInfoByOrderIdResponse queryOrderAddressInfoByOrderId(DubboQueryOrderAddressInfoByOrderIdRequest request) {
        DubboQueryOrderAddressInfoByOrderIdResponse response = new DubboQueryOrderAddressInfoByOrderIdResponse();
        OrderAddressEntity orderAddressEntity = orderAddressEntityMapper.selectByOrderId(request.getOrderId());
        if (orderAddressEntity == null) {
            response.setCode(DubboReturnCode.PARAMETER_ERR);
            response.setDesc("订单地址信息为空");
            return response;
        }

        ZoneEntity zoneEntity = zoneEntityMapper.selectByPrimaryKey(orderAddressEntity.getZoneId());

        if (zoneEntity == null) {
            response.setCode(DubboReturnCode.PARAMETER_ERR);
            response.setDesc("订单地址zoneId对应的地区信息为空");
            return response;
        }

        StringBuilder zoneDesc = new StringBuilder();
        String path = zoneEntity.getPath();
        String[] zoneIds = path.split(">");

        DubboOrderAddressInfo info = BeanMapper.map(orderAddressEntity, DubboOrderAddressInfo.class);

        for (int i = 0; i < zoneIds.length; i++) {
            // 当zoneId为空跳过,第一个zoneId也跳过,第一个zoneId为中国，显示只需从省份开始
            if (StringUtils.isEmpty(zoneIds[i]) || i == 0) {
                continue;
            }

            // @ TODO 多次查询，该表的数据不多，只做查询，使用缓存处理
            ZoneEntity temp = zoneEntityMapper.selectByPrimaryKey(Long.valueOf(zoneIds[i]));
            zoneDesc.append(temp.getName());

            if (i == 1) {
                info.setProvince(temp.getName());
                info.setProvinceId(temp.getId());
            } else if (i == 2) {
                info.setCity(temp.getName());
                info.setCityId(temp.getId());
            } 
        }

        zoneDesc.append(zoneEntity.getName());
        info.setZone(zoneEntity.getName());

        info.setZoneDesc(zoneDesc.toString());

        response.setDubboOrderAddressInfo(info);

        return response;
    }

    @Override
    public DubboQueryOrderAddressAllZoneListResponse queryOrderAddressAllZoneList(DubboQueryOrderAddressAllZoneListRequest request) {

        DubboQueryOrderAddressAllZoneListResponse response = new DubboQueryOrderAddressAllZoneListResponse();
        List<ZoneEntity> allZone = zoneEntityMapper.selectAll();
        if (Collections3.isEmpty(allZone)) {
            response.setCode(DubboReturnCode.PARAMETER_ERR);
            response.setDesc("地区表的地区信息为空");
            return response;
        }

        List<DubboAddressZone> zoneList = new ArrayList<>();
        Map<Long, DubboAddressZone> temp = new HashMap<>();
        int length = allZone.size();

        for (int i = 0; i < length; i++) {
            ZoneEntity zoneEntity = allZone.get(i);
            // 第一条国家不解析进去
            if (zoneEntity.getParentId().longValue() == 0L) {
                continue;
            }

            DubboAddressZone dubboAddressZone = transToDubboAddressZone(zoneEntity);
            temp.put(dubboAddressZone.getId(), dubboAddressZone);
            // 父节点为1，代表省份
            if (zoneEntity.getParentId().longValue() == 1) {
                zoneList.add(dubboAddressZone);
                continue;
            }

            DubboAddressZone parentZone = temp.get(zoneEntity.getParentId());
            parentZone.addZone(dubboAddressZone);
        }

        // @ TODO 此处可做内存缓存
        response.setZoneList(zoneList);

        return response;
    }

    public static void main(String[] args) {
        System.out.println("1>".split(">").length);
    }

    private DubboAddressZone transToDubboAddressZone(ZoneEntity zoneEntity) {
        DubboAddressZone zone = new DubboAddressZone();
        zone.setId(zoneEntity.getId());
        zone.setName(zoneEntity.getName());

        return zone;
    }

}
