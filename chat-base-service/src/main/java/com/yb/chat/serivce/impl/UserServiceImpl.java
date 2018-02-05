/**
 * Copyright (c) 2014-2018  墨博云舟 All Rights Reserved.
 */
package com.yb.chat.serivce.impl;

import com.yb.chat.dao.UserInfoMapper;
import com.yb.chat.dao.UserMapper;
import com.yb.chat.entity.UserEntity;
import com.yb.chat.entity.UserInfo;
import com.yb.chat.serivce.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * UserServiceImpl:
 *
 * @author yangbo
 * @version 1.00
 * @since 2018/1/29 0029 15:06
 */
@Service("userService")
public class UserServiceImpl implements UserService{
    /**
     * user
     */
    @Autowired
    private UserInfoMapper mapper;
    /**
     * 注册
     * @param name 用户名
     * @param password 密码
     * @param img 头像
     */
    @Override
    public void register(String name, String password, String img) {
        UserInfo userInfo = new UserInfo();
        userInfo.setName(name);
        userInfo.setPassword(password);
        userInfo.setImg(img);
        userInfo.setRegistTime(System.currentTimeMillis());
        mapper.insert(userInfo);
    }
    /**
     * 登陆
     * @param name 用户名
     * @param password 密码
     * @return
     */
    @Override
    public Boolean login(String name, String password) {
        Example example = new Example(UserInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("name", name);
        criteria.andEqualTo("password", password);
        List<UserInfo> userInfos = mapper.selectByExample(example);
        if (!userInfos.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
