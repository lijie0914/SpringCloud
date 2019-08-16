package com.liuniukeji.springcloud.springcloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class SpringCloudConfigServerApplication {

    // @EnableConfigServer 开启对配置中心的支持
    // 访问地址： http://localhost:8001/jerry-config/dev/
    // 也可以直接访问文件内容： http://localhost:8001/jerry-config-dev.properties

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigServerApplication.class, args);
    }

}
