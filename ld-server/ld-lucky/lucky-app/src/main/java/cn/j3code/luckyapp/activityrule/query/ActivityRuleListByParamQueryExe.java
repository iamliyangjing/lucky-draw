package cn.j3code.luckyapp.activityrule.query;

import cn.hutool.core.collection.CollectionUtil;
import cn.j3code.luckyapp.assembler.ActivityRuleAssembler;
import cn.j3code.luckyclient.dto.data.ActivityRuleVO;
import cn.j3code.luckyclient.dto.query.ActivityRuleListByParamQuery;
import cn.j3code.luckydomain.activityrule.ActivityRuleEntity;
import cn.j3code.luckydomain.gateway.ActivityRuleGateway;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-31 16:24
 **/
@Slf4j
@Component
@AllArgsConstructor
public class ActivityRuleListByParamQueryExe {

    private final ActivityRuleGateway activityRuleGateway;

    public List<ActivityRuleVO> execute(ActivityRuleListByParamQuery query) {
        List<ActivityRuleEntity> list = activityRuleGateway.list(query);

        if (CollectionUtil.isEmpty(list)) {
            return new ArrayList<>();
        }

        return new Page<ActivityRuleEntity>()
                .setRecords(list)
                .convert(ActivityRuleAssembler::toActivityRuleVO)
                .getRecords();
    }
}