package cn.j3code.luckyclient.dto;

import com.alibaba.cola.dto.Command;
import lombok.Data;

import java.util.List;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-31 16:14
 **/
@Data
public class ActivityConfigUpdateCmd extends Command {

    private ActivityUpdateCmd activityUpdateCmd;

    private List<Long> ruleIdList;

    private List<AwardUpdateCmd> awardUpdateCmdList;
}

