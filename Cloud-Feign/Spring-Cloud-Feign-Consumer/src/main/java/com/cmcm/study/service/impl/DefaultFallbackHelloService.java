package com.cmcm.study.service.impl;

import com.cmcm.study.entity.User;
import com.cmcm.study.entity.UserDemo;
import com.cmcm.study.service.HelloService;
import org.springframework.stereotype.Component;

/**
 * @author hongfei
 * @create 2018-04-20 下午5:38
 */
@Component
public class DefaultFallbackHelloService implements HelloService {
    @Override
    public String helloService(String name) {
        return "get error";
    }

    @Override
    public String getNameById(Long id) {
        return "getNameById error";
    }

    @Override
    public String helloService(String name, String password) {
        return "head error";
    }

    @Override
    public String helloService(UserDemo userDemo) {
        return "post error";
    }

    @Override
    public User saveUser(User user) {
        return null;
    }
}
