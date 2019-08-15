package com.liuniukeji.springcloud.eureka_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

    // @EnableEurekaServer 将当前应用配置为服务注册中心
    // 想要启动两个应用，达到集群效果的话，需要自己新增一个Configurations，并设置Active Profiles值为server2，然后启动两个应用

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }

}
