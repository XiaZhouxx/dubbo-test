package com.xz.provider.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author xz
 * @ClassName User
 * @Description
 * @date 2020/12/3 18:06
 **/
@Component
public class User {
    @Autowired
    User1 u1;

    @PostConstruct
    public void init() {
        u1.hello();
    }

    public void hello() {
        System.out.println("user");
    }
}
