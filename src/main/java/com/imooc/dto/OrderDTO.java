package com.imooc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.imooc.dataobject.BaseEntity;
import com.imooc.dataobject.OrderDetail;
import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayStatusEnum;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by 赖学军
 *
 * @Date 2021/4/23 9:53
 * @Version 1.0
 */
@Data
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)//过时的
//@JsonInclude(JsonInclude.Include.NON_NULL)//为空的字段不显示出来
public class OrderDTO extends BaseEntity {
    /** 订单id. */
    private String orderId;
    /** 买家名字. */
    private String buyerName;
    /** 买家手机号. */
    private String buyerPhone;
    /** 买家地址. */
    private String buyerAddress;
    /** 买家微信Openid. */
    private String buyerOpenid;
    /** 订单总金额. */
    private BigDecimal orderAmount;
    /** 订单状态，默认为0新下单. */
    private Integer orderStatus;
    /** 支付状态，默认为0未支付. */
    private Integer payStatus;

    List<OrderDetail> orderDetailList;
}
