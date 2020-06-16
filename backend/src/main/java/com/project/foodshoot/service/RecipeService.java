package com.project.foodshoot.service;

import com.project.foodshoot.entity.Recipe;

import java.util.List;

public interface RecipeService {

    boolean insertRecipe(int publisherId, String title, String image, String description, int likes, int collections, boolean if_recipe);

    boolean deleteRecipeByRecipeId(int recipeId);

    Recipe getRecipeByRecipeId(int recipeId);

    List<Recipe> getRecipeByUser(int userId);
}
