package cn.j3code.luckyclient.dto.data;

import lombok.Data;

import java.util.List;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-31 16:16
 **/
@Data
public class ActivityConfigVO {

    private ActivityVO activityVO;

    private List<RuleVO> ruleVOList;

    private List<AwardVO> awardVOList;
}