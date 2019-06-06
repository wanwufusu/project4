package com.stylefeng.guns.gateway.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.user.entity.MtimeUserT;
import com.stylefeng.guns.user.entity.UserVO;
import com.stylefeng.guns.user.service.UserService;


@RestController
@RequestMapping("user")
public class UserController {

    @Reference(check = false)
    UserService service;

    @RequestMapping("register")
    public UserVO register(MtimeUserT user){
        Integer i = service.register(user);
        if (i==1){
            return new UserVO(0,"注册成功",null);
        }else if (i==0){
            return new UserVO(1,"用户已存在",null);
        }else {
            return new UserVO(999,"系统出现异常，请联系管理员",null);
        }
    }
}
