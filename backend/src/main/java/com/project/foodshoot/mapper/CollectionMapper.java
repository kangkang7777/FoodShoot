package com.project.foodshoot.mapper;

import com.project.foodshoot.entity.Collection;
import com.project.foodshoot.entity.Concern;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CollectionMapper {

    @Insert("insert into collection(recipe_id,user_id) values(#{recipeId},#{userId})")
    @Results({
            @Result(column = "collection_id",property = "collectionId"),
            @Result(column = "recipe_id",property = "recipeId"),
            @Result(column = "user_id",property = "userId")
    })
    boolean insertCollection(String recipeId,String userId);

    @Delete("delete from collection where user_id=#{userId} and recipe_id=#{recipeId}")
    @Results({
            @Result(column = "collection_id",property = "collectionId"),
            @Result(column = "recipe_id",property = "recipeId"),
            @Result(column = "user_id",property = "userId")
    })
    boolean deleteCollectionByRecipeIdAndUserId(String recipeId, String userId);

    @Select("select * from collection where user_id=#{userId} and recipe_id=#{recipeId}")
    @Results({
            @Result(column = "collection_id",property = "collectionId"),
            @Result(column = "recipe_id",property = "recipeId"),
            @Result(column = "user_id",property = "userId")
    })
    Collection getCollectionByRecipeIdAndUserId(String recipeId, String userId);

    @Select("select * from collection where user_id=#{userId}")
    @Results({
            @Result(column = "collection_id",property = "collectionId"),
            @Result(column = "recipe_id",property = "recipeId"),
            @Result(column = "user_id",property = "userId")
    })
    List<Collection> getAllFCollectionByUserId(String userId);

    @Select("select * from collection where collection_id=#{collectionId}")
    @Results({
            @Result(column = "collection_id",property = "collectionId"),
            @Result(column = "recipe_id",property = "recipeId"),
            @Result(column = "user_id",property = "userId")
    })
    Collection getCollectionByCollectionId(String collectionId);

}
