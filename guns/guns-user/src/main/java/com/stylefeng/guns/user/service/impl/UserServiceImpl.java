package com.stylefeng.guns.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stylefeng.guns.user.entity.MtimeUserT;
import com.stylefeng.guns.user.service.UserService;
import com.stylefeng.guns.user.dao.MtimeUserTMapper;

@Component
@Service(interfaceClass = UserService.class)
public class UserServiceImpl implements UserService {

    @Autowired
    MtimeUserTMapper mapper;

    @Override
    public Integer register(MtimeUserT user) {
       try {
        MtimeUserT one = mapper.selectOne(user);
           if ( one !=null) {
               return 0;
           } else {
               return mapper.insertAllColumn(user);
           }
       }catch (RuntimeException e){
           return -1;
       }
    }

}
