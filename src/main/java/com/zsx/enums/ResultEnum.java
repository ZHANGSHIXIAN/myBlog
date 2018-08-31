package com.zsx.enums;

//http返回数据的枚举
public enum ResultEnum {
    UNKNOW_ERROR(-1,"未知错误"),
    LOGIN_SUCCESS(0,"登陆成功"),
    LOGIN_FAIL(1,"登陆失败"),
    SUBMIT_FAIL(101,"发表博客失败"),
    SUBMIT_SUCCESS(100,"发表博客成功"),
    DELETE_SUCCESS(200,"删除博客成功"),
    DELETE_FAIL(201,"删除博客失败");


    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
