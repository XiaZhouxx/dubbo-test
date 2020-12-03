package com.xz.provider.ioc;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author xz
 * @ClassName IocTest
 * @Description
 * @date 2020/12/3 17:47
 **/
@Aspect
@Configuration
public class IocTest {

    public static void main(String[] args) {
        /**
         * 测试循环依赖下 初始化方法中使用循环依赖对象, 这也是为什么
         * 循环依赖需要第三级缓存，存储创建循环依赖对象的工厂，
         * 而在这个工厂中，会经过一个PostProcessor 将这个循环依赖早期对象代理
         */
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("com.xz.provider.ioc");
        User bean = context.getBean(User.class);
        bean.hello();
    }

}
