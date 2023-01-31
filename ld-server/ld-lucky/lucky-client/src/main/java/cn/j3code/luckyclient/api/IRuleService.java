package cn.j3code.luckyclient.api;

import cn.j3code.luckyclient.dto.RuleAddCmd;
import cn.j3code.luckyclient.dto.RuleUpdateCmd;
import cn.j3code.luckyclient.dto.data.RuleVO;
import cn.j3code.luckyclient.dto.query.RuleListByParamQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-31 15:04
 **/
public interface IRuleService {

    RuleVO add(RuleAddCmd cmd);

    RuleVO update(RuleUpdateCmd cmd);

    RuleVO one(Long id);

    IPage<RuleVO> page(RuleListByParamQuery query);

}