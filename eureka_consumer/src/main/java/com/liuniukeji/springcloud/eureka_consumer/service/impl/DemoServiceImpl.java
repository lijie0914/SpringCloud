package com.liuniukeji.springcloud.eureka_consumer.service.impl;

import com.codingapi.txlcn.common.util.Transactions;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.codingapi.txlcn.tc.core.DTXLocalContext;
import com.liuniukeji.springcloud.eureka_consumer.entity.TDemo;
import com.liuniukeji.springcloud.eureka_consumer.feign.TestFeign;
import com.liuniukeji.springcloud.eureka_consumer.mapper.TDemoMapper;
import com.liuniukeji.springcloud.eureka_consumer.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Objects;

/**
 * @author : Jerry
 * @date : 2019/8/24 14:43
 * Title : DemoServiceImpl
 * Description : DemoServiceImpl
 */
@Service
@Slf4j
public class DemoServiceImpl implements DemoService {

    private final TDemoMapper demoMapper;

    private final TestFeign testFeign;

    @Autowired
    public DemoServiceImpl(TDemoMapper demoMapper, TestFeign testFeign) {
        this.demoMapper = demoMapper;
        this.testFeign = testFeign;
    }

    @Override
    @LcnTransaction //分布式事务注解
    @Transactional //本地事务注解
    public String execute(String value, String exFlag) {

        String testTransaction = testFeign.testTransaction(value);

        // Local transaction
        TDemo demo = new TDemo();
        demo.setGroupId(DTXLocalContext.getOrNew().getGroupId());
        demo.setDemoField(value);
        demo.setAppName(Transactions.APPLICATION_ID_WHEN_RUNNING);
        demo.setCreateTime(new Date());
        demoMapper.insertTDemo(demo);

        // 置异常标志，DTX 回滚
        if (Objects.nonNull(exFlag)) {
            throw new IllegalStateException("by exFlag");
        }
        return testTransaction + " > " + "Local transaction";
    }
}
