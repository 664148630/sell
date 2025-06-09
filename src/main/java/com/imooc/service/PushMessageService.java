package com.imooc.service;

import com.imooc.dto.OrderDTO;

/**推送消息
 * Created by 赖学军
 *
 * @Date 2025/6/8 19:03
 * @Version 1.0
 */
public interface PushMessageService {
    /**
     * 订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
