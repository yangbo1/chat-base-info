/**
 * Copyright (c) 2014-2018  墨博云舟 All Rights Reserved.
 */
package com.yb.chat.entity;


import com.yb.chat.base.UserBase;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * UserInfo:
 *
 * @author yangbo
 * @version 1.00
 * @since 2018/2/2 0002 17:11
 */
@Table(name = "user_info", schema = "chat_base_info")
public class UserInfo extends UserBase {
    /**
     * id
     */
    @Id
    @GeneratedValue(generator="UUID")
    private String id;
    /**
     * 密码
     */
    private String password;

    /**
     * 注册时间
     */
    private Long registTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getRegistTime() {
        return registTime;
    }

    public void setRegistTime(Long registTime) {
        this.registTime = registTime;
    }
}
