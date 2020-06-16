package com.project.foodshoot.mapper;

import com.project.foodshoot.entity.Recipe;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RecipeMapper {
    @Insert("insert into recipe(publisher_id,title,image,description,likes,collections,if_recipe) " +
            "values(#{publisherID},#{title},#{image},#{description},#{likes},#{collections},#{if_recipe})")
    boolean insertRecipe(int publisherId, String title, String image, String description, int likes, int collections, boolean if_recipe);

    @Delete("delete from recipe where recipe_id=#{recipeId}")
    boolean deleteRecipeByRecipeId(int recipeId);

    @Select("select * from recipe where recipe_id=#{recipeId}")
    @Results({
            @Result(column = "publisher_id", property = "publisherId"),
            @Result(column = "recipe_id", property = "recipeId"),
            @Result(column = "title", property = "title"),
            @Result(column = "image", property = "image"),
            @Result(column = "description", property = "description"),
            @Result(column = "likes", property = "likes"),
            @Result(column = "collections", property = "collections"),
            @Result(column = "if_recipe", property = "if_recipe")
    })
    Recipe getRecipeByRecipeId(int recipeId);

    @Select("select * from recipe where user_id=#{userId}")
    List<Recipe> getRecipeByUser(int userId);

    @Select("SELECT * FROM recipe ORDER BY RAND() LIMIT 1")
    @Results({
            @Result(column = "publisher_id", property = "publisherId"),
            @Result(column = "recipe_id", property = "recipeId"),
            @Result(column = "title", property = "title"),
            @Result(column = "image", property = "image"),
            @Result(column = "description", property = "description"),
            @Result(column = "likes", property = "likes"),
            @Result(column = "collections", property = "collections"),
            @Result(column = "if_recipe", property = "if_recipe")
    })
    Recipe getRecipeRandomly();

    @Update("update recipe set title=#{title},image=#{uploadPathDB},description=#{description} " +
            "where recipe_id=#{recipeID} and publisher_id=#{publisherID}")
    boolean alterRecipe(int publisherId,int recipeID,String title,String uploadPathDB,String description);

    @Update("update recipe set likes=#{likes} where recipe_id=#{recipeId}")
    void alterLikes(int likes, int recipeId);
}
