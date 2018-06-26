package com.cmcm.study.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Spontaneously
 * @time 2018-06-15 下午4:49
 */
@RestController
@RefreshScope
public class ProfileController {

    @Value("${profile}")
    private String profile;


    @GetMapping("/getProfile")
    public String getProfile() {
        return profile;
    }
}
