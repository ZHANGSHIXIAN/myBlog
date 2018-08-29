package com.zsx.web;

import com.zsx.bean.Result;
import com.zsx.exception.MyBlogException;
import com.zsx.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger=LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof MyBlogException){
            logger.info("1111111111111111111111111", e);
            MyBlogException exception=(MyBlogException) e;
            return ResultUtil.error(exception.getCode(), exception.getMessage());
        }else {
            logger.error("[系统异常]", e);
            return ResultUtil.error(-1,"未知错误");
        }


    }
}
