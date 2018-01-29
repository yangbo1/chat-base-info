/**
 * Copyright (c) 2014-2018  墨博云舟 All Rights Reserved.
 */
package com.yb.chat.convert;

import com.yb.chat.client.response.UserResp;
import com.yb.chat.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * ChatConvert:
 *
 * @author yangbo
 * @version 1.00
 * @since 2018/1/29 0029 15:16
 */
public class ChatConvert {
    public static UserResp convertUserToResp(UserEntity user) {
        if (user != null) {
            UserResp us = new UserResp();
            us.setId(user.getId());
            us.setName(user.getName());
            return us;
        } else {
            return null;
        }
    }
    public static List<UserResp> convertUserListToResp(List<UserEntity> users) {
        if (!users.isEmpty()) {
            List<UserResp> us = new ArrayList<>();
            for (UserEntity u : users) {
                us.add(convertUserToResp(u));
            }
            return us;
        } else {
            return null;
        }
    }
}
