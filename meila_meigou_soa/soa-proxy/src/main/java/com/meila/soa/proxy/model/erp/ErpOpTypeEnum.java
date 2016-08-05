package com.meila.soa.proxy.model.erp;

import org.apache.commons.lang3.StringUtils;

public enum ErpOpTypeEnum {
    
    SKUSYN("SKU_SYNC","erpSkuDataSync","商品信息同步"),
    POSYNC("PO_SYNC","erpPucharseNoteSync","采购单同步"),
    POINSTORE("PO_INSTORE","erpPurchaseNoteInstorage","采购单入库"),
    CATEGORYSYNC("CATEGORY_SYNC","erpCategorySync","分类树同步"),
    INVENTORYSYNC("INVENTORY_SYNC","erpInventorySync","库存同步"),
    ORDERSYNC("ORDER_SYNC","erpOrderPackageSync","销售单同步"),
    POINSTORERETURN("PO_INSTORE_RETURN","erpPurchaseNoteInstorageReturn","采购单入库同步结果回传"),
    ORDERSYNCRETURN("ORDER_SYNC_RETURN","erpOrderPackageSyncReturn","销售单同步结果回传");
    
    private String code;
    private String method;
    private String msg;
    
    private ErpOpTypeEnum (String code,String method,String msg){
        this.code = code;
        this.method = method;
        this.msg = msg;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMethod() {
        return method;
    }
    public void setMethod(String method) {
        this.method = method;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    /**
     * 
     *
     * 功能描述：根据opType Code 获取枚举对象
     * 
     * @param code
     * @return ErpOpTypeEnum
     *
     */
    public static ErpOpTypeEnum getOpTypeEnumByCode(String code){
        if(StringUtils.isBlank(code)){
            return null;
        }
        
        for(ErpOpTypeEnum type:ErpOpTypeEnum.values()){
            if(type.getCode().equalsIgnoreCase(code)){
                return type;
            }
        }
        
        return null;
    }
    
}
