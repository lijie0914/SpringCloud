package com.liuniukeji.springcloud.eureka_consumer.mapper;

import com.liuniukeji.springcloud.eureka_consumer.entity.TDemo;

import java.util.List;

public interface TDemoMapper {
    public TDemo selectTDemoById(Long id);

    public List<TDemo> selectTDemoList(TDemo tDemo);

    public int insertTDemo(TDemo tDemo);

    public int updateTDemo(TDemo tDemo);

    public int deleteTDemoById(Long id);

    public int deleteTDemoByIds(String[] ids);
}
