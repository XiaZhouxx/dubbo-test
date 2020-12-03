package com.xz.provider.ioc;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author xz
 * @ClassName MyAspectJ
 * @Description
 * @date 2020/12/3 18:06
 **/
@Aspect
@Component
@EnableAspectJAutoProxy
public class MyAspectJ {
    @Pointcut("execution(* com.xz.provider.ioc..*(..))")
    public void pointcut() {}

    @Before("pointcut()")
    public void before() {
        System.out.println("before");
    }
}
