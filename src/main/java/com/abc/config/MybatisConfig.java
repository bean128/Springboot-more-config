package com.abc.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author: lixiaopeng
 * @date: 2020/3/8 14:38
 * @desc:
 */
@Configuration
@Data
public class MybatisConfig {
    @Value("${mybatis.desc:null}")
    private String desc;
    @Value("${mybatis.desc2:null}")
    private String desc2;
}
