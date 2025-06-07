package com.imooc.controller;

import com.imooc.dto.OrderDTO;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.service.OrderService;
import com.imooc.service.PayService;
import com.lly835.bestpay.model.PayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by 赖学军
 *  微信支付
 * @Date 2021/4/30 17:11
 * @Version 1.0
 */
@Controller
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PayService payService;
    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String orderId,
                               @RequestParam("returnUrl") String returnUrl,
                                Map<String , Object> map) {
        //1.查询订单
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        //使用模版引擎 freemarker 1.返回ModelAndView 2.填写路径
        //发起支付
        //注意：如果点击支付了没结果返回跳转到立即支付界面，就做以下改动
        //      做到这里还需要修改前端代码的 wechatPayUrl:'域名的地址/项目名路径/...' 属性（在项目的config/index.js里面的build）
        PayResponse payResponse = payService.create(orderDTO);
        map.put("payResponse", payResponse);
        map.put("returnUrl", returnUrl);
        return new ModelAndView("pay/create", map);

    }

    /**
     * 微信异步通知 （8-5 章）
     * @param notifyData
     */
    @PostMapping("/notify")
    public ModelAndView notify(@RequestParam String notifyData) {
        payService.notify(notifyData);

        //最后一步：返回给微信处理结果
        return new ModelAndView("pay/success");
    }
}
