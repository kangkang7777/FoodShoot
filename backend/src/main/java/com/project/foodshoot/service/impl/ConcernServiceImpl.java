package com.project.foodshoot.service.impl;

import com.project.foodshoot.entity.Concern;
import com.project.foodshoot.mapper.ConcernMapper;
import com.project.foodshoot.service.ConcernService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ConcernServiceImpl implements ConcernService {
    @Autowired
    private ConcernMapper concernMapper;

    @Override
    public boolean addConcern(String userid, String fansId) {
        return concernMapper.insertConcern(userid, fansId);
    }

    @Override
    public Concern getConcernByConcernId(String concernId) {
        return concernMapper.getConcernByConcernId(concernId);
    }

    @Override
    public boolean deleteConcernByUserId(String userId, String fansId) {
        return concernMapper.deleteConcernByUserIdAndFansId(userId, fansId);
    }

    @Override
    public boolean deleteConcernByConcernId(String concernId) {
        return concernMapper.deleteConcernByConcernId(concernId);
    }

    @Override
    public Integer getConcernIdByUserId(String userId, String fansId) {
        return concernMapper.getConcernByUserIdAndFansId(userId, fansId).getConcernId();
    }

    @Override
    public boolean isConcern(String userId, String fansId) {
        return concernMapper.getConcernByUserIdAndFansId(userId, fansId) != null;
    }

    @Override
    public List<Integer> getMyFans(String userId) {
        List<Concern> temp = concernMapper.getAllFansByUserId(userId);
        List<Integer> res = new LinkedList<>();
        if (temp == null){
            return null;
        }else {
            for (Concern concern : temp) {
                res.add(concern.getFansId());
            }
        }
        return res;
    }

    @Override
    public List<Integer> getMyFollowings(String userId) {
        List<Concern> temp = concernMapper.getAllFollowingsByUserId(userId);
        List<Integer> res = new LinkedList<>();
        if (temp == null){
            return null;
        }else {
            for (Concern concern : temp) {
                res.add(concern.getUserId());
            }
        }
        return res;
    }

}
