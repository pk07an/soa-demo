package com.meila.soa.meila.client.dto;

import java.util.List;

/**
 * 
 ************************************************************
 * @类名 : OrderPackageDto.java
 *
 * @DESCRIPTION : 包裹DTO
 * @AUTHOR : gogo
 * @DATE : 2016年5月20日
 ************************************************************
 */
public class OrderPackageDto extends BatchOrderPackageDto {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private List<OrderPackageLogisticsDto> orderPackageLogisticsDtos;

    public List<OrderPackageLogisticsDto> getOrderPackageLogisticsDtos() {
        return orderPackageLogisticsDtos;
    }

    public void setOrderPackageLogisticsDtos(List<OrderPackageLogisticsDto> orderPackageLogisticsDtos) {
        this.orderPackageLogisticsDtos = orderPackageLogisticsDtos;
    }

}
