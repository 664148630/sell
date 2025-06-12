package com.imooc.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**卖家信息表
 * Created by 赖学军
 *
 * @Date 2025/6/10 12:10
 * @Version 1.0
 */
@Data
@Entity
public class SellerInfo {

    @Id
    private String sellerId;
    private String username;
    private String password;
    private String openid;
}
