package com.example.trywrite.Service.ServiceImpl;


import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.trywrite.Mapper.UserMapper;
import com.example.trywrite.Service.UerService;
import com.example.trywrite.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UerService {


}
