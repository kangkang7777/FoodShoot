package com.project.foodshoot.controller;

import com.project.foodshoot.entity.Concern;
import com.project.foodshoot.service.ConcernService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/concern")
public class ConcernController {
    @Autowired
    private ConcernService concernService;

    @PostMapping(value = "/addConcern")
    public boolean addConcern(@RequestParam String userId, @RequestParam String fansId){
        return concernService.addConcern(userId, fansId);
    }

    @DeleteMapping(value = "/deleteConcernByUserId")
    public boolean deleteConcernByUserId(@RequestParam String userId, @RequestParam String fansId){
        return concernService.deleteConcernByUserId(userId, fansId);
    }

    @DeleteMapping(value = "/deleteConcernByConcernId")
    public boolean deleteConcernByConcernId(@RequestParam String concernId){
        return concernService.deleteConcernByConcernId(concernId);
    }

    @GetMapping(value = "/getMyFans")
    public List<Integer> getMyFans(@RequestParam String userId){
        return concernService.getMyFans(userId);
    }

    @GetMapping(value = "/getMyFollowings")
    public List<Integer> getMyFollowingss(@RequestParam String userId){
        return concernService.getMyFollowings(userId);
    }

    @GetMapping(value = "/getConcernId")
    public Integer getConcernId(@RequestParam String userId, @RequestParam String fansId){
        return concernService.getConcernIdByUserId(userId,fansId);
    }

    @GetMapping(value = "/isConcern")
    public boolean isConcernId(@RequestParam String userId, @RequestParam String fansId){
        return concernService.isConcern(userId,fansId);
    }

    @GetMapping(value = "/getConcern")
    public Concern getConcern(@RequestParam String concernId){
        return concernService.getConcernByConcernId(concernId);
    }
}
