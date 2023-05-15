package com.example.trywrite.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.trywrite.entity.Category;

public interface CategoryService extends IService<Category> {


    void remove(long id);
}
