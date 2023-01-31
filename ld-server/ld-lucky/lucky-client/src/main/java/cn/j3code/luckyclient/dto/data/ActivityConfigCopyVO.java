package cn.j3code.luckyclient.dto.data;

import cn.j3code.luckyclient.dto.ActivityAddCmd;
import cn.j3code.luckyclient.dto.AwardAddCmd;
import lombok.Data;

import java.util.List;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-31 17:30
 **/
@Data
public class ActivityConfigCopyVO {
    private ActivityAddCmd activityAddCmd;

    private List<Long> ruleIdList;

    private List<AwardAddCmd> awardAddCmdList;
}