package com.liuniukeji.springcloud.eureka_producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EurekaProducerApplication {

    // PS：从Spring Cloud Edgware版本开始，eureka的服务提供者/服务消费者的启动类上不需要添加@EnableDiscoveryClient 或@EnableEurekaClient
    // 当前应用为服务提供者（服务生产者），只需要在配置文件中将当前应用注册到注册中心即可
    // 想要启动两个应用，达到集群效果的话，需要自己新增一个Configurations，并设置VM options值为-Dserver.port=8182，然后启动两个应用

    public static void main(String[] args) {
        SpringApplication.run(EurekaProducerApplication.class, args);
    }

}
