/**
 * Copyright (c) 2014-2018  墨博云舟 All Rights Reserved.
 */
package com.yb.chat.convert;

import com.yb.chat.client.base.UserBase;
import com.yb.chat.client.base.UserBaseInfo;
import com.yb.chat.entity.UserInfo;

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
    public static UserBase convertUserToResp(UserInfo user) {
        if (user != null) {
            UserBase us = new UserBase();
            us.setName(user.getName());
            us.setImg(user.getImg());
            us.setGender(user.getGender());
            us.setRemark(user.getRemark());
            return us;
        } else {
            return null;
        }
    }
    public static List<UserBase> convertUserListToResp(List<UserInfo> users) {
        if (!users.isEmpty()) {
            List<UserBase> us = new ArrayList<>();
            for (UserInfo u : users) {
                us.add(convertUserToResp(u));
            }
            return us;
        } else {
            return null;
        }
    }

    public static UserBaseInfo convertUserToUserBaseInfo(UserInfo userInfo) {
        if (userInfo != null) {
            UserBaseInfo baseInfo = new UserBaseInfo();
            baseInfo.setCareer(userInfo.getCareer());
            baseInfo.setJobAddress(userInfo.getJobAddress());
            baseInfo.setPhone(userInfo.getPhone());
            baseInfo.setRealName(userInfo.getRealName());
            baseInfo.setSchool(userInfo.getSchool());
            baseInfo.setWechat(userInfo.getWechat());
            baseInfo.setGender(userInfo.getGender());
            baseInfo.setRemark(userInfo.getRemark());
            baseInfo.setImg(userInfo.getImg());
            baseInfo.setName(userInfo.getName());
            return baseInfo;
        } else {
            return null;
        }
    }

}
