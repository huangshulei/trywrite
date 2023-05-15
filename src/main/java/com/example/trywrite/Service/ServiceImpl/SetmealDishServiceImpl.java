package com.example.trywrite.Service.ServiceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.trywrite.Mapper.SetmealDishMapper;
import com.example.trywrite.Service.SetmealDishService;
import com.example.trywrite.entity.SetmealDish;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author LJM
 * @create 2022/4/17
 */
@Service
@Slf4j
public class SetmealDishServiceImpl extends ServiceImpl<SetmealDishMapper, SetmealDish> implements SetmealDishService {
}
