package com.cmcm.study.controller;

import com.cmcm.study.dao.UserRepository;
import com.cmcm.study.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hongfei
 * @create 2018-05-16 下午6:48
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User findUser(@PathVariable Long id){
        User user = this.userRepository.findOne(id);
        return user;
    }
}
