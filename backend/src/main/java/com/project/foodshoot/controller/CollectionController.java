package com.project.foodshoot.controller;

import com.project.foodshoot.entity.Collection;
import com.project.foodshoot.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/collection")
public class CollectionController {
    @Autowired
    private CollectionService collectionService;

    @PostMapping(value = "/addCollection")
    public boolean addConcern(@RequestParam String userId, @RequestParam String recipeId){
        return collectionService.addCollection(userId, recipeId);
    }

    @DeleteMapping(value = "/deleteCollectionByUserId")
    public boolean deleteCollectionByUserId(@RequestParam String userId, @RequestParam String recipeId){
        return collectionService.deleteCollectionByUserId(userId, recipeId);
    }

    @GetMapping(value = "/isCollection")
    public boolean isCollectionId(@RequestParam String userId, @RequestParam String recipeId){
        return collectionService.isCollection(userId, recipeId);
    }

    @GetMapping(value = "/getCollectionByCollectionId")
    public Collection getCollection(@RequestParam String collectionId){
        return collectionService.getCollectionByCollectionId(collectionId);
    }

    @GetMapping(value = "/getCollectionByRecipeIdAndUserId")
    public Collection getCollectionByRecipeIdAndUserId(@RequestParam String userId,@RequestParam String recipeId){
        return collectionService.getCollectionByRecipeIdAndUserId(userId,recipeId);
    }

    @GetMapping(value = "/getCollection")
    public List<Integer> getCollections(@RequestParam String userId){
        return collectionService.getCollection(userId);
    }
}
