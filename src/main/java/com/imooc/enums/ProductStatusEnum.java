package com.imooc.enums;

import lombok.Getter;

/**
 * Created by 赖学军
 *商品状态
 * @Date 2021/4/19 10:33
 * @Version 1.0
 */
@Getter
public enum ProductStatusEnum implements CodeEnum{
    UP(0, "在架"),
    DOWN(1, "下架")
    ;
    private Integer code;
    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
