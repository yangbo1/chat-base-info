/**
 * Copyright (c) 2014-2018  墨博云舟 All Rights Reserved.
 */
package com.yb.chat.entity;

import javax.persistence.Table;

/**
 * ChatMessage:
 *
 * @author yangbo
 * @version 1.00
 * @since 2018/3/5 0005 11:44
 */
@Table(name = "chat_message", schema = "chat_base_info")
public class ChatMessage {

    private String userA;

    private String userB;

    private String chatMessage;

    private Long time;

    public String getUserA() {
        return userA;
    }

    public void setUserA(String userA) {
        this.userA = userA;
    }

    public String getUserB() {
        return userB;
    }

    public void setUserB(String userB) {
        this.userB = userB;
    }

    public String getChatMessage() {
        return chatMessage;
    }

    public void setChatMessage(String chatMessage) {
        this.chatMessage = chatMessage;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
