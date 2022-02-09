package com.comphca.mycounterback.common;

/**
 * @Created by comphca
 * @Date 2021/7/1 0:53
 * @Description TODO
 */
public enum ResponseCode {
    SUCCESS(0,"SUCCESS"),
    ERROR(1,"ERROR");

    private int code;
    private String desc;

    ResponseCode(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode(){
        return code;
    }

    public String getDesc(){
        return desc;
    }
}
