package com.liuniukeji.springcloud.springcloudconfigclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Jerry
 * @date : 2019/8/14 7:56
 * Title : testController
 * Description : 测试接口类
 */
@RefreshScope
@RestController
@RequestMapping("test")
public class testController {

    @Value("${jerry.hello}")
    private String hello;

    @RequestMapping("/hello")
    public String from() {
        return this.hello;
    }
}
