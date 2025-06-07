package com.imooc.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.imooc.dataobject.BaseEntity;
import com.imooc.dataobject.OrderDetail;
import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayStatusEnum;
import com.imooc.utils.EnumUtil;
import com.imooc.utils.serializer.Date2LongSerializer;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by 赖学军
 *
 * @Date 2021/4/23 9:53
 * @Version 1.0
 */
@Data
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)//过时的
//@JsonInclude(JsonInclude.Include.NON_NULL)//为空的字段不显示出来；注意：这里注释了是因为通过配置文件里面配置了
public class OrderDTO {
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

    //时间重新拿出来处理了
    /** 创建时间. */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

//    /** 更新时间. */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    List<OrderDetail> orderDetailList;

    /**
     * 把 数字 转换成 文字 的枚举方法
     * @return
     */
    @JsonIgnore //加上这个注解，以后对象转换成 json 格式会忽略这个方法（写rest接口的时候，把orderDTO当成一个对象返回json数据也会把它们带上，所以加注解）
    public OrderStatusEnum getOrderStatusEnum() {
        //一般方式
//        return OrderStatusEnum.getOrderStatusEnum(orderStatus);

        //更大，更通用方式
        return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum() {
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);
    }
}
