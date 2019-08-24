package com.liuniukeji.springcloud.eureka_producer.entity;


import lombok.Data;

/**
 * @author
 * @version 1.0
 * @Title: SystemUser
 * @Description: 系统用户表 实体类
 * @date 2018-11-16 13:32:42
 */
@Data
public class SystemUser {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
}