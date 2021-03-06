/**
 * Copyright (c) 2014-2018  墨博云舟 All Rights Reserved.
 */
package com.yb.chat.entity;

import javax.persistence.Table;

/**
 * LogInfo:
 *
 * @author yangbo
 * @version 1.00
 * @since 2018/2/22 0022 16:36
 */
@Table(name = "log_info", schema = "chat_base_info")
public class LogInfo {

    /**
     * 用户id
     */
    private String userId;

    /**
     *用户名
     */
    private String userName;

    /**
     * 类型1登陆0登出
     */
    private Integer type;

    /**
     * 时间
     */
    private Long time;

    /**
     * 时间
     */
    private String address;

    /**
     * 系统
     */
    private String system;

    /**
     *是否管理操作1是0否
     */
    private Integer isAdmin;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }
}
