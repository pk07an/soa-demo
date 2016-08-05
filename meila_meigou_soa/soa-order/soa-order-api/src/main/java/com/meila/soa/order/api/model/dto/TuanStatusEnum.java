package com.meila.soa.order.api.model.dto;

/**
 * 
 ************************************************************
 * @类名 : TuanStatusEnum.java
 *
 * @DESCRIPTION : 团状态枚举 
 * @AUTHOR :  gogo
 * @DATE :  2016年5月16日
 ************************************************************
 */
public enum TuanStatusEnum {
    PROCESS("PROCESS","成团中(未满员)"),
    SUCCESS("SUCCESS","已成团(团满员)"),
    CANCEL("CANCEL","已过期(人数未满)");

    
    private TuanStatusEnum(String code, String desc)
    {
        this.code = code;
        this.desc = desc;
    }
    
    private String code;
    private String desc;
    
    public static TuanStatusEnum findTuanStatus(String code){
        for(TuanStatusEnum tuanStatus:TuanStatusEnum.values()){
            if(tuanStatus.getCode().equals(code)){
                return tuanStatus;
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
