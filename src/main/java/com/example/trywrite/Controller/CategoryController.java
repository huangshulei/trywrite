package com.example.trywrite.Controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.trywrite.Service.CategoryService;
import com.example.trywrite.common.R;
import com.example.trywrite.entity.Category;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author LJM
 * @create 2022/4/16
 * 分类管理
 */
@RestController
@RequestMapping("/category")
@Slf4j
public class CategoryController {


    @Autowired
    private CategoryService categoryService;


    @PostMapping
    private R<String> save(@RequestBody Category category) {
        categoryService.save(category);
        return R.success("新增成功");
    }


    @GetMapping("/page")
    private R<Page> page(int page, int pageSize) {
        Page<Category> categoryPage = new Page<>(page,pageSize);
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.orderByAsc(Category::getSort);
        categoryService.page(categoryPage,queryWrapper);
        return R.success(categoryPage);
    }

    @DeleteMapping
    public R<String> delete(@RequestParam("ids") long id){
        categoryService.removeById(id);
        return R.success("删除成功");
    }

    /**
     * 根据条件查询分类数据
     * @param category
     * @return
     */
    @GetMapping("/list")
    //这个接口接收到参数其实就是一个前端传过来的type,这里之所以使用Category这个类来接受前端的数据，是为了以后方便
    //因为这个Category类里面包含了type这个数据,返回的数据多了，你自己用啥取啥就行
    private R<List<Category>> list(Category category){
        //条件构造器
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper();
        //添加查询条件
        queryWrapper.eq(category.getType() != null,Category::getType,category.getType());
        //添加排序条件  使用两个排序条件,如果sort相同的情况下就使用更新时间进行排序
        queryWrapper.orderByAsc(Category::getSort).orderByDesc(Category::getUpdateTime);
        List<Category> list = categoryService.list(queryWrapper);
        return R.success(list);
    }



}
