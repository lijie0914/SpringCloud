package com.liuniukeji.apollo;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableApolloConfig
@SpringBootApplication
public class ApolloApplication {

    //@EnableApolloConfig 开启阿波罗配置中心

    public static void main(String[] args) {
        SpringApplication.run(ApolloApplication.class, args);
    }

}
