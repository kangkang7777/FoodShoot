package com.project.foodshoot.controller;

import com.project.foodshoot.entity.Comment;
import com.project.foodshoot.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping
    public boolean addComment(@RequestParam int userId, @RequestParam int recipeId, @RequestParam String content){
        return commentService.addComment(userId, recipeId, content);
    }

    @GetMapping(value = "/{recipeId}")
    public List<Comment> getCommentsByRecipeId(@PathVariable int recipeId){
        return commentService.getCommentsByRecipeId(recipeId);
    }

    @GetMapping(value = "/users/{userId}")
    public List<Comment> getCommentsByUserId(@PathVariable int userId){
        return commentService.getCommentsByUserId(userId);
    }

    @DeleteMapping(value = "/recipe/{recipeId}")
    public boolean deleteCommentsByRecipeId(int recipeId){
        return commentService.deleteCommentsByRecipeId(recipeId);
    }

    @DeleteMapping(value = "/{commentId}")
    public boolean deleteCommentByCommentId(int commentId){
        return commentService.deleteCommentByCommentId(commentId);
    }
}
