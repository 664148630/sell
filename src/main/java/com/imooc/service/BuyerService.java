package com.imooc.service;

import com.imooc.dto.OrderDTO;

/**
 * Created by 赖学军
 *买家
 * @Date 2021/4/24 15:47
 * @Version 1.0
 */
public interface BuyerService {
    //查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);
    //取消订单
    OrderDTO cancelOrder(String openid, String orderId);
}
