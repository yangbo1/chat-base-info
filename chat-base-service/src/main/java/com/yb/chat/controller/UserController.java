/**
 * Copyright (c) 2014-2018  墨博云舟 All Rights Reserved.
 */
package com.yb.chat.controller;

import com.github.pagehelper.PageInfo;
import com.yb.chat.client.base.UserBase;
import com.yb.chat.client.base.UserBaseInfo;
import com.yb.chat.client.UserServiceClient;
import com.yb.chat.client.response.ChatResult;
import com.yb.chat.client.response.CountUserResp;
import com.yb.chat.client.response.LogResp;
import com.yb.chat.entity.ChatMessage;
import com.yb.chat.entity.LogInfo;
import com.yb.chat.entity.UserInfo;
import com.yb.chat.serivce.UserService;
import com.yb.chat.server.ChatServer;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        boolean register = userService.register(name, password, img);
        return ChatResult.setContent(register);
    }

    /**
     * 登陆
     * @param name 用户名
     * @param password 密码
     * @return
     */
    @Override
    public ChatResult login(String name, String password, String system, String address) {
        UserInfo user = userService.login(name, password, system, address);
        if (user != null) {
//            request.getSession().setAttribute(name, name);
            ChatServer.userInfoMap.put(name, user);
        }
        return ChatResult.setContent(user!=null);
    }
    /**
     * 查询好友
     * @param id
     * @return
     */
    @Override
    public List<UserBase> findFriends(@PathVariable("id") String id) {
        return userService.friends(id);
    }
    /**
     * 查询好友
     * @param self 自己
     * @param online 在线的
     * @return
     */
    @Override
    public List<UserBase> findFriends( String[] online, String self) {

        return userService.friends(self, online);
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
        return userService.findChatMessage(userA, userB, pageIndex);
    }
    /**
     * 查询用户详细信息
     * @param user
     *
     * @return
     */
    @Override
    public UserBaseInfo findInfo(@PathVariable("user") String user) {
        return userService.findInfo(user);
    }
    /**
     * 修改个人信息
     * @param userBaseInfo
     *
     * @return
     */
    @Override
    public String editInfo(@RequestBody UserBaseInfo userBaseInfo) {
        return userService.editInfo(userBaseInfo);
    }

    @Override
    public List online() {
        return ChatServer.list;
    }
    /**
     * 查询所有用户
     * @return
     */
    @Override
    public PageInfo<UserInfo> allUser(@RequestParam("currentPage")int currentPage, @RequestParam("pageSize") int pageSize) {
        return userService.findAll(currentPage, pageSize);
    }
    /**
     * 查询最后登录时间
     * @param name 用户名
     *
     * @return
     */
    @Override
    public Long lastLoginTime(@PathVariable("name")String name) {
        return userService.getLastLoginTime(name);
    }
    /**
     * 查询登录日志
     * @param name
     *
     * @return
     */
    @Override
    public PageInfo<LogResp> log(@RequestParam("name")String name, @RequestParam("currentPage")int currentPage,
            @RequestParam("pageSize") int pageSize, @RequestParam("sort") String sort) {
        return userService.findLog(name, currentPage, pageSize, sort);
    }

    @Override
    public List<String> getUserName() {

        return userService.getUserName();
    }
    /**
     * 统计每天在线人数
     * @return
     */
    @Override
    public List<CountUserResp> getCountUserByDay() {
        return userService.getCountUserByDay();
    }
    /**
     * 统计每天登录人次
     * @return
     */
    @Override
    public List<CountUserResp> getCountTimesByDay() {
        return userService.getCountTimesByDay();
    }

}
