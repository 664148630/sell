package com.imooc.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by 赖学军
 * Json 格式化工具
 * @Date 2025/6/1 10:00
 * @Version 1.0
 */
public class JsonUtil {

    /**
     * 将对象格式化为 Json 格式
     * @param object
     * @return
     */
    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
