package com.project.foodshoot.mapper;

import com.project.foodshoot.entity.Advertisement;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdvertisementMapper {
    @Select("select * from advertisement")
    @Results({
            @Result(column = "advertisement_id", property = "id"),
            @Result(column = "image", property = "imageUrl")
    })
    List<Advertisement> getAdvertisement();
}
