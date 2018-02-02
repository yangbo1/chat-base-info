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
    private static String code = "1";

    private static String msg = "成功";

    private Object content;

    public ChatResult(Object content) {
        this.content = content;
    }

    public static ChatResult setContent(Object content) {
        return new ChatResult(content);
    }
}
