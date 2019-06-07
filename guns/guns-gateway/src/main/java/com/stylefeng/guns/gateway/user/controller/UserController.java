package com.stylefeng.guns.gateway.user.controller;

import com.stylefeng.guns.core.exception.GunsException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "register",method = RequestMethod.POST)
    public UserVO register(MtimeUserT user) throws GunsException {
        UserVO vo = service.register(user);
        return vo;
    }

    @RequestMapping(value = "check",method = RequestMethod.POST)
    public UserVO check(String username) throws GunsException {
        UserVO vo = service.checkUserName(username);
        return vo;
    }
}
