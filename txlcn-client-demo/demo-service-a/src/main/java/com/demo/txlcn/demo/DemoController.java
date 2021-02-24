package com.demo.txlcn.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：
 *
 * @author 含光
 * @email jarvan_best@163.com
 * @date 2021/2/24 3:26 下午
 * @company 数海掌讯
 */
@RestController
public class DemoController {

    private final DemoService demoService;

    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    /**
     * 正常情况返回 ok-service-b > ok-service-c > ok-service-a
     * http://localhost:12011/txlcn?value=4561
     * @param value 保存值
     * @param exFlag 是否抛出异常
     * @param flag
     * @return
     */
    @RequestMapping("/txlcn")
    public String execute(@RequestParam("value") String value, @RequestParam(value = "ex", required = false) String exFlag
            , @RequestParam(value = "f", required = false) String flag) {
        return demoService.execute(value, exFlag, flag);
    }
}
