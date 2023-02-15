package cn.j3code.luckyapp.record.query;

import cn.j3code.luckydomain.gateway.RecordGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-02-14 21:11
 **/
@Slf4j
@Component
@AllArgsConstructor
public class RecordMoneyParamQueryExe {

    private final RecordGateway recordGateway;

    public BigDecimal execute(Long recordId) {
        return recordGateway.getPrizeMoneyByRecordId(recordId);
    }
}
