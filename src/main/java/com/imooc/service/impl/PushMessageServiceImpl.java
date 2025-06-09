package com.imooc.service.impl;

import com.imooc.config.WechatAccountConfig;
import com.imooc.dto.OrderDTO;
import com.imooc.service.PushMessageService;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 赖学军
 *
 * @Date 2025/6/8 19:06
 * @Version 1.0
 */
@Service
@Slf4j
public class PushMessageServiceImpl implements PushMessageService {

    @Autowired
    private WxMpService wxMpService;

    @Autowired
    private WechatAccountConfig accountConfig;
    @Override
    public void orderStatus(OrderDTO orderDTO) {
        WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();
        //模版ID
//        templateMessage.setTemplateId("YvLLQVnexOe2imqgTJgoE_IQOOQgRlZ9iUGou_Ncmrk");//这里用的是测试号的
        templateMessage.setTemplateId(accountConfig.getTemplateId().get("orderStatus"));//获取配置文件里面的键TemplateId相对应的 orderStatus
        //推送给谁（公众账号的OpenID）
//        templateMessage.setToUser("oYgjB7TOldj0Pjad2AYwKJY6rwO8");//这里用的是测试号的
        templateMessage.setToUser(orderDTO.getBuyerOpenid());//获取买家微信Openid.
        List<WxMpTemplateData> data = Arrays.asList(
                new WxMpTemplateData("first", "亲，记得收货。"),
                new WxMpTemplateData("keyword1", "微信点餐"),
                new WxMpTemplateData("keyword2", "18278781876"),
                new WxMpTemplateData("keyword3", orderDTO.getOrderId()),
                new WxMpTemplateData("keyword4", orderDTO.getOrderStatusEnum().getMessage()),
                new WxMpTemplateData("keyword5", "￥" + orderDTO.getOrderAmount()),
                new WxMpTemplateData("remark", "欢迎再次光临。")
        );
        //主要的数据
        templateMessage.setData(data);
        try {
            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        } catch (WxErrorException e) {//注意消息类的异常尽量不要让它自己抛出来
            log.error("【微信模版消息】发送失败，｛｝", e);
        }
    }
}
