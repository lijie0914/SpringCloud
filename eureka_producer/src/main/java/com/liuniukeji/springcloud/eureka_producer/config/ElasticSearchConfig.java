package com.liuniukeji.springcloud.eureka_producer.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
@PropertySource(value = "classpath:elasticsearch.properties")
public class ElasticSearchConfig {
    private static final Logger logger = LoggerFactory.getLogger(ElasticSearchConfig.class);

    @Value("${elasticsearch.host}")
    private String hostName;

    @Value("${elasticsearch.port}")
    private Integer transport;

    @Value("${elasticsearch.cluster.name}")
    private String clusterName;

    @Bean
    public TransportClient transportClient() {
        logger.info("ElasticSearch初始化开始");

        TransportClient transportClient = null;

        try {
            TransportAddress transportAddress = new TransportAddress(InetAddress.getByName(hostName), Integer.valueOf(transport));

            //配置信息
            Settings settings = Settings.builder().put("cluster.name", clusterName).build();

            //配置信息Settings自定义
            transportClient = new PreBuiltTransportClient(settings);

            transportClient.addTransportAddress(transportAddress);
        } catch (UnknownHostException e) {
            logger.error("ElasticSearch初始化错误", e);
        }
        logger.info("ElasticSearch初始化完毕");
        return transportClient;
    }
}

