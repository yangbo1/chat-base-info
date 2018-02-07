/**
 * Copyright (c) 2014-2018  墨博云舟 All Rights Reserved.
 */
package com.yb.chat.dao;

import com.yb.chat.entity.UserInfo;
import com.yb.common.dao.MyMapper;
import com.yb.common.entity.UserBase;

import java.util.List;

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
    List<UserBase> findFriendsById(String id);
}
