package com.xz.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xz
 * @ClassName ProviderApplication
 * @Description
 * @date 2020/11/23 0023 21:17
 **/
@SpringBootApplication
@EnableDubbo
@MapperScan("com.xz.provider.mapper")
public class ProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }
}
