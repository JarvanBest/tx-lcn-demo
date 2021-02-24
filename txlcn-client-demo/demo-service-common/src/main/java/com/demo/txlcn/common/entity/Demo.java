package com.demo.txlcn.common.entity;

import com.codingapi.txlcn.common.util.id.RandomUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 描述：
 *
 * @author 含光
 * @email jarvan_best@163.com
 * @date 2021/2/24 3:13 下午
 * @company 数海掌讯
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Demo {
    private Long id;
    private String kid = RandomUtils.randomKey();
    private String demoField;
    private String groupId;
    private Date createTime;
    private String appName;
}
