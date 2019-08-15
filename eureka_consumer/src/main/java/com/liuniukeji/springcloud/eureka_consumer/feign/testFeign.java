package com.liuniukeji.springcloud.eureka_consumer.feign;

import com.liuniukeji.springcloud.eureka_consumer.feign_fallback.testFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author : Jerry
 * @date : 2019/8/14 16:07
 * Title : testFeign
 * Description : feign集成测试类，fallback = testFeignFallback.class指定服务降级处理类，
 * 需要在配置文件中开启feign的降级功能，开启方式：feign.hystrix.enabled=true
 */
@FeignClient(name = "demo-api", fallback = testFeignFallback.class)
public interface testFeign {

    // @FeignClient(name= "demo-api") 这里的name值要和注册到服务中心的服务名称service-id一致
    // @RequestMapping(value = "/test/test2") 这里的value是要调用的服务的路径，hello方法中的参数要和被调用的服务参数一致
    // 即最终会得到类似testController中test1方法的url的值demo-api/test/test2
    @RequestMapping(value = "/test/test2")
    public String hello(@RequestParam(value = "name") String name);
}
