package com.imooc.service;

import com.imooc.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;

/**
 * Created by 赖学军
 * 支付
 * @Date 2021/4/30 17:22
 * @Version 1.0
 */
public interface PayService {
    /**
     * 创建预支付订单
     * @param orderDTO
     */
    PayResponse create(OrderDTO orderDTO);

    PayResponse notify(String notifyData);

    /**
     * 退款
     * @param orderDTO
     * @return
     */
    RefundResponse refund(OrderDTO orderDTO);
}
