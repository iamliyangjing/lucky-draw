package cn.j3code.luckyapp.service;

import cn.hutool.core.collection.CollUtil;
import cn.j3code.luckyapp.rule.command.RuleAddCmdExe;
import cn.j3code.luckyapp.rule.command.RuleUpdateCmdExe;
import cn.j3code.luckyapp.rule.query.RuleListByParamQueryExe;
import cn.j3code.luckyclient.api.IRuleService;
import cn.j3code.luckyclient.dto.RuleAddCmd;
import cn.j3code.luckyclient.dto.RuleUpdateCmd;
import cn.j3code.luckyclient.dto.data.RuleVO;
import cn.j3code.luckyclient.dto.query.RuleListByParamQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-31 15:12
 **/
@Slf4j
@Service
@AllArgsConstructor
public class RuleServiceImpl implements IRuleService {

    private final RuleAddCmdExe ruleAddCmdExe;
    private final RuleUpdateCmdExe ruleUpdateCmdExe;
    private final RuleListByParamQueryExe ruleListByParamQueryExe;


    @Override
    public RuleVO add(RuleAddCmd cmd) {
        return ruleAddCmdExe.execute(cmd);
    }

    @Override
    public RuleVO update(RuleUpdateCmd cmd) {
        return ruleUpdateCmdExe.execute(cmd);
    }

    @Override
    public RuleVO one(Long id) {
        final var query = new RuleListByParamQuery();
        query.setId(id);
        IPage<RuleVO> page = page(query);
        if (CollUtil.isEmpty(page.getRecords())) {
            return null;
        }
        return page.getRecords().get(0);
    }

    @Override
    public IPage<RuleVO> page(RuleListByParamQuery query) {
        return ruleListByParamQueryExe.execute(query);
    }
}
