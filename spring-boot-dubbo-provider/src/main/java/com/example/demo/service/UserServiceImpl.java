package com.example.demo.service;

import com.example.demo.domain.User;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * Created by Administrator on 2018/1/24 0024.
 */
@Service(version = "1.0.0")
public class UserServiceImpl implements UserService {
    @Override
    public User getUserById(String id) {
        User user = new User();
        user.setAge(11);
        user.setId(id);
        user.setName("fuyi");
        return user;
    }
}
