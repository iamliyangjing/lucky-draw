package cn.j3code.luckyapp.prize.command;

import cn.j3code.luckyapp.assembler.PrizeAssembler;
import cn.j3code.luckyclient.dto.PrizeUpdateCmd;
import cn.j3code.luckyclient.dto.data.PrizeVO;
import cn.j3code.luckydomain.gateway.PrizeGateway;
import cn.j3code.luckydomain.prize.PrizeEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-31 14:55
 **/
@Slf4j
@Component
@AllArgsConstructor
public class PrizeUpdateCmdExe {

    private final PrizeGateway prizeGateway;

    public PrizeVO execute(PrizeUpdateCmd cmd) {
        PrizeEntity prizeEntity = prizeGateway.save(PrizeAssembler.toUpdateEntity(cmd));

        return PrizeAssembler.toPrizeVO(prizeEntity);
    }
}