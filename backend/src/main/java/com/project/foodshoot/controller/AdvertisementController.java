package com.project.foodshoot.controller;

import com.project.foodshoot.entity.Advertisement;
import com.project.foodshoot.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/advertisement")
public class AdvertisementController {
    @Autowired
    private AdvertisementService advertisementService;

    @GetMapping
    public List<Advertisement> getAdvertisement(){
        return advertisementService.getAdvertisement();
    }
}
