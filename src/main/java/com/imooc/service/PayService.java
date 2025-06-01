package com.imooc.service;

import com.imooc.dto.OrderDTO;

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
    void create(OrderDTO orderDTO);
}
