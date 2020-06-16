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
    public void addComment(@RequestParam int userId, @RequestParam int recipeId, @RequestParam String content){
        commentService.addComment(userId, recipeId, content);
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
    public void deleteCommentsByRecipeId(int recipeId){
        commentService.deleteCommentsByRecipeId(recipeId);
    }

    @DeleteMapping(value = "/{commentId}")
    public void deleteCommentByCommentId(int commentId){
        commentService.deleteCommentByCommentId(commentId);
    }
}
