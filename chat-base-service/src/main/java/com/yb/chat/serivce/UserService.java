/**
 * Copyright (c) 2014-2018  墨博云舟 All Rights Reserved.
 */
package com.yb.chat.serivce;

import com.yb.chat.base.UserBase;
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
}
