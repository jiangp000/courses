package com.example.week5.mapper;

import com.example.week5.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
public interface UserMapper {

    @Select("select * from user")
    public List<User> find();
}
