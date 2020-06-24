package com.project.foodshoot.mapper;

import com.project.foodshoot.entity.History;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface HistoryMapper {

    @Select("select * from history where user_id=#{userId}")
    @Results({
            @Result(column = "history_id",property = "historyId"),
            @Result(column = "recipe_id",property = "recipeId"),
            @Result(column = "user_id",property = "userId"),
            @Result(column = "visit_time",property = "visitTime")
    })
    List<History> getAllFHistoryByUserId(String userId);

    @Insert("insert into history(history_id,recipe_id,user_id,visit_time) values(#{historyId},#{recipeId},#{userId},#{visitTime})")
    void addHistory(int historyId, int recipeId, int userId, String visitTime);
}
