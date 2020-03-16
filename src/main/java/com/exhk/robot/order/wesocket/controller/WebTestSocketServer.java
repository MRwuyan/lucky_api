package com.exhk.robot.order.wesocket.controller;

/**
 * Created by Barry on 2018/9/28.
 */

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import com.exhk.robot.order.common.context.SystemContextAware;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

@Slf4j
//@ServerEndpoint("/websocket/{user}")
@ServerEndpoint(value = "/testwebsocket")
//@Controller,
@Component
@Import(SystemContextAware.class)
@Data
public class WebTestSocketServer {
    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private volatile static  int onlineCount = 0;
    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
    private static CopyOnWriteArraySet<WebTestSocketServer> webSocketSet = new CopyOnWriteArraySet<WebTestSocketServer>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;
    //当前Server 与客户端的链接 的uuid唯一辨识码
    private String uuid;

    /**
     * 通过 传递一个  token,关联 session
     */
    public static Map<String, WebTestSocketServer> webSocketMap = new LinkedHashMap<>();


    public static WebTestSocketServer getWebSocketByUuid(String uuid){
        return  webSocketMap.get(uuid);
    }

    public static void putWebSocketByUuid(String uuid, WebTestSocketServer webSocketServer){
          webSocketMap.put(uuid,webSocketServer);
    }


    //用户token 与 uuid 的关系
    public static Map<String, String> token2uuiMap = new LinkedHashMap<>();

    public  static  String getUuidByToken(String token){
        return  token2uuiMap.get(token);
    }


    public static WebTestSocketServer getServerByUserToken(String token){
     String uuid=getUuidByToken(token);

      return  getWebSocketByUuid(uuid);
    }

    public  static String putToken2uuid(String token,String uuid){
        return  token2uuiMap.put(token,uuid);
    }

    /**
     * session 绑定token
     */
    public static Map<String, String> sessionId2TokenMap = new LinkedHashMap<>();

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
    }
    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        //从set中删除
        webSocketSet.remove(this);

        //通过sessionId 去获取 对应的token
        String token = sessionId2TokenMap.get(getSession().getId());
        if (token != null) {
            sessionId2TokenMap.remove(getSession().getId());
            WebTestSocketServer.webSocketMap.remove(token);
        }
    }
    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */

    @OnMessage
    public void onMessage(String message, Session session) {
        log.debug("来自客户端的消息:" + message);
        //格式化消息
        try {
            log.error("");
        } catch (Exception e) {
            log.error("请求格式错误！！！");
            e.printStackTrace();
        }
    }

    /**
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        String sessionId=session.getId();
        log.error("onError:发生错误,注销sesisonId:"+sessionId);
    }


    /**
     * 推送给前端的方法，
     * 将要废弃，使用异步线程队列，进行推送，。
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);//不要用同步发送，使用异步发送即可
    }




}
