package com.project.foodshoot.service;

import com.project.foodshoot.entity.Like;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface LikeService {
    void upvote(int recipeId, int likerId);

    void cancelUpvote(int recipeId, int likerId);

    List<Map<String, Object>> getLikeRecipe(int likerId);

    boolean ifUpvote(int recipeId, int likerId);
}
