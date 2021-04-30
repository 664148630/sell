package com.imooc.utils;

import java.util.Random;

/**
 * Created by 赖学军
 *
 * @Date 2021/4/23 10:41
 * @Version 1.0
 */
public class KeyUtil {
    /**
     * 生产唯一的主键
     * 格式：时间戳 + 随机数
     * @return
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
