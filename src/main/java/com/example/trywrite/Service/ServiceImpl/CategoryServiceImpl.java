package com.example.trywrite.Service.ServiceImpl;



import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.trywrite.Mapper.CategoryMapper;
import com.example.trywrite.Mapper.SetmealMapper;
import com.example.trywrite.Service.CategoryService;
import com.example.trywrite.Service.DishService;
import com.example.trywrite.Service.SetmealService;
import com.example.trywrite.common.CustomException;
import com.example.trywrite.entity.Category;
import com.example.trywrite.entity.Dish;
import com.example.trywrite.entity.Setmeal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * @author LJM
 * @create 2022/4/16
 */
@Lazy
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {


    @Autowired
    private DishService dishService;

    @Autowired
    private SetmealService setmealService;

    @Autowired
    private SetmealMapper setmealMapper;

    @Override
    public void remove(long id) {
        LambdaQueryWrapper<Dish> queryWrapper=new LambdaQueryWrapper();
        queryWrapper.eq(Dish::getCategoryId,id);
        int count=dishService.count(queryWrapper);
        if (count>0){
            throw  new CustomException("");
        }
        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId,id);
        int setmealCount = setmealService.count(setmealLambdaQueryWrapper);
        if (setmealCount > 0){
            //已经关联了套餐，抛出一个业务异常
            throw new CustomException("当前分类项关联了套餐,不能删除");
        }
        setmealMapper.deleteById(id);
    }
}
