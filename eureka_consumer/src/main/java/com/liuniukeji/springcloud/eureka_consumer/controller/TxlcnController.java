package com.liuniukeji.springcloud.eureka_consumer.controller;

import com.liuniukeji.springcloud.eureka_consumer.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Jerry
 * @date : 2019/8/24 14:41
 * Title : txlcnController
 * Description : txlcnController
 */
@RestController
public class TxlcnController {
    private final DemoService demoService;

    @Autowired
    public TxlcnController(DemoService demoService) {
        this.demoService = demoService;
    }

    @RequestMapping("/txlcn")
    public String execute(
            @RequestParam("value") String value,
            @RequestParam(value = "ex", required = false) String exFlag) {
        return demoService.execute(value, exFlag);
    }
}
