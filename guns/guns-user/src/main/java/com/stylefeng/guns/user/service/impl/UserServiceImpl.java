package com.stylefeng.guns.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.core.exception.GunsException;
import com.stylefeng.guns.core.util.MD5Util;
import com.stylefeng.guns.user.common.exception.UserExceptionEnum;
import com.stylefeng.guns.user.entity.UserVO;
import com.stylefeng.guns.user.utils.JedisAdapter;
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

    @Autowired
    JedisAdapter jedispool;

    @Override
    public UserVO register(MtimeUserT user) throws GunsException {
        try {
            if (isUserName(user.getUsername())) {
                throw new GunsException(UserExceptionEnum.USER_OCCUPIED_ERROR);
            }
            user.setPassword(MD5Util.encrypt(user.getPassword()));
            mapper.insertAllColumn(user);
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

    /**
     * 登录时与SQL验证账户名与密码
     * @return
     */
    @Override
    public Boolean validate(String username,String password) {
        List<MtimeUserT> userExist = mapper.selectList(new EntityWrapper<MtimeUserT>().eq("user_name", username));
        if (userExist.size()==0){
            return false;
        }
        if (MD5Util.encrypt(password)!=userExist.get(0).getPassword()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void tokenBuffer(String userName, String token) {
        int time = 1200;
        jedispool.setex(userName,time,token);
    }

    @Override
    public Boolean isValidate(String userName, String token) {
        String ofToken = jedispool.get(userName);
        if (token.equals(ofToken)){
            return true;
        }
        return false;
    }

    @Override
    public UserVO logout(String userName)  throws GunsException{
        String s = jedispool.get(userName);
        if (null==s){
            throw new GunsException(UserExceptionEnum.LOGOUT_FAIL);
        }
        Long i = jedispool.del(userName);
        if (i==1){
            return new UserVO(0, "成功退出", null);
        }else {
            throw new GunsException(UserExceptionEnum.USER_SYSTEM_ERROR);
        }
    }

    @Override
    public UserVO getUserInfo(String userName)  throws GunsException{
        String s = jedispool.get(userName);
        if (null==s){
            throw new GunsException(UserExceptionEnum.LOGOUT_FAIL);
        }
        try {
            List<MtimeUserT> userExist = mapper.selectList(new EntityWrapper<MtimeUserT>().eq("user_name", userName));
            return new UserVO(0, null, userExist.get(0));
        }catch (Exception e){
            throw new GunsException(UserExceptionEnum.USER_SYSTEM_ERROR);
        }
    }

    @Override
    public UserVO updateUserInfo(MtimeUserT user) throws GunsException {
        try {
            Integer i = mapper.updateById(user);
            if (i != 1) {
                throw new GunsException(UserExceptionEnum.USER_INFO_UPDATE_ERROR);
            }
            MtimeUserT newUser = mapper.selectOne(user);
            return new UserVO(0, null, newUser);
        }catch (GunsException e){
            throw e;
        }
        catch (Exception e){
            throw new GunsException(UserExceptionEnum.USER_SYSTEM_ERROR);
        }
    }
}
