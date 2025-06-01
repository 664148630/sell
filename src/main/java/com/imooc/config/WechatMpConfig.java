package com.imooc.config;

import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.config.WxMpConfigStorage;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by 赖学军
 *从 config 里面拿到配置信息（mpAppId、mpAppSecret）
 * @Date 2021/4/25 18:08
 * @Version 1.0
 */
@Component
public class WechatMpConfig {

    @Autowired
    private WechatAccountConfig accountConfig;
    @Bean
    public WxMpService wxMpService() {
        WxMpService wxMpService = new WxMpServiceImpl();
        //设置一下配置
        wxMpService.setWxMpConfigStorage(wxMpConfigStorage());
        return wxMpService;
    }

    @Bean
    public WxMpConfigStorage wxMpConfigStorage() {
        WxMpDefaultConfigImpl wxMpDefaultConfig = new WxMpDefaultConfigImpl();
        //从配置文件里面读（在配置文件里写好，通过配置类映射过来）
        wxMpDefaultConfig.setAppId(accountConfig.getMpAppId());
        wxMpDefaultConfig.setSecret(accountConfig.getMpAppSecret());
        return wxMpDefaultConfig;
    }
}
