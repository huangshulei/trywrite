package com.example.trywrite.Mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.trywrite.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
