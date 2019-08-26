package com.liuniukeji.springcloud.eureka_consumer.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TDemo {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String kid;
    private String groupId;
    private String demoField;
    private String appName;
    private Date createTime;

}
