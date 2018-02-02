/**
 * Copyright (c) 2014-2018  墨博云舟 All Rights Reserved.
 */
package com.yb.chat.serivce;

import com.yb.chat.client.response.UserResp;

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
     */
    void regist(String name, String password);
}
