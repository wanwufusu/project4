package com.stylefeng.guns.user.service;

import com.stylefeng.guns.core.exception.GunsException;
import com.stylefeng.guns.user.entity.MtimeUserT;
import com.stylefeng.guns.user.entity.UserVO;

public interface UserService {

    UserVO register(MtimeUserT user) throws GunsException;

    UserVO checkUserName(String username) throws GunsException;

    Boolean isUserName(String username);

    Boolean validate(MtimeUserT user);

    void tokenBuffer(String userName, String token);

    Boolean isValidate(String userName, String token);

    UserVO logout(String userName) throws GunsException;

    UserVO getUserInfo(String username) throws GunsException;

    UserVO updateUserInfo(MtimeUserT user) throws GunsException;
}
