/**
 * Copyright (c) 2014-2018  墨博云舟 All Rights Reserved.
 */
package com.yb.chat.server;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yb.chat.client.response.UserResp;
import com.yb.chat.entity.UserInfo;
import com.yb.chat.serivce.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

/**
 * ChatServer: websocket基础服务
 *
 * @author yangbo
 * @version 1.00
 * @since 2018/1/30 0030 16:28
 */
@ServerEndpoint(value = "/chatServer/{userId}", configurator = HttpSessionConfigurator.class)
@Component
public class ChatServer {
    private static int onlineCount = 0; //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static CopyOnWriteArraySet<ChatServer> webSocketSet = new CopyOnWriteArraySet<ChatServer>();
    private Session session;    //与某个客户端的连接会话，需要通过它来给客户端发送数据
//    private String userid;      //用户名
    private HttpSession httpSession;    //request的session
    /**
     * 给springboot启动类注入
     */
//    private static ApplicationContext applicationContext;
//    public static void setApplicationContext(ApplicationContext applicationContext) {
//        applicationContext = applicationContext;
//    }

    /**
     * service
     */
    private UserService userService;
    public static Map<String, UserInfo> userInfoMap = new HashMap<>();
        private static List list = new ArrayList<>();   //在线列表,记录用户名称
    private static Map routetab = new HashMap<>();  //用户名和websocket的session绑定的路由表
    /**
     * 连接建立成功调用的方法
     * @param session  可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void onOpen(@PathParam("userId") String user, Session session, EndpointConfig config) throws UnsupportedEncodingException {
        this.session = session;
//        this.httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
//        this.userid=(String) httpSession.getAttribute("userid");    //获取当前用户
//        String userid = user;    //获取当前用户
//        String userid = (String) httpSession.getAttribute(user);//获取当前用户
        UserInfo userInfo = userInfoMap.get(user);
        String userid = userInfo.getName();
        if (userid == null) {
            return ;
        } else {
            webSocketSet.add(this);     //加入set中
            addOnlineCount();           //在线数加1;
            list.add(userid);           //将用户名加入在线列表
            routetab.put(userid, session);   //将用户名和session绑定到路由表
            userInfoMap.remove(user);
            String message = getMessage("[" + userid + "]上线,当前在线人数为"+getOnlineCount()+"位", "notice",  list);
//            broadcast(message);//广播
            Map<String,Object> map = new HashMap<>();
            map.put("id", userInfo.getId());
            map.put("img", userInfo.getImg());
            map.put("online", list);
            map.put("type", "id");
//            singleSend(JSONObject.toJSONString(map), (Session) routetab.get(userid));
            broadcast(JSONObject.toJSONString(map));
        }
//        userService = applicationContext.getBean(UserService.class);
//        List<UserResp> a = userService.findByName("a");
//        System.out.println(a.toString());

    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(@PathParam("userId") String user){
        String userid = user;
        webSocketSet.remove(this);  //从set中删除
        subOnlineCount();           //在线数减1
        list.remove(userid);        //从在线列表移除这个用户
        routetab.remove(userid);
//        String message = getMessage("[" + userid + "]下线,当前在线人数为" + getOnlineCount() + "位", "notice", list);
//        broadcast(message);//广播
        String message = getMessage( userid, "off", null);
        broadcast(message);
    }

    /**
     * 接收客户端的message,判断是否有接收人而选择进行广播还是指定发送
     * @param _message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String _message) {
        JSONObject chat = JSON.parseObject(_message);
        JSONObject message = JSON.parseObject(chat.get("message").toString());
        if(message.get("to") == null || message.get("to").equals("")){      //如果to为空,则广播;如果不为空,则对指定的用户发送消息
            broadcast(_message);
        }else{
            String [] userlist = message.get("to").toString().split(",");
            singleSend(_message, (Session) routetab.get(message.get("from")));      //发送给自己,这个别忘了
            for(String user : userlist){
                if(!user.equals(message.get("from"))){
                    if (routetab.get(user) != null) {
                        singleSend(_message, (Session) routetab.get(user));     //分别发送给每个指定用户
                    }
                }
            }
        }
    }

    /**
     * 发生错误时调用
     * @param error
     */
    @OnError
    public void onError(Throwable error){
        error.printStackTrace();
    }

    /**
     * 广播消息
     * @param message
     */
    public void broadcast(String message){
        for(ChatServer chat: webSocketSet){
            try {
                chat.session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    /**
     * 对特定用户发送消息
     * @param message
     * @param session
     */
    public void singleSend(String message, Session session){
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 组装返回给前台的消息
     * @param message   交互信息
     * @param type      信息类型
     * @param list      在线列表
     * @return
     */
    public String getMessage(String message, String type, List list){
        JSONObject member = new JSONObject();
        member.put("message", message);
        member.put("type", type);
        member.put("list", list);
        return member.toString();
    }

    public  int getOnlineCount() {
        return onlineCount;
    }

    public  void addOnlineCount() {
        ChatServer.onlineCount++;
    }

    public  void subOnlineCount() {
        ChatServer.onlineCount--;
    }
}
