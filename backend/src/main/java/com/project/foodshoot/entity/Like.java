package com.project.foodshoot.entity;

public class Like {
    private int likeId;
    private int recipeId;
    private int likerId;

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public int getLikerId() {
        return likerId;
    }

    public void setLikerId(int likerId) {
        this.likerId = likerId;
    }
}
