package com.liuniukeji.springcloud.eureka_producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Jerry
 * @date : 2019/8/14 7:56
 * Title : testController
 * Description : 测试接口类
 */
@RestController
@RequestMapping("test")
public class testController {

    @Value("${server.port}")
    private String ipPort;

    @Value("${spring.application.name}")
    private String applicationName;

    @GetMapping("/test1")
    public String test1() {
        return "服务生产者，端口号:" + ipPort + "，服务名称:" + applicationName;
    }
}
