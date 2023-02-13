package cn.j3code.luckyapp.acceptprize.query;

import cn.j3code.luckyapp.assembler.AcceptPrizeAssembler;
import cn.j3code.luckyclient.dto.data.AcceptPrizeVO;
import cn.j3code.luckydomain.acceptprize.AcceptPrizeEntity;
import cn.j3code.luckydomain.gateway.AcceptPrizeGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-02-13 22:56
 **/
@Component
@Slf4j
@AllArgsConstructor
public class AcceptPrizeOneExe {

    private final AcceptPrizeGateway acceptPrizeGateway;


    public AcceptPrizeVO execute(Long recordId) {
        AcceptPrizeEntity entity = acceptPrizeGateway.one(recordId);

        return AcceptPrizeAssembler.toAcceptPrizeVO(entity);
    }
}

