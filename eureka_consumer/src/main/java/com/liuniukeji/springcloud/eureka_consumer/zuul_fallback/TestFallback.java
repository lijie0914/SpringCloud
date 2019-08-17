package com.liuniukeji.springcloud.eureka_consumer.zuul_fallback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author : Jerry
 * @date : 2019/8/17 11:13
 * Title : TestFallback
 * Description : TestFallback
 */
@Component
public class TestFallback implements FallbackProvider {

    // 路由熔断功能，当服务出现异常时，返回我们预设的信息
    // Zuul 目前只支持服务级别的熔断，不支持具体到某个URL进行熔断，即路由熔断只能处理整个微服务应用异常，而非服务内单个方法异常
    // 个人理解：当 Application 的 Status 处于 DOWN 状态时，去请求此 Application 服务时会实现路由熔断

    private final Logger logger = LoggerFactory.getLogger(FallbackProvider.class);

    @Override
    public String getRoute() {
        // 指定要处理的 service-id
        return "demo-api";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        if (cause != null && cause.getCause() != null) {
            String reason = cause.getCause().getMessage();
            logger.info("--->>> ZuulFallback Excption {}", reason);
        }
        return fallbackResponse();
    }

    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return 200;
            }

            @Override
            public String getStatusText() throws IOException {
                return "OK";
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("The service is unavailable.".getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }
}
