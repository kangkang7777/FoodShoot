package com.project.foodshoot.service.impl;

import com.project.foodshoot.entity.Advertisement;
import com.project.foodshoot.mapper.AdvertisementMapper;
import com.project.foodshoot.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {
    @Autowired
    private AdvertisementMapper advertisementMapper;

    public List<Advertisement> getAdvertisement(){
        return advertisementMapper.getAdvertisement();
    }
}
