package com.liuniukeji.springcloud.eureka_producer.service.impl;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.liuniukeji.springcloud.eureka_producer.entity.SystemUser;
import com.liuniukeji.springcloud.eureka_producer.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @author
 * @version 1.0
 * @Title: SystemUserServiceImpl
 * @Description: 系统用户表 业务服务层实现
 * @date 2018-11-16 13:47:41
 */
@Service
public class SystemUserServiceImpl implements SystemUserService {

    // jdbcTemplate方式查询数据库
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public SystemUser findUserById(Long id) {
        SystemUser user = jdbcTemplate.queryForObject("select * from system_user where id = ? ",
                new BeanPropertyRowMapper<SystemUser>(SystemUser.class), id);
        return user;
    }

    @Override
    public SystemUser findByUsername(String userName) {
        SystemUser user = jdbcTemplate.queryForObject("select * from system_user where username = ? ",
                new BeanPropertyRowMapper<SystemUser>(SystemUser.class), userName);
        return user;
    }

    @Override
    @DS("slave")
    public void add() {
        jdbcTemplate.execute("insert into system_user (username,password) values ('jerry','111')");
    }

    @Override
    @DS("master")
    public void addMaster(String value) {
        jdbcTemplate.update("insert into system_user (username,password) values ('jerry',?)", new String[]{value});
    }
}
