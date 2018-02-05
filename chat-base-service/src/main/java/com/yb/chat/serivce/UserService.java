/**
 * Copyright (c) 2014-2018  墨博云舟 All Rights Reserved.
 */
package com.yb.chat.serivce;

import com.yb.chat.entity.UserInfo;

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
    void register(String name, String password, String img);

    /**
     * 登陆
     * @param name 用户名
     * @param password 密码
     * @return
     */
    Boolean login(String name, String password);
}
