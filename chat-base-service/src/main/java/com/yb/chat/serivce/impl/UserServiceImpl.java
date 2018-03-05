/**
 * Copyright (c) 2014-2018  墨博云舟 All Rights Reserved.
 */
package com.yb.chat.serivce.impl;

import com.yb.chat.base.UserBase;
import com.yb.chat.convert.ChatConvert;
import com.yb.chat.dao.ChatMessageMapper;
import com.yb.chat.dao.LogInfoMapper;
import com.yb.chat.dao.UserInfoMapper;
import com.yb.chat.entity.ChatMessage;
import com.yb.chat.entity.LogInfo;
import com.yb.chat.entity.UserInfo;
import com.yb.chat.serivce.UserService;
import com.yb.common.contants.ChatContants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tk.mybatis.mapper.entity.Example;

import java.util.Arrays;
import java.util.List;

/**
 * UserServiceImpl:
 *
 * @author yangbo
 * @version 1.00
 * @since 2018/1/29 0029 15:06
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
    /**
     * user
     */
    @Autowired
    private UserInfoMapper mapper;
    /**
     * 操作记录
     */
    @Autowired
    private LogInfoMapper logInfoMapper;

    /**
     * 聊天记录
     */
    @Autowired
    private ChatMessageMapper chatMessageMapper;
    /**
     * 注册
     * @param name 用户名
     * @param password 密码
     * @param img 头像
     */
    @Override
    public boolean register(String name, String password, String img) {
        Example example = new Example(UserInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("name", name);
        List<UserInfo> userInfos = mapper.selectByExample(example);
        if (userInfos.isEmpty()) {
            UserInfo userInfo = new UserInfo();
            userInfo.setName(name);
            userInfo.setPassword(password);
            userInfo.setImg(img);
            userInfo.setRegistTime(System.currentTimeMillis());
            mapper.insert(userInfo);
            return true;
        } else {
            return false;
        }
    }
    /**
     * 登陆
     * @param name 用户名
     * @param password 密码
     * @return
     */
    @Override
    public UserInfo login(String name, String password) {
        Example example = new Example(UserInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("name", name);
        criteria.andEqualTo("password", password);
        List<UserInfo> userInfos = mapper.selectByExample(example);
        if (!userInfos.isEmpty()) {
            login(name);
            return userInfos.get(0);
        } else {
            return null;
        }
    }
    /**
     * 查询好友
     * @param id id
     *
     * @return 好友列表
     */
    @Override
    public List<UserBase> friends(String id) {
        System.out.println(id);
        List<UserBase> friends = mapper.findFriendsById(id);
        return friends;
    }
    /**
     * 查询好友
     * @param self 自己
     * @param online 在线的
     * @return
     */
    @Override
    public List<UserBase> friends(String self, String[] online) {
        Example example = new Example(UserInfo.class);
        Example.Criteria criteria = example.createCriteria();
        if (online == null) {
            return null;
        }
//        criteria.andIn("name", Arrays.asList(online));
        criteria.andNotEqualTo("name", self);
        List<UserInfo> userInfos = mapper.selectByExample(example);
        return ChatConvert.convertUserListToResp(userInfos);
    }
    /**
     * 登陆记录
     * @param name 用户名
     */
    @Override
    public void login(String name) {
        UserInfo userInfo = findSelf(name);
        LogInfo logInfo;
        if (userInfo != null) {
            logInfo = new LogInfo();
            logInfo.setUserId(userInfo.getId());
            logInfo.setUserName(userInfo.getName());
            logInfo.setType(ChatContants.LOG_LOGIN);
            logInfo.setTime(System.currentTimeMillis());
            logInfoMapper.insert(logInfo);
        }
    }
    /**
     * 登出记录
     * @param name
     */
    @Override
    public void logout(String name) {
        UserInfo userInfo = findSelf(name);
        LogInfo logInfo;
        if (userInfo != null) {
            logInfo = new LogInfo();
            logInfo.setUserId(userInfo.getId());
            logInfo.setUserName(userInfo.getName());
            logInfo.setType(ChatContants.LOG_LOGOUT);
            logInfo.setTime(System.currentTimeMillis());
            logInfoMapper.insert(logInfo);
        }
    }

    @Override
    public UserInfo findSelf(String name) {
        Example example = new Example(UserInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("name", name);
        List<UserInfo> userInfos = mapper.selectByExample(example);
        if (!userInfos.isEmpty()) {
            return userInfos.get(0);
        }else {
            return null;
        }
    }
    /**保存聊天记录
     * @param message
     */
    @Override
    public void saveChatMessage(ChatMessage message) {
        if (message != null) {
            chatMessageMapper.insert(message);
        }
    }
    /**
     * 查询聊天记录
     * @param userA
     * @param userB
     * @param pageIndex 分页
     *
     * @return
     */
    @Override
    public List<ChatMessage> findChatMessage(String userA, String userB, Integer pageIndex) {
        return mapper.findChatMessage(userA, userB);
    }
}
