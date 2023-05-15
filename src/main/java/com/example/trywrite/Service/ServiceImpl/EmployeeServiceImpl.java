package com.example.trywrite.Service.ServiceImpl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.trywrite.Mapper.EmployeeMapper;
import com.example.trywrite.Service.EmployeeService;
import com.example.trywrite.entity.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
    @Override
    public Employee getByuserName() {

        return null;
    }
}
