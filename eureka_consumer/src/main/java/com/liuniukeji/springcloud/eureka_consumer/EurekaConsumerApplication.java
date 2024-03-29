package com.liuniukeji.springcloud.eureka_consumer;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import com.liuniukeji.springcloud.eureka_consumer.filter.TokenFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableDistributedTransaction
@EnableHystrixDashboard
@EnableFeignClients
@EnableZuulProxy
@EnableHystrix
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
@MapperScan("com.liuniukeji.springcloud.eureka_consumer.mapper")
public class EurekaConsumerApplication {

    /**
     * Spring Boot/Spring Cloud时代后，应用开发基本遵循三板斧：加依赖！加配置！加注解！业务代码该咋写还咋写！
     * 一、启动类注解作用：
     * // 1、@EnableCircuitBreaker 启动断路器（和@EnableHystrix功能一样，两者选一即可）
     * // 2、@EnableHystrixDashboard 开启对Hystrix的实时监控
     * // 3、@EnableFeignClients 开启feign 服务调用
     * // 4、@EnableZuulProxy 声明开启zuul API网关
     * // 5、@EnableHystrix 开启Hystrix熔断器功能 （和@EnableCircuitBreaker功能一样，两者选一即可）
     * // 6、@EnableDistributedTransaction 开启事务客户端
     * PS：从Spring Cloud Edgware版本开始，eureka的服务提供者/服务消费者的启动类上不需要添加@EnableDiscoveryClient 或@EnableEurekaClient
     * 二、当前应用为服务消费者，负责消费（即调用）eureka中的服务生产者
     * 三、整合组件：
     * 1、整合ribbon实现了本地的负载均衡（ribbon也支持通过restTemplate实现服务调用）
     * 2、整合hystrix实现了服务调用的容错保护机制以及基于restTemplate方式实现的服务降级功能
     * 3、整合hystrix-dashboard实现了对hystrix的实时监控可视化界面（访问地址：http://localhost:9001/hystrix）
     * 4、整合feign实现了服务调用（ribbon也支持通过restTemplate实现服务调用）以及基于hystrix的服务降级功能
     * 5、整合zuul实现了API网关功能
     * 6、整合ZipKin & Sleuth实现服务链路追踪功能
     * 6.1、整合ZipKin & Sleuth组件，能看到所有微服务直接的调用关系，所有接口的访问详情，包括节点、耗时等等信息，就是一种对整个分布式微服务架构提供监控分析的功能。
     * 6.2、服务端：官方提供了在ZipKin Server服务的jar，直接下载运行即可，地址：https://zipkin.io/pages/quickstart ，找到latest release 进行下载，
     * 下载完成之后，打开cmd命令台，执行java -jar zipkin-server-xxx.jar 启动 ZipKin Server 应用，启动成功之后，访问地址http://localhost:9411/
     * 6.3、客户端：只需要添加依赖、添加配置即可
     * 7、整合TX-LCN分布式事务框架实现了分布式事务
     */

    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumerApplication.class, args);
    }

    @Bean
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }
}
