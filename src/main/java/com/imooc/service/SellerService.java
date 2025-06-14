package com.imooc.service;

import com.imooc.dataobject.SellerInfo;

/** 卖家端
 * Created by 赖学军
 *
 * @Date 2025/6/10 12:46
 * @Version 1.0
 */
public interface SellerService {
    /**
     * 通过openid查询卖家端信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
