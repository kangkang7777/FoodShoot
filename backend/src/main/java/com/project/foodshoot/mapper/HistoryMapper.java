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

}
