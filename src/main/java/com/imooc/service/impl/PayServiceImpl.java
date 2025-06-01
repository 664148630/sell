package com.imooc.service.impl;

import com.imooc.dto.OrderDTO;
import com.imooc.service.PayService;
import com.imooc.utils.JsonUtil;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 赖学军
 *
 * @Date 2021/4/30 17:24
 * @Version 1.0
 */
@Service
@Slf4j
public class PayServiceImpl implements PayService {

    @Autowired
    private BestPayServiceImpl bestPayService;

    private static final String ORDER_NAME = "微信点餐订单";

    @Override
    public void create(OrderDTO orderDTO) {
        //不采用new的方式，采用单独配置@bean的方式去new，然后拿来引用
//        BestPayServiceImpl bestPayService = new BestPayServiceImpl();
//        bestPayService.setWxPayH5Config();

        PayRequest payRequest = new PayRequest();
        payRequest.setOpenid(orderDTO.getBuyerOpenid());
        payRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        payRequest.setOrderId(orderDTO.getOrderId());
        payRequest.setOrderName(ORDER_NAME);
        payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);

        log.info("【微信支付】request={}", JsonUtil.toJson(payRequest));

        //这里拿到response的信息填到pay.html里面
        PayResponse payResponse = bestPayService.pay(payRequest);
        log.info("【微信支付】response={}", JsonUtil.toJson(payResponse));
    }
}
