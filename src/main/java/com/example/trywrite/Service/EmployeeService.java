package com.example.trywrite.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.trywrite.Mapper.EmployeeMapper;
import com.example.trywrite.entity.Employee;

public interface EmployeeService extends IService<Employee> {

    public Employee getByuserName();
}
