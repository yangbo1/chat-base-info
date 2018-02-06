package com.yb.chat.client; /**
 * Copyright (c) 2014-2018  墨博云舟 All Rights Reserved.
 */

import com.yb.chat.client.response.ChatResult;
import com.yb.chat.client.response.UserResp;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.servlet.http.HttpSession;

import static com.yb.chat.client.UserServiceClient.PATH;

/**
 * com.yb.chat.client.UserServiceClient:
 *
 * @author yangbo
 * @version 1.00
 * @since 2018/1/24 0024 17:55
 */
@FeignClient(path = PATH)
public interface UserServiceClient {
    String PATH = "service/v1/user";
    /**
     * 注册
     * @param name 用户名
     * @param password 密码
     * @param img 头像
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @CrossOrigin("*")
    Object register(@RequestParam("name") String name, @RequestParam("password") String password,
                      @RequestParam("img") String img);

    /**
     * 登陆
     * @param name 用户名
     * @param password 密码
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @CrossOrigin("*")
    Object login(HttpSession session,@RequestParam("name") String name, @RequestParam("password") String password);
}
