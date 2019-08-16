package com.liuniukeji.springcloud.springcloudconfigclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCloudConfigClientApplication {

    // 特别注意：与spring-cloud相关的属性必须配置在bootstrap.properties中，config部分内容才能被正确加载。
    // 因为config的相关配置会先于application.properties，而bootstrap.properties的加载也是先于application.properties。
    // 实现refresh功能四部曲：
    // 1、添加actuator依赖，
    // 2、添加@RefreshScope注解，
    // 3、添加management.endpoints.web.exposure.include=refresh配置文件，
    // 4、然后在配置文件更新了之后使用post请求调用http://localhost:8002/actuator/refresh

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigClientApplication.class, args);
    }

}
