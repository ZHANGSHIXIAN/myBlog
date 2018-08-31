package com.zsx.exception;

import com.zsx.enums.ResultEnum;

//自动以的异常类 用于返回ResultEnum
public class MyBlogException extends RuntimeException {
    private Integer code;

    public MyBlogException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
