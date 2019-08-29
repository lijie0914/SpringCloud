package com.liuniukeji.apollo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Jerry
 * @date : 2019/8/28 14:15
 * Title : ApolloTestController
 * Description : ApolloTestController
 */
@RestController
public class ApolloTestController {

    /**
     * testName为apollo配置中心中配置的key
     * apollo为默认值，即当获取不到testName时name的默认值
     */
    @Value("${testName:apollo}")
    private String name;

    @RequestMapping("getName")
    public String getName() {
        return name;
    }
}
