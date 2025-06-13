package com.imooc.service;

/**
 * Created by 赖学军
 *
 * @Date 2025/6/12 16:02
 * @Version 1.0
 */
public interface SecKillService {

    String querySecKillProductInfo(String productId);

    void orderProductMockDiffUser(String productId);
}
