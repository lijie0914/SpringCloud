package com.liuniukeji.springcloud.eureka_producer.service;


import com.liuniukeji.springcloud.eureka_producer.entity.SystemUser;

/**
 * @author
 * @version 1.0
 * @Title: SystemUserService
 * @Description: 系统用户表 业务服务层接口
 * @date 2018-11-16 13:47:41
 */
public interface SystemUserService {

    SystemUser findUserById(Long id);

    SystemUser findByUsername(String userName);

    void add();

    void addMaster();
}
