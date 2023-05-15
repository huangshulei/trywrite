package com.example.trywrite.dto;

import com.example.trywrite.entity.OrderDetail;
import com.example.trywrite.entity.Orders;
import lombok.Data;

import java.util.List;

/**
 * @author LJM
 * @create 2022/5/3
 */
@Data
public class OrderDto extends Orders {

   private List<OrderDetail> orderDetails;


}
