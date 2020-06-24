package com.project.foodshoot.entity;

public class History {
    int historyId;
    int recipeId;
    int userId;
    String visitTime;

    public int getHistoryId(){
        return historyId;
    }

    public void setHistoryId(int historyId) {
        this.historyId = historyId;
    }

    public int getRecipeId(){
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public int getUserId(){
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime;
    }

}
