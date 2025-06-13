package com.imooc.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by 赖学军
 *
 * @Date 2021/4/19 14:06
 * @Version 1.0
 */
@Data
public class ProductInfoVO implements Serializable {
    private static final long serialVersionUID = 6179894408250932674L;
    @JsonProperty("id")
    private String productId;
    @JsonProperty("name")
    private String productName;
    @JsonProperty("price")
    private BigDecimal productPrice;
    @JsonProperty("description")
    private String productDescription;
    @JsonProperty("icon")
    private String productIcon;
}
