/**
 * Copyright (c) 2014-2018  墨博云舟 All Rights Reserved.
 */
package com.yb.chat.client.base;

/**
 * UserBase:
 *
 * @author yangbo
 * @version 1.00
 * @since 2018/2/7 0007 15:31
 */
public class UserBase {
    /**
     * 名称
     */
    private String name;

    /**
     * 头像
     */
    private String img;

    /**
     * 签名
     */
    private String remark;

    /**
     * 性别
     */
    private String gender;



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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


}
