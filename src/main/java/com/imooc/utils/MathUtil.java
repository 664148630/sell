package com.imooc.utils;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Created by 赖学军
 *
 * @Date 2025/6/3 0:46
 * @Version 1.0
 */
public class MathUtil {

    private final static Double MONEY_RANGE = 0.01;
    /**
     * 比较两个金额是否相等
     * @param d1
     * @param d2
     * @return
     */
    public static Boolean equals(Double d1, Double d2) {
        Double result = Math.abs(d1 - d2);
        if (result < MONEY_RANGE) {
            return true;
        } else {
            return false;
        }
    }
}
