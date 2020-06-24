package com.project.foodshoot.controller;

import com.project.foodshoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    public boolean register(@RequestParam String email, @RequestParam String password){
        return userService.register(email, password);
    }

    @GetMapping(value = "/login")
    public boolean login(@RequestParam String email, @RequestParam String password){
        return userService.login(email, password);
    }

    @GetMapping(value = "/getInformation")
    public Map<String, Object> getInformation(@RequestParam String email)
    {
        return userService.getInformation(email);
    }

    @GetMapping(value = "/getEmail")
    public String getEmail(@RequestParam String userId)
    {
        return userService.getEmail(userId);
    }

    @GetMapping(value = "/getUserId")
    public int getUserId(@RequestParam String email)
    {
        return userService.getUserId(email);
    }

    @PutMapping(value = "/alterInformation")
    public boolean alterInformation(@RequestParam String email,@RequestParam String name,@RequestParam String age)
    {
        return userService.alterInformation(email,name,age);
    }

    @PutMapping(value = "/alterPassword")
    public boolean alterPassword(@RequestParam String email,@RequestParam String password)
    {
        return userService.alterPassword(email,password);
    }

}
