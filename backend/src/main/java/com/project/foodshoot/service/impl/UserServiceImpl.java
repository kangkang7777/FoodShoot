package com.project.foodshoot.service.impl;

import com.project.foodshoot.entity.User;
import com.project.foodshoot.mapper.UserMapper;
import com.project.foodshoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public Map<String, Object> login(String email, String password){
        User user = userMapper.getUserByEmailAndPassword(email, password);
        Map<String, Object> map = new HashMap<>();
        if (user == null){
            map.put("status", false);
        }else {
            map.put("user", user);
            map.put("status", true);
        }
        return map;
    }
}
