package com.stylefeng.guns.gateway.modular.controller.cinema;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.cinema.common.persistence.model.ResponseVo;
import com.stylefeng.guns.cinema.common.persistence.service.CinemaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema")
public class CinemaController {
    @Reference
    CinemaService cinemaService;
    @RequestMapping("/getFileds")
    public ResponseVo getFileds(String cinemaId){
        ResponseVo responseVo = cinemaService.getFiled(cinemaId);
        return responseVo;
    }
    @RequestMapping("/getFieldInfo")
    public ResponseVo getFieldInfo(String cinemaId,String fieldId){
        ResponseVo responseVo=cinemaService.getFiledInfo(cinemaId,fieldId);
        return responseVo;
    }
}
