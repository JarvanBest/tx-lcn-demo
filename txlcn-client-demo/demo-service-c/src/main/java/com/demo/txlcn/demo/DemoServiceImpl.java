package com.demo.txlcn.demo;

import com.codingapi.txlcn.common.util.Transactions;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.codingapi.txlcn.tracing.TracingContext;
import com.demo.txlcn.common.entity.Demo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 描述：
 *
 * @author 含光
 * @email jarvan_best@163.com
 * @date 2021/2/24 3:29 下午
 * @company 数海掌讯
 */
@Service
public class DemoServiceImpl implements DemoService {
    @Resource
    private DemoMapper demoMapper;

    @LcnTransaction
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String rpcServiceC(String value, String exFlag, String flag) {
        Demo demo = new Demo();
        demo.setGroupId(TracingContext.tracing().groupId());
        demo.setDemoField(value);
        demo.setAppName(Transactions.getApplicationId());
        demo.setCreateTime(new Date());
        demoMapper.save(demo);
        if ("exception-c".equals(value)) {
            throw new IllegalStateException("exception by test");
        }
        return "ok-service-c";
    }
}
