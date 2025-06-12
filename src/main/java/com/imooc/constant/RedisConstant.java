package com.imooc.constant;

/**
 * redis常量
 * Created by 赖学军
 *
 * @Date 2025/6/10 23:10
 * @Version 1.0
 */
public interface RedisConstant {
    String TOKEN_PREFIX = "token_%s"; //前缀
    Integer EXPIRE = 7200; //2小时
}
