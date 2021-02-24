package com.demo.txlcn.common.mapper;

import com.demo.txlcn.common.entity.Demo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * 描述：
 *
 * @author 含光
 * @email jarvan_best@163.com
 * @date 2021/2/24 3:13 下午
 * @company 数海掌讯
 */
@Mapper
public interface BaseDemoMapper {

    @Insert("insert into t_demo(kid, demo_field, group_id, create_time,app_name) values(#{kid}, #{demoField}, #{groupId}, #{createTime},#{appName})")
    void save(Demo demo);
}
