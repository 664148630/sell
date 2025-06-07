package com.imooc.dataobject;

import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by 赖学军
 *订单
 * @Date 2021/4/21 17:16
 * @Version 1.0
 */
@Entity
@Data
//@DynamicUpdate
public class OrderMaster {
    /** 订单id. */
    @Id
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
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();
    /** 支付状态，默认为0未支付. */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    //如果要把时间重新拿出来处理,就继承自己写的类 extends BaseEntity
    /** 创建时间. */
    private Date createTime;
////    /** 更新时间. */
    private Date updateTime;

}
