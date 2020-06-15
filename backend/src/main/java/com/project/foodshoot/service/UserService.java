package com.project.foodshoot.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface UserService {
    Map<String, Object> login(String email, String password);
}
