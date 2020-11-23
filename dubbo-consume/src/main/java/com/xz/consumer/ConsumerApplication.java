package com.xz.consumer;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xz
 * @ClassName ConsumerApplication
 * @Description
 * @date 2020/11/23 0023 21:28
 **/
@SpringBootApplication
@EnableDubbo
@MapperScan("com.xz.consumer.mapper")
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
