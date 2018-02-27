package com.example.demo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/1/24 0024.
 */
@RestController
public class UserController {

    @Reference(version = "1.0.0")
    UserService userService;

    @RequestMapping("/getUserById")
    public User getUserById(String id){
        return userService.getUserById(id);
    }
}
