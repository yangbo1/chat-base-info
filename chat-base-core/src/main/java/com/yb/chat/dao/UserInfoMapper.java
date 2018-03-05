/**
 * Copyright (c) 2014-2018  墨博云舟 All Rights Reserved.
 */
package com.yb.chat.dao;

import com.yb.chat.base.UserBase;
import com.yb.chat.entity.ChatMessage;
import com.yb.chat.entity.UserInfo;
import com.yb.common.dao.MyMapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import javax.websocket.server.PathParam;

/**
 * UserInfoMapper:
 *
 * @author yangbo
 * @version 1.00
 * @since 2018/2/2 0002 17:20
 */
public interface UserInfoMapper extends MyMapper<UserInfo> {
    /**
     * 查询好友列表
     * @param id
     *
     * @return
     */
    List<UserBase> findFriendsById(@Param("id") String id);

    /**
     * 加载聊天记录
     * @param userA
     * @param userB
     *
     * @return
     */
    List<ChatMessage> findChatMessage(@Param("userA") String userA, @Param("userB") String userB);
}
