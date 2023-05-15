package com.example.trywrite.Service.ServiceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.trywrite.Mapper.DishFlavorMapper;
import com.example.trywrite.Service.DishFlavorService;
import com.example.trywrite.entity.DishFlavor;
import org.springframework.stereotype.Service;

/**
 * @author LJM
 * @create 2022/4/16
 */
@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor> implements DishFlavorService {
}
