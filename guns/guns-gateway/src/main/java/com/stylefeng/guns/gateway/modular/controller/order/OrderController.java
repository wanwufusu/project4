package com.stylefeng.guns.gateway.modular.controller.order;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.gateway.modular.auth.util.JwtTokenUtil;
import com.stylefeng.guns.order.common.persistence.model.MoocOrder;
import com.stylefeng.guns.order.common.persistence.model.OrderResponseVO;
import com.stylefeng.guns.order.common.persistence.service.OrderService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/6/11
 * @since 1.0.0
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Reference(check = false)
    OrderService orderService;

    @RequestMapping("getOrderInfo")
    public OrderResponseVO<List<MoocOrder>> getOrderInfo(int nowPage, int pageSize, String token){
        //Claims claimFromToken = jwtTokenUtil.getClaimFromToken(token);
        //String tokenSubject = claimFromToken.getSubject();
        String username = "admin";

        OrderResponseVO<List<MoocOrder>> orderInfo = orderService.getOrderInfo(nowPage, pageSize, username);
        return orderInfo;
    }

}
