package cn.j3code.luckyinfrastructure.gateway.impl.mapper;

import cn.j3code.luckyclient.dto.query.ActivityRuleListByParamQuery;
import cn.j3code.luckyinfrastructure.gateway.impl.dataobject.ActivityRuleDB;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: luck-draw
 * @description: 针对表【ld_activity_rule】的数据库操作Mapper
 * @author: lyj
 * @create: 2023-01-31 16:27
 **/
public interface ActivityRuleMapper extends BaseMapper<ActivityRuleDB> {

    List<ActivityRuleDB> list(@Param("query") ActivityRuleListByParamQuery query);

    void deleteByActivityId(@Param("activityId") Long activityId);
}
