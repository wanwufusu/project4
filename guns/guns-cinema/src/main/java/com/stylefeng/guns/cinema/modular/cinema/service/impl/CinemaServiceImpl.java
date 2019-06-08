package com.stylefeng.guns.cinema.modular.cinema.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.cinema.common.persistence.dao.MtimeCinemaTMapper;
import com.stylefeng.guns.cinema.common.persistence.dao.MtimeFieldTMapper;
import com.stylefeng.guns.cinema.common.persistence.dao.MtimeHallFilmInfoTMapper;
import com.stylefeng.guns.cinema.common.persistence.model.*;
import com.stylefeng.guns.cinema.common.persistence.service.CinemaService;
import com.stylefeng.guns.core.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Service(interfaceClass = CinemaService.class)
public class CinemaServiceImpl implements CinemaService {
    @Autowired
    MtimeCinemaTMapper mtimeCinemaTMapper;
    @Autowired
    MtimeHallFilmInfoTMapper mtimeHallFilmInfoTMapper;
    @Autowired
    MtimeFieldTMapper mtimeFieldTMapper;
    @Override
    public ResponseVo getFiled(String cinemaId) {
        ResponseVo responseVo = new ResponseVo();
        MtimeCinemaT cinemaInfo;
        List<MtimeHallFilmInfoT> filmList;
        boolean flag = false;
        Integer i = null;
        try {
            i = Integer.parseInt(cinemaId);
        }catch (NumberFormatException e){
            flag = true;
        }
        if (flag){
            responseVo.setStatus(0);
            return responseVo;
        }
        Data data = new Data();
        filmList = mtimeHallFilmInfoTMapper.findByCinemaId(cinemaId);
        cinemaInfo = mtimeCinemaTMapper.findByCinemaId(cinemaId);
        if(cinemaInfo == null || filmList == null){
            throw new ServiceException(1,"影院信息查询失败");
        }
        data.setFilmList(filmList);
        data.setCinemaInfo(cinemaInfo);
        responseVo.setData(data);
        responseVo.setStatus(0);
        responseVo.setImgPre("http://img.meetingshop.cn/");
        return responseVo;
    }

    @Override
    public ResponseVo getFiledInfo(String cinemaId, String fieldId) {
        ResponseVo responseVo = new ResponseVo();
        try{
            int cid = Integer.parseInt(cinemaId);
            int fid = Integer.parseInt(fieldId);
        }catch (NumberFormatException e){
            responseVo.setStatus(0);
            return responseVo;
        }
        Data data = new Data();
        data = mtimeFieldTMapper.findByCinemaIdAndFieldId(cinemaId,fieldId);
        if(data == null){
            throw new ServiceException(1,"影院信息查询失败");
        }
        MtimeHallDictT hallDictT = data.getHallInfo();
        hallDictT.setSoldSeats("1,2,3,5,12");
        responseVo.setData(data);
        responseVo.setStatus(0);
        responseVo.setImgPre("http://img.meetingshop.cn/");
        return responseVo;
    }
}
