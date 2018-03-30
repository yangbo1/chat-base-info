/**
 * Copyright (c) 2014-2018  墨博云舟 All Rights Reserved.
 */
package com.yb.chat.serivce;

import com.github.pagehelper.PageInfo;
import com.yb.chat.client.base.UserBase;
import com.yb.chat.client.base.UserBaseInfo;
import com.yb.chat.client.response.CountUserResp;
import com.yb.chat.client.response.LogResp;
import com.yb.chat.entity.ChatMessage;
import com.yb.chat.entity.UserInfo;

import java.util.List;

/**
 * UserService:
 *
 * @author yangbo
 * @version 1.00
 * @since 2018/1/29 0029 15:06
 */
public interface UserService {
    /**
     * 注册
     * @param name 用户名
     * @param password 密码
     * @param img 头像
     */
    boolean register(String name, String password, String img);

    /**
     * 登陆
     * @param name 用户名
     * @param password 密码
     * @return
     */
    UserInfo login(String name, String password);

    /**
     * 查询好友
     * @param id id
     *
     * @return 好友列表
     */
    List<UserBase> friends(String id);
    /**
     * 查询好友
     * @param self 自己
     * @param online 在线的
     * @return
     */
    List<UserBase> friends(String self, String[] online);

    /**
     * 登陆记录
     * @param name 用户名
     */
    void login(String name);

    /**
     * 登出记录
     * @param name
     */
    void logout(String name);
    /**
     * 查询信息
     * @param name 用户名
     *
     * @return
     */
    UserInfo findSelf(String name);

    /**保存聊天记录
     * @param message
     */
    void saveChatMessage(ChatMessage message);
    /**
     * 查询聊天记录
     * @param userA
     * @param userB
     * @param pageIndex 分页
     *
     * @return
     */
    List<ChatMessage> findChatMessage(String userA, String userB, Integer pageIndex);
    /**
     * 查询用户详细信息
     * @param user
     *
     * @return
     */
    UserBaseInfo findInfo(String user);
    /**
     * 修改个人信息
     * @param userBaseInfo
     *
     * @return
     */
    String editInfo(UserBaseInfo userBaseInfo);

    /**
     * 查询好友
     * @param name name
     *
     * @return 好友列表
     */
    List<UserInfo> friendsByName(String name);
    /**
     * 查询所有用户
     * @return
     * @param currentPage
     * @param pageSize
     */
    PageInfo<UserInfo> findAll(int currentPage, int pageSize);
    /**
     * 查询最后登录时间
     * @param name 用户名
     *
     * @return
     */
    Long getLastLoginTime(String name);
    /**
     * 查询登录日志
     * @param name
     *
     * @param sort
     * @param currentPage
     * @param pageSize @return
     */
    PageInfo<LogResp> findLog(String name, int currentPage, int pageSize, String sort );

    List<String> getUserName();
    /**
     * 统计每天在线人数
     * @return
     */
    List<CountUserResp> getCountUserByDay();
    /**
     * 统计每天登录人次
     * @return
     */
    List<CountUserResp> getCountTimesByDay();
}
