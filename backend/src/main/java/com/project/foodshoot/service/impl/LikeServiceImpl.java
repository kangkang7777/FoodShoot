package com.project.foodshoot.service.impl;

import com.project.foodshoot.entity.Like;
import com.project.foodshoot.mapper.LikeMapper;
import com.project.foodshoot.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeMapper likeMapper;
    public void upvote(int recipeId, int likerId){
        //todo
        //此处还应调用食谱服务的相关逻辑，增加食谱的点赞数量
        likeMapper.addLike(recipeId, likerId);
    }

    public void cancelUpvote(int recipeId, int likerId){
        //todo
        //同上,需要修改食谱表中的点赞数量
        likeMapper.deleteLike(recipeId, likerId);
    }

    public List<Map<String, Object>> getLikeRecipe(int likerId){
        //todo
        //需要recipe表的相关属性
        return null;
    }

    public boolean ifUpvote(int recipeId, int likerId){
        return likeMapper.getLikeByRecipeIdAndLikerId(recipeId, likerId) != null;
    }
}
