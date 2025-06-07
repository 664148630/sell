package com.imooc.enums;

import lombok.Getter;

/**
 * Created by 赖学军
 *
 * @Date 2021/4/21 17:27
 * @Version 1.0
 */
@Getter
public enum PayStatusEnum implements CodeEnum {
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),
    ;
    private Integer code;
    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
