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

    @Override
    public boolean register(String email, String password) {
        return userMapper.insertUser(email,password);
    }

    public boolean login(String email, String password){
        User user = userMapper.getUserByEmailAndPassword(email, password);
        return user != null;
    }

    @Override
    public Map<String, Object> getInformation(String email) {
        User user = userMapper.getUserByEmail(email);
        Map<String, Object> map = new HashMap<>();
        if (user == null){
            map.put("status", false);
        }else {
            map.put("name", user.getName());
            map.put("age", user.getAge());
        }
        return map;
    }

    @Override
    public String getEmail(String userId) {
        User user = userMapper.getUserByUserId(userId);
        if(user != null)
            return user.getEmail();
        else
            return null;
    }

    @Override
    public int getUserId(String email) {
        User user = userMapper.getUserByEmail(email);
        if(user != null)
            return user.getUserId();
        else
            return -1;
    }

    @Override
    public boolean alterInformation(String email, String name, String age) {
        return userMapper.updateInformation(email,name,age);
    }

    @Override
    public boolean alterPassword(String email, String password) {
        return userMapper.updatePassword(email,password);
    }

}
