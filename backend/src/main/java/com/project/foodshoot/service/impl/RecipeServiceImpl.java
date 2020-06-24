package com.project.foodshoot.service.impl;

import com.project.foodshoot.entity.Recipe;
import com.project.foodshoot.mapper.RecipeMapper;
import com.project.foodshoot.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {
    @Autowired
    private RecipeMapper recipeMapper;

    @Override
    public boolean insertRecipe(int publisherId, String title, String image, String description, int likes, int collections, boolean if_recipe){
        recipeMapper.insertRecipe(publisherId,title,image,description,likes,collections,if_recipe);
        return true;
    }

    @Override
    public boolean deleteRecipeByRecipeId(int recipeId){
        recipeMapper.deleteRecipeByRecipeId(recipeId);
        return true;
    }

    @Override
    public Recipe getRecipeByRecipeId(int recipeId){
        return recipeMapper.getRecipeByRecipeId(recipeId);
    }

    @Override
    public  Recipe getRecipeRandomly(){
        return recipeMapper.getRecipeRandomly();
    }

    @Override
    public List<Recipe> getRecipeByUser(int userId){
        return recipeMapper.getRecipeByUser(userId);
    }

    @Override
    public boolean alterRecipe(int publisherId,int recipeID,String title,String uploadPathDB,String description){
        return recipeMapper.alterRecipe(publisherId,recipeID,title,uploadPathDB,description);
    }

    //点赞有关，供LikeService调用
    public void addLikes(int recipeId){
        Recipe recipe = recipeMapper.getRecipeByRecipeId(recipeId);
        int likes = recipe.getLikes();
        likes = likes + 1;
        recipeMapper.alterLikes(likes, recipeId);
    }

    public void cancelLikes(int recipeId){
        Recipe recipe = recipeMapper.getRecipeByRecipeId(recipeId);
        int likes = recipe.getLikes();
        likes = likes - 1;
        recipeMapper.alterLikes(likes, recipeId);
    }
}
