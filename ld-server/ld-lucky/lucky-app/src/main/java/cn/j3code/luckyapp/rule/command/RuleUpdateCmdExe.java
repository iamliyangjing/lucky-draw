package cn.j3code.luckyapp.rule.command;

import cn.j3code.luckyapp.assembler.RuleAssembler;
import cn.j3code.luckyclient.dto.RuleUpdateCmd;
import cn.j3code.luckyclient.dto.data.RuleVO;
import cn.j3code.luckydomain.gateway.RuleGateway;
import cn.j3code.luckydomain.rule.RuleEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-31 15:14
 **/
@Slf4j
@Component
@AllArgsConstructor
public class RuleUpdateCmdExe {

    private final RuleGateway ruleGateway;

    public RuleVO execute(RuleUpdateCmd cmd) {
        RuleEntity save = ruleGateway.save(RuleAssembler.toUpdateEntity(cmd));

        return RuleAssembler.toRuleVO(save);
    }
}
