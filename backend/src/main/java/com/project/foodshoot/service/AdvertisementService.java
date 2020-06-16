package com.project.foodshoot.service;

import com.project.foodshoot.entity.Advertisement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdvertisementService {
    List<Advertisement> getAdvertisement();
}
