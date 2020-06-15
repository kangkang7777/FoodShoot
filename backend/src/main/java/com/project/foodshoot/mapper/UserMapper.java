package com.project.foodshoot.mapper;

import com.project.foodshoot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    @Select("select * from user where email=#{email} and password=#{password}")
    User getUserByEmailAndPassword(String email, String password);
}
