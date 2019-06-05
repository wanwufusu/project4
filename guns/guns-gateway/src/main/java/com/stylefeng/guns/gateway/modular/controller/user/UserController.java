package com.stylefeng.guns.film.modular.controller.user;


import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.film.common.persistence.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Reference
    UserService service;

    @RequestMapping("test")
    public String test(){
        return service.test();
    }

}
