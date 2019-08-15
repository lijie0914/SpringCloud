package com.liuniukeji.springcloud.eureka_consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableZuulProxy
@EnableHystrix
@SpringBootApplication
public class EurekaConsumerApplication {

    // @EnableFeignClients 开启feign
    // @EnableZuulProxy 声明开启zuul
    // @EnableHystrix 开启Hystrix熔断器功能
    // PS：从Spring Cloud Edgware版本开始，eureka的服务提供者/服务消费者的启动类上不需要添加@EnableDiscoveryClient 或@EnableEurekaClient
    // 当前应用为服务消费者，负责消费（即调用）eureka中的服务生产者，
    // 同时还整合ribbon实现了本地的负载均衡，
    // 整合feign实现了服务调用（ribbon也支持通过restTemplate实现服务调用），
    // 整合hystrix实现了服务调用的容错保护机制，
    // 整合zuul实现了API网关功能。

    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumerApplication.class, args);
    }

}
