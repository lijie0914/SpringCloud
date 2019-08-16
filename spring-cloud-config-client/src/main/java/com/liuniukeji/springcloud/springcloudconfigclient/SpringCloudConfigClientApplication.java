package com.liuniukeji.springcloud.springcloudconfigclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCloudConfigClientApplication {

    // 特别注意：与spring-cloud相关的属性必须配置在bootstrap.properties中，config部分内容才能被正确加载。
    // 因为config的相关配置会先于application.properties，而bootstrap.properties的加载也是先于application.properties。

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigClientApplication.class, args);
    }

}
