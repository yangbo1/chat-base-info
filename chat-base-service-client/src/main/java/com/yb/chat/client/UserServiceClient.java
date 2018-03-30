package com.yb.chat.client; /**
 * Copyright (c) 2014-2018  墨博云舟 All Rights Reserved.
 */

import com.github.pagehelper.PageInfo;
import com.yb.chat.client.base.UserBaseInfo;
import com.yb.chat.client.response.ChatResult;
import com.yb.chat.client.response.CountUserResp;
import com.yb.chat.client.response.LogResp;
import com.yb.chat.client.response.UserResp;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.yb.chat.client.UserServiceClient.PATH;

/**
 * com.yb.chat.client.UserServiceClient:
 *
 * @author yangbo
 * @version 1.00
 * @since 2018/1/24 0024 17:55
 */
@FeignClient(name = "base",path = PATH)
@CrossOrigin("*")
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
    Object register(@RequestParam("name") String name, @RequestParam("password") String password,
                      @RequestParam("img") String img);

    /**
     * 登陆
     * @param name 用户名
     * @param password 密码
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    Object login(@RequestParam("name") String name, @RequestParam("password") String password,
            @RequestParam("system") String system, @RequestParam("address") String address);


    /**
     * 查询好友
     * @param id
     * @return
     */
    @RequestMapping(value = "/findFriendsById/{id}", method = RequestMethod.GET)
    Object findFriends(@PathVariable("id") String id);

    /**
     * 查询好友
     * @param self 自己
     * @param online 在线的
     * @return
     */
    @RequestMapping(value = "/findFriendsByName", method = RequestMethod.POST)
    Object findFriends(@RequestParam("online") String[] online, @RequestParam("self") String self);

    /**
     * 查询聊天记录
     * @param userA
     * @param userB
     * @param pageIndex 分页
     *
     * @return
     */
    @RequestMapping(value = "/findChatMessage", method = RequestMethod.POST)
    Object findChatMessage(@RequestParam("userA") String userA, @RequestParam("userB") String userB,
            @RequestParam("pageIndex") Integer pageIndex);

    /**
     * 查询用户详细信息
     * @param user
     *
     * @return
     */
    @RequestMapping(value = "/findInfo/{user}", method = RequestMethod.GET)
    Object findInfo(@PathVariable("user") String user);

    /**
     * 修改个人信息
     * @param userBaseInfo
     *
     * @return
     */
    @RequestMapping(value = "/editInfo", method = RequestMethod.POST)
    Object editInfo(@RequestBody UserBaseInfo userBaseInfo);

    /**
     * 在线的
     * @return
     */
    @RequestMapping(value = "online", method = RequestMethod.GET)
    Object online();

    /**
     * 查询所有用户
     * @return
     */
    @RequestMapping(value = "allUser", method = RequestMethod.POST)
    Object allUser(@RequestParam("currentPage")int currentPage, @RequestParam("pageSize") int pageSize);

    /**
     * 查询最后登录时间
     * @param name 用户名
     *
     * @return
     */
    @RequestMapping(value = "lastTime/{name}", method = RequestMethod.GET)
    Object lastLoginTime(@PathVariable("name") String name);

    /**
     * 查询登录日志
     * @param name
     *
     * @return
     */
    @RequestMapping(value = "log", method = RequestMethod.POST)
    PageInfo<LogResp> log(@RequestParam("name") String name, @RequestParam("currentPage")int currentPage,
            @RequestParam("pageSize") int pageSize, @RequestParam("sort") String sort);

    @RequestMapping(value = "user/name", method = RequestMethod.GET)
    List<String> getUserName();

    /**
     * 统计每天在线人数
     * @return
     */
    @RequestMapping(value = "countUserByDay", method = RequestMethod.POST)
    List<CountUserResp> getCountUserByDay();

    /**
     * 统计每天登录人次
     * @return
     */
    @RequestMapping(value = "countTimesByDay", method = RequestMethod.POST)
    List<CountUserResp> getCountTimesByDay();
}
