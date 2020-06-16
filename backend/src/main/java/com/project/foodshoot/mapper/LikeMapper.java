package com.project.foodshoot.mapper;

import com.project.foodshoot.entity.Like;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LikeMapper {
    @Insert("insert into likes(recipe_id,liker_id) values(#{recipeId},#{likerId})")
    void addLike(int recipeId, int likerId);

    @Delete("delete from likes where recipe_id=#{recipeId} and liker_id=#{likerId}")
    void deleteLike(int recipeId, int likerId);

    @Select("select * from likes where liker_id=#{likerId}")
    @Results({
            @Result(column = "like_id", property = "likeId"),
            @Result(column = "recipe_id", property = "recipeId"),
            @Result(column = "liker_id", property = "likerId")
    })
    List<Like> getLikesByLikerId(int likerId);

    @Select("select * from likes where recipe_id=#{recipeId} and liker_id=#{likerId}")
    @Results({
            @Result(column = "like_id", property = "likeId"),
            @Result(column = "recipe_id", property = "recipeId"),
            @Result(column = "liker_id", property = "likerId")
    })
    Like getLikeByRecipeIdAndLikerId(int recipeId, int likerId);
}
