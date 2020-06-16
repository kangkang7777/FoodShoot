package com.project.foodshoot.mapper;

import com.project.foodshoot.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    @Insert("insert into user(email,password) values(#{email},#{password})")
    boolean insertUser(String email,String password);

    @Select("select * from user where email=#{email} and password=#{password}")
    @Result(column = "user_id",property = "userId")
    User getUserByEmailAndPassword(String email, String password);

    @Select("select * from user where email=#{email}")
    @Result(column = "user_id",property = "userId")
    User getUserByEmail(String email);

    @Select("select * from user where user_id=#{userId}")
    @Result(column = "user_id",property = "userId")
    User getUserByUserId(String userId);

    @Update("update user set name=#{name},age=#{age} where email=#{email}")
    boolean updateInformation(String email,String name,String age);

    @Update("update user set password=#{password} where email=#{email}")
    boolean updatePassword(String email,String password);

}
