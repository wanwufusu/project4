package com.stylefeng.guns.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.core.exception.GunsException;
import com.stylefeng.guns.user.common.exception.UserExceptionEnum;
import com.stylefeng.guns.user.entity.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stylefeng.guns.user.entity.MtimeUserT;
import com.stylefeng.guns.user.service.UserService;
import com.stylefeng.guns.user.dao.MtimeUserTMapper;

import java.util.List;

@Component
@Service(interfaceClass = UserService.class)
public class UserServiceImpl implements UserService {

    @Autowired
    MtimeUserTMapper mapper;

    @Override
    public UserVO register(MtimeUserT user) throws GunsException {
        try {
            if (isUserName(user.getUserName())) {
                throw new GunsException(UserExceptionEnum.USER_OCCUPIED_ERROR);
            }
            mapper.insert(user);
        } catch (GunsException e) {
            throw e;
        } catch (Exception e) {
            throw new GunsException(UserExceptionEnum.USER_SYSTEM_ERROR);
        }
        return new UserVO(0, "注册成功", null);
    }

    @Override
    public UserVO checkUserName(String username) throws GunsException {
        try {
            if (isUserName(username)) {
                throw new GunsException(UserExceptionEnum.USER_OCCUPIED_ERROR);
            }
        } catch (GunsException e) {
            throw e;
        } catch (Exception e) {
            throw new GunsException(UserExceptionEnum.USER_SYSTEM_ERROR);
        }
        return new UserVO(0, "验证成功", null);
    }

    @Override
    public Boolean isUserName(String username) {
        List<MtimeUserT> userExist = mapper.selectList(new EntityWrapper<MtimeUserT>().eq("user_name", username));
        if (userExist != null&userExist.size()!=0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean validate(MtimeUserT user) {
        MtimeUserT userExist = mapper.selectOne(user);
        if (userExist != null) {
            return true;
        } else {
            return false;
        }
    }
}
