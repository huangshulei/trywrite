package com.example.trywrite.Controller;



import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.trywrite.Service.UerService;
import com.example.trywrite.common.R;
import com.example.trywrite.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;



@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UerService uerService;

    @PostMapping("/login")
    public R<User> login(@RequestBody Map map, HttpSession httpSession){
        String phone=map.get("phone").toString();
        String code=map.get("code").toString();
        LambdaQueryWrapper<User> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(User::getPhone,phone);
        User user=uerService.getOne(wrapper);
        if (user==null){
            user=new User();
            user.setPhone(phone);
            uerService.save(user);
        }
        httpSession.setAttribute("user",user.getId());
        return R.success(user);
    }

    @PostMapping("/logout")
    public R<String> logout(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return R.success("退出成功");
    }



}
