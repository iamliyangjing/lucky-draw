package cn.j3code.luckyapp.activityrule.command;

import cn.j3code.luckydomain.gateway.ActivityRuleGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-31 16:23
 **/
@Slf4j
@Component
@AllArgsConstructor
public class ActivityRuleDeleteExe {

    private final ActivityRuleGateway activityRuleGateway;

    public void execute(Long activityId) {
        activityRuleGateway.deleteByActivityId(activityId);
    }
}