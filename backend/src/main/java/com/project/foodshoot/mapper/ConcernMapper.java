package com.project.foodshoot.mapper;

import com.project.foodshoot.entity.Concern;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ConcernMapper {

    @Insert("insert into concern(user_id,fans_id) values(#{userId},#{fansId})")
    @Results({
            @Result(column = "user_id",property = "userId"),
            @Result(column = "fans_id",property = "fansId")
    })
    boolean insertConcern(String userId,String fansId);

    @Delete("delete from concern where concern_id=#{concernId}")
    @Result(column = "concern_id",property = "concernId")
    boolean deleteConcernByConcernId(String concernId);

    @Delete("delete from concern where user_id=#{userId} and fans_id=#{fansId}")
    @Results({
            @Result(column = "user_id",property = "userId"),
            @Result(column = "fans_id",property = "fansId")
    })
    boolean deleteConcernByUserIdAndFansId(String userId, String fansId);

    @Select("select * from concern where user_id=#{userId} and fans_id=#{fansId}")
    @Results({
            @Result(column = "concern_id",property = "concernId"),
            @Result(column = "user_id",property = "userId"),
            @Result(column = "fans_id",property = "fansId")
    })
    Concern getConcernByUserIdAndFansId(String userId, String fansId);

    @Select("select * from concern where concern_id=#{concernId}")
    @Results({
            @Result(column = "concern_id",property = "concernId"),
            @Result(column = "user_id",property = "userId"),
            @Result(column = "fans_id",property = "fansId")
    })
    Concern getConcernByConcernId(String concernId);

    @Select("select * from concern where fans_id=#{userId}")
    @Results({
            @Result(column = "concern_id",property = "concernId"),
            @Result(column = "user_id",property = "userId"),
            @Result(column = "fans_id",property = "fansId")
    })
    List<Concern> getAllFollowingsByUserId(String fansId);

    @Select("select * from concern where user_id=#{userId}")
    @Results({
            @Result(column = "concern_id",property = "concernId"),
            @Result(column = "user_id",property = "userId"),
            @Result(column = "fans_id",property = "fansId")
    })
    List<Concern> getAllFansByUserId(String userId);

}
