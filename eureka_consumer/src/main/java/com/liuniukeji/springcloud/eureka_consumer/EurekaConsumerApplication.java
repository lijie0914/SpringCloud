package com.liuniukeji.springcloud.eureka_consumer;

import com.liuniukeji.springcloud.eureka_consumer.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

//@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableFeignClients
@EnableZuulProxy
@EnableHystrix
@SpringBootApplication
public class EurekaConsumerApplication {

    // @EnableCircuitBreaker 启动断路器 （和@EnableHystrix功能一样，两者选一即可）
    // @EnableHystrixDashboard 开启对Hystrix的实时监控
    // @EnableFeignClients 开启feign 服务调用
    // @EnableZuulProxy 声明开启zuul API网关
    // @EnableHystrix 开启Hystrix熔断器功能 （和@EnableCircuitBreaker功能一样，两者选一即可）
    // PS：从Spring Cloud Edgware版本开始，eureka的服务提供者/服务消费者的启动类上不需要添加@EnableDiscoveryClient 或@EnableEurekaClient
    // 当前应用为服务消费者，负责消费（即调用）eureka中的服务生产者，
    // 同时还整合ribbon实现了本地的负载均衡，
    // 整合hystrix实现了服务调用的容错保护机制（基于restTemplate方式实现的服务降级功能），
    // 整合hystrix-dashboard实现了对hystrix的实时监控可视化界面（访问地址：http://localhost:9001/hystrix）
    // 整合feign实现了服务调用（ribbon也支持通过restTemplate实现服务调用）以及基于hystrix的服务降级功能，
    // 整合zuul实现了API网关功能。

    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumerApplication.class, args);
    }

    @Bean
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }
}
