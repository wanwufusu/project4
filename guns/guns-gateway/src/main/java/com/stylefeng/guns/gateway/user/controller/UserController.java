package com.stylefeng.guns.gateway.user.controller;

import com.stylefeng.guns.core.exception.GunsException;
import com.stylefeng.guns.gateway.config.properties.JwtProperties;
import com.stylefeng.guns.gateway.modular.auth.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.user.entity.MtimeUserT;
import com.stylefeng.guns.user.entity.UserVO;
import com.stylefeng.guns.user.service.UserService;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("user")
public class UserController {

    @Reference(check = false)
    UserService service;
    @Autowired
    private JwtProperties jwtProperties;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

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

    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public  UserVO logout(HttpServletRequest request)throws GunsException{
        String requestHeader = request.getHeader(jwtProperties.getHeader());
        String token = requestHeader.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        UserVO vo = service.logout(username);
        return vo;
    }

    @RequestMapping(value = "getUserInfo",method = RequestMethod.GET)
    public UserVO getInfo(HttpServletRequest request)throws GunsException{
        String requestHeader = request.getHeader(jwtProperties.getHeader());
        String token = requestHeader.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        UserVO vo = service.getUserInfo(username);
        return vo;
    }

    @RequestMapping(value = "updateUserInfo",method = RequestMethod.POST)
    public UserVO updateUserInfo(MtimeUserT user)throws GunsException{
        UserVO vo = service.updateUserInfo(user);
        return vo;
    }
}
