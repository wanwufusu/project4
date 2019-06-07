package com.stylefeng.guns.user.modular.auth.controller;

import com.stylefeng.guns.core.exception.GunsException;
import com.stylefeng.guns.user.common.exception.BizExceptionEnum;
import com.stylefeng.guns.user.modular.auth.controller.dto.AuthRequest;
import com.stylefeng.guns.user.modular.auth.controller.dto.AuthResponse;
import com.stylefeng.guns.user.modular.auth.util.JwtTokenUtil;
import com.stylefeng.guns.user.modular.auth.validator.IReqValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 请求验证的
 */
@RestController
public class AuthController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Resource(name = "simpleValidator")
    private IReqValidator reqValidator;

    @RequestMapping(value = "${jwt.auth-path}")
    public ResponseEntity<?> createAuthenticationToken(AuthRequest authRequest) {

        //AuthRequest是包装好的用户名密码
        //reqValidator.validate是要自己去写的验证账户名密码，返回
        boolean validate = reqValidator.validate(authRequest);

        if (validate) {
            //产生随机的randomkey，后续作为盐值，减少被撞库的可能
            final String randomKey = jwtTokenUtil.getRandomKey();

            /**
             * 1.用产生随机的randomkey和yml里的md5-key生成随机字符串
             * 2.
             * Jwts.builder()   //建造者模式
             * .setClaims(claims)   //随机字符串的Map用来混淆
             * .setSubject(subject)     //用户名
             * .setIssuedAt(createdDate)    //token办法时间
             * .setExpiration(expirationDate)   //过期时间
             * .signWith(SignatureAlgorithm.HS512, jwtProperties.getSecret())   //用yml的jwt密钥来签名
             * .compact();
             */
            final String token = jwtTokenUtil.generateToken(authRequest.getUserName(), randomKey);
            //ok是构建一个200，带内部信息的返回结果（randomkey，token）
            return ResponseEntity.ok(new AuthResponse(token, randomKey));
        } else {
            throw new GunsException(BizExceptionEnum.AUTH_REQUEST_ERROR);
            //validate返回false时通过异常处理返回用户账户名或密码错误
        }
    }
}
