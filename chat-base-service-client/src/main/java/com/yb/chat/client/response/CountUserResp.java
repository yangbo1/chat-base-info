/**
 * Copyright (c) 2014-2018  墨博云舟 All Rights Reserved.
 */
package com.yb.chat.client.response;

/**
 * CountUserResp:
 *
 * @author yangbo
 * @version 1.00
 * @since 2018/3/30 0030 11:29
 */
public class CountUserResp {
    private String date;

    private Integer num;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
