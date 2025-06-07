package com.imooc.form;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**存储表单提交过来的字段
 * Created by 赖学军
 *
 * @Date 2025/6/7 20:31
 * @Version 1.0
 */
@Data
public class CategoryForm {

    private Integer categoryId;
    /** 类目名字. */
    private String categoryName;
    /** 类目编号. */
    private Integer categoryType;
}
