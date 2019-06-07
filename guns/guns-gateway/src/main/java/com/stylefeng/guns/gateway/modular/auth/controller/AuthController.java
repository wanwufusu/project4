package com.stylefeng.guns.gateway.modular.auth.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.core.exception.GunsException;
import com.stylefeng.guns.gateway.common.exception.BizExceptionEnum;
import com.stylefeng.guns.gateway.modular.auth.controller.dto.AuthResponse;
import com.stylefeng.guns.gateway.modular.auth.util.JwtTokenUtil;
import com.stylefeng.guns.user.entity.MtimeUserT;
import com.stylefeng.guns.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Reference(check = false)
    private UserService service;

    @RequestMapping(value = "${jwt.auth-path}")
    public ResponseEntity<?> createAuthenticationToken(MtimeUserT user) {

        boolean validate = service.validate(user);

        if (validate) {
            final String randomKey = jwtTokenUtil.getRandomKey();
            final String token = jwtTokenUtil.generateToken(user.getUserName(), randomKey);
            return ResponseEntity.ok(new AuthResponse(token, randomKey));
        } else {
            throw new GunsException(BizExceptionEnum.AUTH_REQUEST_ERROR);
        }
    }
}
