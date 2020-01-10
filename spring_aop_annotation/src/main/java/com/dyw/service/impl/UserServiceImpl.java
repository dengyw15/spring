package com.dyw.service.impl;

import com.dyw.service.UserService;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    public void saveUser(String name) {
        System.out.println("保存用户" + name);
    }

    public String getUser() {
        System.out.println("获取用户");
        int i = 1/0;
        return "user";
    }
}
