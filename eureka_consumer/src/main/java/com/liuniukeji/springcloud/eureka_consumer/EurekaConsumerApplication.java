package com.liuniukeji.springcloud.eureka_consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@EnableHystrix
@SpringBootApplication
public class EurekaConsumerApplication {

    // @EnableHystrix 开启Hystrix熔断器功能
    // @EnableZuulProxy 声明开启zuul
    // 当前应用为服务消费者，负责消费（即调用）eureka中的服务生产者，
    // 同时还整合ribbon实现了本地的负载均衡，
    // 整合hystrix实现了服务调用的容错保护机制，
    // 整合zuul实现了API网关功能。
    // 想要启动两个应用，达到集群效果的话，需要自己新增一个Configurations，并设置Active Profiles值为server2，然后启动两个应用

    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumerApplication.class, args);
    }

}
