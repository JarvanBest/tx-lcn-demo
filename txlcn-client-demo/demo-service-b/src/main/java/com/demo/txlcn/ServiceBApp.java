package com.demo.txlcn;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 描述：
 *
 * @author 含光
 * @email jarvan_best@163.com
 * @date 2021/2/24 3:37 下午
 * @company 数海掌讯
 */
@SpringBootApplication
@EnableDistributedTransaction
public class ServiceBApp {
    public static void main(String[] args) {
        SpringApplication.run(ServiceBApp.class, args);
    }
}
