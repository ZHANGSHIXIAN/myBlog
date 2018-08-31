package com.zsx.bean;

/**
 * http请求返回的最外层对象
 */
public class Result<T> {

    //状态码
    private Integer code;

    //提示信息
    private String msg;

    //数据
    private T data;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
