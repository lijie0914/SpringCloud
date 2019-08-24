package com.liuniukeji.springcloud.eureka_producer.controller;

import com.liuniukeji.springcloud.eureka_producer.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Jerry
 * @date : 2019/8/23 17:49
 * Title : SystemUserController
 * Description : SystemUserController
 */
@RestController
@RequestMapping("systemUser")
public class SystemUserController {

    private SystemUserService userService;

    @Autowired
    public SystemUserController(SystemUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/addMaster")
    public String addMaster() {
        userService.addMaster();
        return "success";
    }
}
