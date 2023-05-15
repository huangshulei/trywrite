package com.example.trywrite.Controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.trywrite.Service.EmployeeService;
import com.example.trywrite.common.R;
import com.example.trywrite.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/employee")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping("/login")
    private R<Employee> login(@RequestBody Employee employee, HttpServletRequest httpServletRequest){
        String password=employee.getPassword();
        LambdaQueryWrapper<Employee> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(Employee::getUsername,employee.getUsername());
        Employee emp= employeeService.getOne(wrapper);
        if (emp==null){
            return R.error("用户不存在");
        }
        if (!emp.getPassword().equals(password)){
            return R.error("密码错误");
        }else {
            httpServletRequest.getSession().setAttribute("employee",emp.getId());
            return R.success(emp);
        }
    }

    @PostMapping("/save")
    public R<String> save(@RequestBody Employee employee,HttpServletRequest httpServletRequest){
        employeeService.save(employee);
        return R.success("添加成功");
    }

    @PostMapping("/logout")
    public R<String> logout(HttpServletRequest httpServletRequest){
        httpServletRequest.getSession().removeAttribute("employee");
        return R.success("退出成功");
    }

    @GetMapping("/{id}")
    public R<Employee> getEmployeebyid(@PathVariable long id){
        Employee emp=employeeService.getById(id);
        if (emp==null){
            return R.success(emp);
        }else {
            return R.error("没有找到该员工");
        }
    }


    @GetMapping("/page")
    public R<Page> page(int page,int pageSize,String name){
        Page pageInfo = new Page(page,pageSize);
        LambdaQueryWrapper<Employee> queryWrapper=new LambdaQueryWrapper();
        queryWrapper.like(StringUtils.isNotEmpty(name),Employee::getName,name);
        queryWrapper.orderByAsc(Employee::getUpdateTime);
        employeeService.page(pageInfo,queryWrapper);
        return R.success(pageInfo);
    }




}
