package com.project.foodshoot.controller;

import com.project.foodshoot.entity.Recipe;
import com.project.foodshoot.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/likes")
public class LikeController {
    @Autowired
    private LikeService likeService;

    @PostMapping
    public void upvote(@RequestParam int recipeId, @RequestParam int likerId){
        likeService.upvote(recipeId, likerId);
    }

    @DeleteMapping(value = "/{recipeId}/{likerId}")
    public void cancelUpvote(@PathVariable int recipeId, @PathVariable int likerId){
        likeService.cancelUpvote(recipeId, likerId);
    }

    @GetMapping(value = "/{likerId}")
    public List<Recipe> getLikeRecipe(@PathVariable int likerId){
        return likeService.getLikeRecipe(likerId);
    }

    @GetMapping(value = "/{recipeId}/{likerId}")
    public boolean ifUpvote(@PathVariable int recipeId, @PathVariable int likerId){
        return likeService.ifUpvote(recipeId, likerId);
    }
}
