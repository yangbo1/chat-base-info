/**
 * Copyright (c) 2014-2018  墨博云舟 All Rights Reserved.
 */
package com.yb.chat.client.response;

/**
 * ChatResult:
 *
 * @author yangbo
 * @version 1.00
 * @since 2018/2/2 0002 17:29
 */
public class ChatResult {
    private  String code;

    private  String msg;

    private Object content;

    public ChatResult(String code, String msg, Object content) {
        this.code = code;
        this.msg = msg;
        this.content = content;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getContent() {
        return content;
    }

    public static ChatResult setContent(Object content) {
        return new ChatResult("1","success", content);
    }
}
