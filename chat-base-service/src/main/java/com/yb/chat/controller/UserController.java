/**
 * Copyright (c) 2014-2018  墨博云舟 All Rights Reserved.
 */
package com.yb.chat.controller;

import com.yb.chat.client.UserServiceClient;
import com.yb.chat.client.response.UserResp;
import com.yb.chat.serivce.UserService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.annotation.Resource;

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
    @Override
    public List<UserResp> hello(@PathVariable("name") String name) {
        return userService.findByName(name);
    }
}
