package com.imooc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/** Url配置
 * Created by 赖学军
 *
 * @Date 2025/6/10 14:47
 * @Version 1.0
 */
@Data
@ConfigurationProperties(prefix = "project.url")//从配置文件application里面相对应的前缀配置拿到这些变量的值
@Component
public class ProjectUrlConfig {
    /**
     * 微信公众平台授权url
     */
    public String wechatMpAuthorize;

    /**
     * 微信开放平台授权url
     */
    public String wechatOpenAuthorize;

    /**
     * 点餐系统
     */
    public String sell;
}
