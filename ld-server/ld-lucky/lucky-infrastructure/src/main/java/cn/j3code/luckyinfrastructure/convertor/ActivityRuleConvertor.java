package cn.j3code.luckyinfrastructure.convertor;

import cn.j3code.luckydomain.activityrule.ActivityRuleEntity;
import cn.j3code.luckyinfrastructure.gateway.impl.dataobject.ActivityRuleDB;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-31 16:27
 **/
public class ActivityRuleConvertor {
    public static ActivityRuleDB toActivityRuleDB(ActivityRuleEntity entity) {
        ActivityRuleDB activityRuleDB = new ActivityRuleDB();
        activityRuleDB.setId(entity.getId());
        activityRuleDB.setActivityId(entity.getActivityId());
        activityRuleDB.setRuleId(entity.getRuleId());
        activityRuleDB.setCreateTime(entity.getCreateTime());
        activityRuleDB.setCreator(entity.getCreator());
        activityRuleDB.setUpdateTime(entity.getUpdateTime());
        activityRuleDB.setUpdater(entity.getUpdater());

        return activityRuleDB;
    }

    public static ActivityRuleEntity toEntity(ActivityRuleDB activityRuleDB) {
        ActivityRuleEntity activityRuleEntity = new ActivityRuleEntity();
        activityRuleEntity.setId(activityRuleDB.getId());
        activityRuleEntity.setActivityId(activityRuleDB.getActivityId());
        activityRuleEntity.setRuleId(activityRuleDB.getRuleId());
        activityRuleEntity.setCreateTime(activityRuleDB.getCreateTime());
        activityRuleEntity.setCreator(activityRuleDB.getCreator());
        activityRuleEntity.setUpdateTime(activityRuleDB.getUpdateTime());
        activityRuleEntity.setUpdater(activityRuleDB.getUpdater());

        return activityRuleEntity;
    }
}
