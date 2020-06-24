package com.project.foodshoot.mapper;

import com.project.foodshoot.entity.Comment;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper {
    @Insert("insert into comment(commentator_id,recipe_id,content,publish_time) values(#{userId},#{recipeId},#{content},#{time})")
    void addComment(int userId, int recipeId, String content, String time);

    //查询某个食谱/动态下的所有评论
    @Select("select * from comment where recipe_id=#{recipeId}")
    @Results({
            @Result(column = "comment_id", property = "commentId"),
            @Result(column = "commentator_id", property = "commentatorId"),
            @Result(column = "recipe_id", property = "recipeId"),
            @Result(column = "publish_time", property = "publishTime")
    })
    List<Comment> getCommentsByRecipeId(int recipeId);

    //查询用户的所有评论
    @Select("select * from comment where commentator_id=#{userId}")
    @Results({
            @Result(column = "comment_id", property = "commentId"),
            @Result(column = "commentator_id", property = "commentatorId"),
            @Result(column = "recipe_id", property = "recipeId"),
            @Result(column = "publish_time", property = "publishTime")
    })
    List<Comment> getCommentsByUserId(int userId);

    @Delete("delete from comment where comment_id={commentId}")
    void deleteCommentByCommentId(int commentId);

    @Delete("delete from comment where recipe_id={recipeId}")
    void deleteCommentsByRecipeId(int recipeId);
}
