package com.imooc.form;

import lombok.Data;

import java.math.BigDecimal;

/**存储表单提交过来的字段
 * Created by 赖学军
 *
 * @Date 2025/6/7 18:35
 * @Version 1.0
 */
@Data
public class ProductForm {

    private String productId;
    /** 名字. */
    private String productName;
    /** 单价. */
    private BigDecimal productPrice;
    /** 库存. */
    private Integer productStock;
    /** 描述. */
    private String productDescription;
    /** 小图. */
    private String productIcon;

    //这个字段不需要，有单独处理的上架，下架状态
    /** 状态，0正常1下架. */
//    private Integer productStatus;
    /** 类目编号. */
    private Integer categoryType;
}
