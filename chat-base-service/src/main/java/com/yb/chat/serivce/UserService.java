/**
 * Copyright (c) 2014-2018  墨博云舟 All Rights Reserved.
 */
package com.yb.chat.serivce;

import com.yb.chat.entity.UserInfo;
import com.yb.common.entity.UserBase;

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
}
