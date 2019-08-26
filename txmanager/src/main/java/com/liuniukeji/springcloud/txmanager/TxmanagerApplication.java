package com.liuniukeji.springcloud.txmanager;

import com.codingapi.txlcn.tm.config.EnableTransactionManagerServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableTransactionManagerServer
@SpringBootApplication
public class TxmanagerApplication {

    /**
     * TX-LCN分布式事务框架
     * 参考文档：http://www.txlcn.org/zh-cn/docs/preface.html
     */

    public static void main(String[] args) {
        SpringApplication.run(TxmanagerApplication.class, args);
    }

}
