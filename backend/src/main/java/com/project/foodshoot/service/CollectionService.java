package com.project.foodshoot.service;

import com.project.foodshoot.entity.Collection;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CollectionService {
    boolean addCollection(String userId,String recipeId);
    boolean deleteCollectionByUserId(String userId,String recipeId);
    boolean isCollection(String userId,String recipeId);
    Collection getCollectionByCollectionId(String collectionId);
    Collection getCollectionByRecipeIdAndUserId(String userId,String recipeId);
    List<Integer> getCollection(String userId);
}
