package com.example.trywrite.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.trywrite.entity.Category;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
}
