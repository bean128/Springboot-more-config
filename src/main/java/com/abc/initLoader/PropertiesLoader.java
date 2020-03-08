package com.abc.initLoader;

import com.abc.config.MybatisConfig;
import com.abc.config.MysqlConfig;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: lixiaopeng
 * @date: 2020/3/8 14:42
 * @desc: 服务启动自动加载在这里完成
 */
@Component
public class PropertiesLoader implements InitializingBean {

    @Autowired
    private MybatisConfig mybatisConfig;

    @Autowired
    private MysqlConfig mysqlConfig;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("服务器启动加载，在这里完成");
    }
}
