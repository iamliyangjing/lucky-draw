package cn.j3code.luckyclient.api;

import cn.j3code.luckyclient.dto.AwardAddCmd;
import cn.j3code.luckyclient.dto.AwardUpdateCmd;
import cn.j3code.luckyclient.dto.data.AwardVO;
import cn.j3code.luckyclient.dto.query.AwardListByParamQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-31 15:36
 **/
public interface IAwardService {

    AwardVO add(AwardAddCmd cmd);

    AwardVO update(AwardUpdateCmd cmd);

    AwardVO one(Long id);

    IPage<AwardVO> page(AwardListByParamQuery query);
}
