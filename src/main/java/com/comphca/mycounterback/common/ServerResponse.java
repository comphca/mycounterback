package com.comphca.mycounterback.common;

/**
 * @Created by comphca
 * @Date 2021/7/1 0:53
 * @Description 服务端统一响应编码
 */
public class ServerResponse<T> {
    //响应结构定义，状态码、描述，数据
    private int status;
    private String message;
    private T data;

    //私有化构造器在内部提供同意返回信息，不给外部构造返回信息体
    private ServerResponse(){};

    private ServerResponse(int status){
        this.status = status;
    }

    private ServerResponse(int status, String message){
        this.status = status;
        this.message = message;
    }

    private ServerResponse(int status, T data){
        this.status = status;
        this.data = data;
    }

    private ServerResponse(int status, String message, T data){
        this.status = status;
        this.message = message;
        this.data = data;
    }

    //提供查询状态方法
    public boolean isSuccess(){
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    //封装统一的返回到浏览器的信息
    public static <T> ServerResponse<T> createBySuccess(){
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ServerResponse<T> cerateBySuccessMessage(String msg){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg);
    }

    public static <T> ServerResponse<T> createBySuccess(T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),data);
    }

    public static <T> ServerResponse<T> cerateBySuccess(String msg, T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), msg, data);
    }


    public static <T> ServerResponse<T> createByError() {
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
    }

    public static <T> ServerResponse<T> createByErrorMessage(String errorMsg) {
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),errorMsg);
    }

    public static <T> ServerResponse<T> createByErrorMessage(int errorCode, String errorMsg) {
        return new ServerResponse<T>(errorCode,errorMsg);
    }
}
