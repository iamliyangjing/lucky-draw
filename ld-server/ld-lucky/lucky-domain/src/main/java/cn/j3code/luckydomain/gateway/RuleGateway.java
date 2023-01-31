package cn.j3code.luckydomain.gateway;

import cn.j3code.luckyclient.dto.query.RuleListByParamQuery;
import cn.j3code.luckydomain.rule.RuleEntity;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-31 15:15
 **/
public interface RuleGateway {


    RuleEntity save(RuleEntity entity);

    IPage<RuleEntity> page(RuleListByParamQuery query);

}
