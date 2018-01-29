/**
 * Copyright (c) 2014-2018  墨博云舟 All Rights Reserved.
 */
package com.yb.chat.serivce.impl;

import com.yb.chat.client.response.UserResp;
import com.yb.chat.convert.ChatConvert;
import com.yb.chat.dao.UserMapper;
import com.yb.chat.entity.UserEntity;
import com.yb.chat.serivce.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import tk.mybatis.mapper.entity.Example;

/**
 * UserServiceImpl:
 *
 * @author yangbo
 * @version 1.00
 * @since 2018/1/29 0029 15:06
 */
@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper mapper;

    @Override
    public List<UserResp> findByName(String name) {
        Example example = new Example(UserEntity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("name", name);
        List<UserEntity> users = mapper.selectByExample(example);
        return ChatConvert.convertUserListToResp(users);
    }
}
