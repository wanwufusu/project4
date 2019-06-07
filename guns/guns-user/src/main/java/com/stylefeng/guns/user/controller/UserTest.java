package com.stylefeng.guns.user.controller;

import com.stylefeng.guns.core.exception.GunsException;
import com.stylefeng.guns.user.common.exception.UserExceptionEnum;
import com.stylefeng.guns.user.entity.MtimeUserT;
import com.stylefeng.guns.user.entity.UserVO;
import com.stylefeng.guns.user.service.UserService;
import com.stylefeng.guns.user.utils.JedisAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserTest {

    @Autowired
    UserService service;
    @Autowired
    JedisAdapter jedisAdapter;

    @RequestMapping("register")
    public UserVO register(MtimeUserT user) throws Exception {
        service.register(user);
        return new UserVO(0,"注册成功",null);
    }

    @RequestMapping("test")
    public String test(){

        return null;
    }

}
