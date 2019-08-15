package com.liuniukeji.springcloud.eureka_consumer.feign_fallback;

import com.liuniukeji.springcloud.eureka_consumer.feign.testFeign;
import org.springframework.stereotype.Component;

/**
 * @author : Jerry
 * @date : 2019/8/15 8:48
 * Title : testFeignFallback
 * Description : testFeign降级处理类
 */
@Component
public class testFeignFallback implements testFeign {

    // testFeign中生产者服务的降级处理类，当服务调用失败时返回当前实现类中方法的返回值

    @Override
    public String hello(String name) {
        return "hello 我是默认数据";
    }
}
