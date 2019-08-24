package com.liuniukeji.springcloud.eureka_producer.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;

import java.util.List;
import java.util.Map;

/**
 * @author : Jerry
 * @date : 2019/8/19 11:02
 * Title : BaseJdbcDao
 * Description : jdbcTemplate baseDao
 */
public class BaseJdbcDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // TODO 缺少查询count的方法

    /**
     * update语句
     *
     * @param sql  语句
     * @param args 参数
     * @return sql执行影响数据条数
     */
    public int update(String sql, Object... args) {
        return jdbcTemplate.update(sql, args);
    }

    /**
     * insert语句
     *
     * @param sql  语句
     * @param args 参数
     * @return sql执行影响数据条数
     */
    public int insert(String sql, Object... args) {
        return this.update(sql, args);
    }

    /**
     * delete语句
     *
     * @param sql  语句
     * @param args 参数
     * @return sql执行影响数据条数
     */
    public int delete(String sql, Object... args) {
        return this.update(sql, args);
    }


    /**
     * list列表查询
     */
    @SuppressWarnings("unchecked")
    public <T> List<T> queryForList(String sql, Class<T> tClass, Object... args) {
        RowMapper<T> rowMapper;
        if (Map.class.isAssignableFrom(tClass)) {
            rowMapper = (RowMapper<T>) new ColumnMapRowMapper();
        } else if (String.class.equals(tClass) || Integer.class.equals(tClass) || Long.class.equals(tClass)) {
            rowMapper = new SingleColumnRowMapper<T>(tClass);
        } else {
            rowMapper = new BeanPropertyRowMapper<T>(tClass);
        }
        return jdbcTemplate.query(sql, rowMapper, args);
    }

    /**
     * 单个对象查询
     */
    public <T> T queryForObject(String sql, Class<T> tClass, Object... args) {
        List<T> list = this.queryForList(sql, tClass, args);
        return list == null || list.isEmpty() ? null : list.get(0);
    }
}
