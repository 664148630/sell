package com.imooc.utils;

import com.imooc.enums.CodeEnum;

/**
 * Created by 赖学军
 * 枚举通用类 工具类
 * @Date 2025/6/5 14:13
 * @Version 1.0
 */
public class EnumUtil {
    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
