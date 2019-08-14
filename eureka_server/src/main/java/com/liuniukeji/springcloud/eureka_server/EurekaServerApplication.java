package com.liuniukeji.springcloud.eureka_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

    // @EnableEurekaServer 将当前应用配置为服务注册中心

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }

}
