package com.project.foodshoot.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface UserService {
    boolean register(String email,String password);
    boolean login(String email, String password);
    Map<String, Object> getInformation(String email);
    String getEmail(String userId);
    int getUserId(String email);
    boolean alterInformation(String email,String name,String age);
    boolean alterPassword(String email,String password);
}
