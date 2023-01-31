package cn.j3code.luckydomain.gateway;

import cn.j3code.luckyclient.dto.query.ActivityRuleListByParamQuery;
import cn.j3code.luckydomain.activityrule.ActivityRuleEntity;

import java.util.List;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-31 16:17
 **/
public interface ActivityRuleGateway {

    ActivityRuleEntity save(ActivityRuleEntity entity);

    List<ActivityRuleEntity> list(ActivityRuleListByParamQuery query);

    void deleteByActivityId(Long activityId);
}