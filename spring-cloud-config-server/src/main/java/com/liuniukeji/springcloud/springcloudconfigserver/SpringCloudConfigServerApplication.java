package com.liuniukeji.springcloud.springcloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class SpringCloudConfigServerApplication {

    // @EnableConfigServer 开启对配置中心的支持
    // 访问地址： http://localhost:8001/jerry-config/dev/ 即 http://localhost:8001/{application}/{profile}
    // 也可以直接访问文件内容： http://localhost:8001/jerry-config-dev.yml 即 http://localhost:8001/{application}-{profile}.yml
    // 其他访问规则：{label} 对应git的分支名，{application}对应应用配置名，{profile}对应配置环境名
    // 1、/{application}/{profile}[/{label}]
    // 2、/{application}-{profile}.yml
    // 3、/{label}/{application}-{profile}.yml
    // 4、/{application}-{profile}.properties
    // 5、/{label}/{application}-{profile}.properties
    // 想要启动两个应用，达到集群效果的话，需要自己新增一个Configurations，并设置VM options值为-Dserver.port=8003，然后启动两个应用，达到提供高可用的server端支持

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigServerApplication.class, args);
    }

}
