package com.abc.controller;

import com.abc.config.MysqlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lixiaopeng
 * @date: 2020/3/8 20:34
 * @desc:
 */
@RestController
public class SomeController {
    @Autowired
    private MysqlConfig mysqlConfig;

    @GetMapping("/config")
    public String fetchConfig() {
        return mysqlConfig.getDesc2();
    }
}
