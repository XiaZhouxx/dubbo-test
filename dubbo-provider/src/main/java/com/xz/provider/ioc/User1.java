package com.xz.provider.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author xz
 * @ClassName User1
 * @Description
 * @date 2020/12/3 18:06
 **/
@Component
public class User1 {
    @Autowired
    User u;

    @PostConstruct
    public void init() {
        u.hello();
    }
    public void hello() {
        System.out.println("user1");
    }
}
