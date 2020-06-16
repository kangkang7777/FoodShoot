package com.project.foodshoot.service;

import com.project.foodshoot.entity.Concern;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ConcernService {
    boolean addConcern(String userId,String fansId);
    Concern getConcernByConcernId(String concernId);
    boolean deleteConcernByUserId(String userId,String fansId);
    boolean deleteConcernByConcernId(String concernId);
    Integer getConcernIdByUserId(String userId,String fansId);
    boolean isConcern(String userId,String fansId);

    //获取的所有粉丝
    List<Integer> getMyFans(String userId);
    //获取的所有关注对象
    List<Integer> getMyFollowings(String userId);

}
