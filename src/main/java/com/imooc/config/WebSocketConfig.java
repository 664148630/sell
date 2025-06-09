package com.imooc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * Created by 赖学军
 *
 * @Date 2025/6/9 0:01
 * @Version 1.0
 */
@Component
public class WebSocketConfig {

    //WebSocket消息推送
    //第一步：pom文件引入<artifactId>spring-boot-starter-websocket</artifactId>
    //这里是第二步：配置
    //第三步可以编写WebSocket类了
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
