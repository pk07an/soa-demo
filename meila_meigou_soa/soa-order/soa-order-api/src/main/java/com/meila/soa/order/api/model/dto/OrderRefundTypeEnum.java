package com.meila.soa.order.api.model.dto;

public enum OrderRefundTypeEnum {
    ALL("ALL","全额退款"), // 全额退款
    PART("PART","部分退款"), // 部分退款
    RETURNGOODS("RETURNGOODS","退款+退货");//退款+退货
        
        private OrderRefundTypeEnum(String code, String desc)
        {
            this.code = code;
            this.desc = desc;
        }
        
        private String code;
        private String desc;
        
        public static OrderRefundTypeEnum findOrderRefundType(String code){
            for(OrderRefundTypeEnum refundType:OrderRefundTypeEnum.values()){
                if(refundType.getCode().equals(code)){
                    return refundType;
                }
            }
            return null;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
}
