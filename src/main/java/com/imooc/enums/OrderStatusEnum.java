package com.imooc.enums;

import lombok.Getter;

/**
 * Created by 赖学军
 *
 * @Date 2021/4/21 17:20
 * @Version 1.0
 */
@Getter
public enum OrderStatusEnum implements CodeEnum {
    NEW(0, "新订单"),
    FINISHED(1, "完结"),
    CANCEL(2, "已取消"),
    ;
    private Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    //这个枚举方法改造成 更通用方式：实现 CodeEnum 接口，创建枚举通用类 工具类
//    public static OrderStatusEnum getOrderStatusEnum(Integer code) {
//        for (OrderStatusEnum orderStatusEnum : OrderStatusEnum.values()) {
//            if (orderStatusEnum.getCode().equals(code)) {
//                return orderStatusEnum;
//            }
//        }
//        return null;
//    }
}
