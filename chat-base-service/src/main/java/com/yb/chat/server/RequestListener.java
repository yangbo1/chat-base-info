/**
 * Copyright (c) 2014-2018  墨博云舟 All Rights Reserved.
 */
package com.yb.chat.server;

import org.springframework.stereotype.Component;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * RequestListener:
 *
 * @author yangbo
 * @version 1.00
 * @since 2018/2/6 0006 18:19
 */
@Component
public class RequestListener implements ServletRequestListener {
    @Override
    public void requestInitialized(ServletRequestEvent sre)  {
        //将所有request请求都携带上httpSession
        ((HttpServletRequest) sre.getServletRequest()).getSession();

    }
    public RequestListener() {
    }

    @Override
    public void requestDestroyed(ServletRequestEvent arg0)  {
    }
}
