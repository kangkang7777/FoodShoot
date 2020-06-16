package com.project.foodshoot.service.impl;

import com.project.foodshoot.entity.Collection;
import com.project.foodshoot.mapper.CollectionMapper;
import com.project.foodshoot.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CollectionServiceImpl implements CollectionService {
    @Autowired
    private CollectionMapper collectionMapper;

    @Override
    public boolean addCollection(String userId, String recipeId) {
        return collectionMapper.insertCollection(recipeId,userId);
    }

    @Override
    public boolean deleteCollectionByUserId(String userId, String recipeId) {
        return collectionMapper.deleteCollectionByRecipeIdAndUserId(recipeId,userId);
    }

    @Override
    public boolean isCollection(String userId, String recipeId) {
        return collectionMapper.getCollectionByRecipeIdAndUserId(recipeId,userId) != null;
    }

    @Override
    public Collection getCollectionByCollectionId(String collectionId) {
        return collectionMapper.getCollectionByCollectionId(collectionId);
    }

    @Override
    public Collection getCollectionByRecipeIdAndUserId(String userId, String recipeId) {
        return collectionMapper.getCollectionByRecipeIdAndUserId(recipeId,userId);
    }

    @Override
    public List<Integer> getCollection(String userId) {
        List<Collection> temp = collectionMapper.getAllFCollectionByUserId(userId);
        List<Integer> res = new LinkedList<>();
        if (temp == null){
            return null;
        }else {
            for (Collection collection : temp) {
                res.add(collection.getCollectionId());
            }
        }
        return res;
    }
}
