package com.imooc.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by 赖学军
 *
 * @Date 2025/6/9 0:14
 * @Version 1.0
 */
@Component
@ServerEndpoint("/webSocket")
@Slf4j
public class WebSocket {

    private Session session;

    private static CopyOnWriteArraySet<WebSocket> webSocketSet = new CopyOnWriteArraySet<>();

    //下面就是对应前端写好的事件，在后端有相对的对应
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSocketSet.add(this);
        log.info("【WebSocket消息】有新的连接，总数：{}", webSocketSet.size());
    }

    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        log.info("【WebSocket消息】连接断开，总数：{}", webSocketSet.size());
    }

    @OnMessage
    public void onMessage(String message) {
        log.info("【WebSocket消息】收到客户端发来的消息：{}", message);
    }

    public void sendMessage(String message) {
        for (WebSocket webSocket : webSocketSet) {
            log.info("【WebSocket消息】广播消息，message={}", message);
            try {
                webSocket.session.getBasicRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
