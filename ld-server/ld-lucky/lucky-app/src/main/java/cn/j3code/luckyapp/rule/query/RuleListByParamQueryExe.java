package cn.j3code.luckyapp.rule.query;

import cn.j3code.luckyapp.assembler.RuleAssembler;
import cn.j3code.luckyclient.dto.data.RuleVO;
import cn.j3code.luckyclient.dto.query.RuleListByParamQuery;
import cn.j3code.luckydomain.gateway.RuleGateway;
import cn.j3code.luckydomain.rule.RuleEntity;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-31 15:12
 **/
@Slf4j
@Component
@AllArgsConstructor
public class RuleListByParamQueryExe {

    private final RuleGateway ruleGateway;

    public IPage<RuleVO> execute(RuleListByParamQuery query) {
        IPage<RuleEntity> page = ruleGateway.page(query);

        return page.convert(RuleAssembler::toRuleVO);
    }
}