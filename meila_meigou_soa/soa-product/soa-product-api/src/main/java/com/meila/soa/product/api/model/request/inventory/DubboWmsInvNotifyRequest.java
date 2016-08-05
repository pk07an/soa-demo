package com.meila.soa.product.api.model.request.inventory;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.meila.dubbo.base.model.BasicSeriModel;
import com.meila.dubbo.base.model.DubboBasicRequest;
import com.meila.soa.product.api.constant.SkuInvChangeType;

/**
 * 
 ************************************************************
 * @类名 : DubboAddFragmentRequest.java
 *
 * @DESCRIPTION :添加片段信息
 * @AUTHOR : hawk
 * @DATE : 2016年4月1日
 ************************************************************
 */
public class DubboWmsInvNotifyRequest extends DubboBasicRequest {
    private static final long serialVersionUID = 1L;

    @Valid
    @NotEmpty(message = "通知内容不能为空")
    private List<DubboInvNotify> invNotifyList;

    public List<DubboInvNotify> getInvNotifyList() {
        return invNotifyList;
    }

    public void setInvNotifyList(List<DubboInvNotify> invNotifyList) {
        this.invNotifyList = invNotifyList;
    }

    public static class DubboInvNotify extends BasicSeriModel {

        /**
         * 
         */
        private static final long serialVersionUID = 1L;

        /**
         * 普通sku则是long型数据, erp商品则是erpskuid
         */
        @NotNull(message = "sku id不能为空")
        private String skuId;

        /**
         * 唯一标示
         */
        @NotNull(message = "事务ID不能为空")
        private String transactionId;

        /**
         * 改变类型
         */
        @NotNull(message = "改变类型不能为空")
        private SkuInvChangeType type;

        /**
         * 改变数量
         */
        @NotNull(message = "改变数量不能为空")
        private Integer changeNum;

        /**
         * 创建时间
         */
        @NotNull(message = "创建时间不能为空")
        private Date createTime;

        public String getSkuId() {
            return skuId;
        }

        public void setSkuId(String skuId) {
            this.skuId = skuId;
        }

        public String getTransactionId() {
            return transactionId;
        }

        public void setTransactionId(String transactionId) {
            this.transactionId = transactionId;
        }

        public SkuInvChangeType getType() {
            return type;
        }

        public void setType(SkuInvChangeType type) {
            this.type = type;
        }

        public Integer getChangeNum() {
            return changeNum;
        }

        public void setChangeNum(Integer changeNum) {
            this.changeNum = changeNum;
        }

        public Date getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Date createTime) {
            this.createTime = createTime;
        }
    }
}
