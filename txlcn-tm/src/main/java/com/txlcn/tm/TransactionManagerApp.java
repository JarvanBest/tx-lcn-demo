package com.txlcn.tm;

import com.codingapi.txlcn.tm.config.EnableTransactionManagerServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 描述：
 *
 * @author 含光
 * @email jarvan_best@163.com
 * @date 2021/2/24 2:59 下午
 * @company 数海掌讯
 */
@SpringBootApplication
@EnableTransactionManagerServer
public class TransactionManagerApp {
    public static void main(String[] args) {
        SpringApplication.run(TransactionManagerApp.class, args);
    }
}
