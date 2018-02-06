/**
 * Copyright (c) 2014-2018  墨博云舟 All Rights Reserved.
 */
package com.yb.chat.controller;

import com.yb.chat.client.UserServiceClient;
import com.yb.chat.client.response.ChatResult;
import com.yb.chat.client.response.UserResp;
import com.yb.chat.serivce.UserService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import static com.yb.chat.client.UserServiceClient.PATH;

/**
 * UserController:
 *
 * @author yangbo
 * @version 1.00
 * @since 2018/1/24 0024 18:01
 */
@RestController
@RequestMapping(PATH)
public class UserController implements UserServiceClient {
    @Resource(name = "userService")
    private UserService userService;

    /**
     * 注册
     * @param name 用户名
     * @param password 密码
     * @param img 头像
     * @return
     */
    @Override
    public ChatResult register(@RequestParam("name") String name, @RequestParam("password") String password,
                             @RequestParam("img") String img) {
        userService.register(name, password, img);
        return ChatResult.setContent(null);
    }

    /**
     * 登陆
     * @param name 用户名
     * @param password 密码
     * @return
     */
    @Override
    public ChatResult login(HttpSession session, String name, String password) {
        Boolean login = userService.login(name, password);
        if (login) {
            session.setAttribute(name, name);
        }
        return ChatResult.setContent(login);
    }

}
