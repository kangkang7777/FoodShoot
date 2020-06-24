package com.project.foodshoot.service;

import com.project.foodshoot.entity.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    void addComment(int userId, int recipeId, String content);

    List<Comment> getCommentsByRecipeId(int recipeId);

    List<Comment> getCommentsByUserId(int userId);

    void deleteCommentByCommentId(int commentId);

    void deleteCommentsByRecipeId(int recipeId);
}
