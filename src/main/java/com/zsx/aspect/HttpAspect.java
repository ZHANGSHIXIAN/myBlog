package com.zsx.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class HttpAspect {

    @Pointcut("execution(public * com.zsx.web.BlogController.*(..))")
    public  void log(){


    }
}
