package cn.j3code.luckyclient.api;

import cn.j3code.luckyclient.dto.ActivityRuleAddCmd;
import cn.j3code.luckyclient.dto.data.ActivityRuleVO;
import cn.j3code.luckyclient.dto.query.ActivityRuleListByParamQuery;

import java.util.List;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-31 16:13
 **/
public interface IActivityRuleService {

    ActivityRuleVO add(ActivityRuleAddCmd cmd);

    List<ActivityRuleVO> list(ActivityRuleListByParamQuery query);
}
