package com.demo.txlcn.demo;

import com.codingapi.txlcn.common.util.Transactions;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.codingapi.txlcn.tracing.TracingContext;
import com.demo.txlcn.common.entity.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Objects;

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
    @Autowired
    private RestTemplate template;


    @LcnTransaction
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String execute(String value, String exFlag, String flag) {
        String dResp = template.getForObject("http://localhost:12012/txlcn?value=" + value, String.class);

        // step2. call remote ServiceB
        String eResp = template.getForObject("http://localhost:12013/txlcn?value=" + value, String.class);
        // step3. execute local transaction
        Demo demo = new Demo();
        demo.setGroupId(TracingContext.tracing().groupId());
        demo.setDemoField(value);
        demo.setCreateTime(new Date());
        demo.setAppName(Transactions.getApplicationId());
        demoMapper.save(demo);

        // 置异常标志，DTX 回滚
        if (Objects.nonNull(exFlag)) {
            throw new IllegalStateException("by exFlag");
        }

        return dResp + " > " + eResp + " > " + "ok-service-a";
    }
}
