package com.imooc.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.imooc.dataobject.ProductInfo;
import lombok.Data;

import java.util.List;

/**
 * Created by 赖学军
 *商品（包含类目）
 * @Date 2021/4/19 14:02
 * @Version 1.0
 */
@Data
public class ProductVO {
    @JsonProperty("name")
    private String categoryName;
    @JsonProperty("type")
    private Integer categoryType;
    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;

}
