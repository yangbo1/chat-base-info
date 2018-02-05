/**
 * Copyright (c) 2014-2018  墨博云舟 All Rights Reserved.
 */
package com.yb.chat.entity;

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
public class UserInfo {
    /**
     * id
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 头像
     */
    private String img;

    /**
     * 密码
     */
    private String password;

    /**
     * 签名
     */
    private String remark;

    /**
     * 注册时间
     */
    private Long registTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getRegistTime() {
        return registTime;
    }

    public void setRegistTime(Long registTime) {
        this.registTime = registTime;
    }
}
