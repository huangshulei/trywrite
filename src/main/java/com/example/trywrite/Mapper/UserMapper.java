package com.example.trywrite.Mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.trywrite.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
