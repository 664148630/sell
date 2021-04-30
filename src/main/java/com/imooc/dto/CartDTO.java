package com.imooc.dto;

import lombok.Data;

/**
 * Created by 赖学军
 *
 * @Date 2021/4/23 11:00
 * @Version 1.0
 */
@Data
public class CartDTO {
    /** 商品Id. */
    private String productId;
    /** 数量. */
    private Integer productQuantity;
    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

}
