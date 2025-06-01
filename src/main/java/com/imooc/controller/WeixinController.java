package com.imooc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by 赖学军
 *手工获取OpenID
 * @Date 2025/5/31 13:47
 * @Version 1.0
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {
    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code) {
        /**
         * 第一步：用户同意授权，获取code
         * 可以先写个跳转方法拿到code：如下
         * https://open.weixin.qq.com/connect/oauth2/authorize
         * ?appid=wx944bee3c0903b94f
         * &redirect_uri=http://t33aaa68.natappfree.cc/sell/weixin/auth  //免费隧道测试不行
         * &response_type=code&scope=snsapi_base&state=STATE#wechat_redirect
         */
        log.info("进入auth方法...");
        log.info("code=【】" ,code);

        //第二步：通过code换取网页授权access_token
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx944bee3c0903b94f&secret=d8503f7837f2e857cd96390507c9da93&code="+ code +"&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        log.info("response = {}", response);
    }
}
