package cn.j3code.luckyapp.activity.command;

import cn.j3code.luckyapp.assembler.ActivityAssembler;
import cn.j3code.luckyclient.dto.ActivityAddCmd;
import cn.j3code.luckyclient.dto.data.ActivityVO;
import cn.j3code.luckydomain.activity.ActivityEntity;
import cn.j3code.luckydomain.gateway.ActivityGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-31 15:46
 **/
@Slf4j
@Component
@AllArgsConstructor
public class ActivityAddCmdExe {

    private final ActivityGateway activityGateway;

    public ActivityVO execute(ActivityAddCmd cmd) {
        ActivityEntity entity = activityGateway.save(ActivityAssembler.toAddEntity(cmd));

        return ActivityAssembler.toActivityVO(entity);
    }
}
