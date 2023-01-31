package cn.j3code.luckyapp.award.command;

import cn.j3code.luckyapp.assembler.AwardAssembler;
import cn.j3code.luckyclient.dto.AwardAddCmd;
import cn.j3code.luckyclient.dto.data.AwardVO;
import cn.j3code.luckydomain.award.AwardEntity;
import cn.j3code.luckydomain.gateway.AwardGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-31 15:47
 **/
@Slf4j
@Component
@AllArgsConstructor
public class AwardAddCmdExe {

    private final AwardGateway awardGateway;

    public AwardVO execute(AwardAddCmd cmd) {
        AwardEntity entity = awardGateway.save(AwardAssembler.toAddEntity(cmd));

        return AwardAssembler.toAwardVO(entity);
    }
}