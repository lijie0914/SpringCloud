package com.liuniukeji.springcloud.eureka_producer.controller;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.liuniukeji.springcloud.eureka_producer.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
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

    private SystemUserService userService;

    @Autowired
    public testController(SystemUserService userService) {
        this.userService = userService;
    }

    @Value("${server.port}")
    private String ipPort;

    @Value("${spring.application.name}")
    private String applicationName;

    @GetMapping("/test1")
    public String test1() {
        return "服务生产者，端口号:" + ipPort + "，服务名称:" + applicationName;
    }

    @GetMapping("/test2")
    public String test2(String name) {
        return "服务生产者，端口号:" + ipPort + "，服务名称:" + applicationName + "，hello " + name;
    }

    /**
     * 分布式事务测试类
     */
    @GetMapping("/testTransaction")
    @LcnTransaction //分布式事务注解
    @Transactional //本地事务注解
    public String testTransaction(String value) {
        userService.addMaster(value);
        return "生产者 分布式事务测试类";
    }
}
