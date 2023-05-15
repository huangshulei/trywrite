package com.example.trywrite.dto;


import com.example.trywrite.entity.Setmeal;
import com.example.trywrite.entity.SetmealDish;
import lombok.Data;

import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
