package com.project.foodshoot.service.impl;

import com.project.foodshoot.entity.Like;
import com.project.foodshoot.entity.Recipe;
import com.project.foodshoot.mapper.LikeMapper;
import com.project.foodshoot.service.LikeService;
import com.project.foodshoot.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeMapper likeMapper;
    @Autowired
    private RecipeService recipeService;

    public void upvote(int recipeId, int likerId){

        //此处还应调用食谱服务的相关逻辑，增加食谱的点赞数量
        recipeService.addLikes(recipeId);
        likeMapper.addLike(recipeId, likerId);
    }

    public void cancelUpvote(int recipeId, int likerId){

        //同上,需要修改食谱表中的点赞数量
        recipeService.cancelLikes(recipeId);
        likeMapper.deleteLike(recipeId, likerId);
    }

    public List<Recipe> getLikeRecipe(int likerId){
        List<Like> likeList = likeMapper.getLikesByLikerId(likerId);
        List<Recipe> recipeList = new ArrayList<>();
        for (Like like : likeList){
            int recipeId = like.getRecipeId();
            Recipe recipe = recipeService.getRecipeByRecipeId(recipeId);
            recipeList.add(recipe);
        }
        return recipeList;
    }

    public boolean ifUpvote(int recipeId, int likerId){
        return likeMapper.getLikeByRecipeIdAndLikerId(recipeId, likerId) != null;
    }


}
