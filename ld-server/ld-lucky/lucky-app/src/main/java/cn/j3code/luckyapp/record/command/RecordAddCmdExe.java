package cn.j3code.luckyapp.record.command;

import cn.j3code.luckyapp.assembler.RecordAssembler;
import cn.j3code.luckyclient.dto.RecordAddCmd;
import cn.j3code.luckyclient.dto.data.RecordVO;
import cn.j3code.luckydomain.gateway.RecordGateway;
import cn.j3code.luckydomain.record.RecordEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-02-09 14:09
 **/
@Slf4j
@Component
@AllArgsConstructor
public class RecordAddCmdExe {

    private final RecordGateway recordGateway;

    public RecordVO execute(RecordAddCmd cmd) {
        RecordEntity entity = recordGateway.save(RecordAssembler.toAddEntity(cmd));

        return RecordAssembler.toRecordVO(entity);
    }
}