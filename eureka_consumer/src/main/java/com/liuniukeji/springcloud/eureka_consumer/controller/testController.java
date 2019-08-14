package com.liuniukeji.springcloud.eureka_consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author : Jerry
 * @date : 2019/8/14 7:56
 * Title : testController
 * Description : 测试接口类
 */
@RestController
@RequestMapping("test")
public class testController {

    // 普通的restTemplate
    @Autowired
    private RestTemplate restTemplate;

    // 开启负载之后的restTemplate，走eureka注册中心注册的服务
    @Autowired
    private RestTemplate ribbonRestTemplate;

    /**
     * @HystrixCommand(fallbackMethod = "test2") 当demo-api服务故障时返回test2()的执行结果
     */
    @HystrixCommand(fallbackMethod = "test2")
    @GetMapping("/test1")
    public String test1() {
        // demo-api 为注册到eureka server上的服务名称即api模块中的spring.application.name
        return ribbonRestTemplate.getForObject("http://demo-api/test/test1", String.class);
    }

    @GetMapping("/test2")
    public String test2() {
        String url = "https://www.baidu.com/";
        return restTemplate.getForObject(url, String.class);
    }
}
