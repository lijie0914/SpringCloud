package com.liuniukeji.springcloud.eureka_consumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author : Jerry
 * @date : 2019/8/5 17:02
 * Title : RibbonConfig
 * Description : ribbon配置，将普通的restTemplate和开启负载之后的restTemplate注入到spring容器中
 */
@Configuration
public class RibbonConfig {
    /**
     * 注解@LoadBalanced：开启Ribbon的负载模式，开启后Ribbon将拦截RestTemplate发起的请求，并实现负载均衡
     * 需要请求eureka中服务的注入ribbonRestTemplate去请求
     */
    @Bean
    @LoadBalanced
    public RestTemplate ribbonRestTemplate() {
        return new RestTemplate();
    }

    /**
     * 其他非eureka中的服务请求使用restTemplate去请求
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
