package cn.j3code.luckyapp.context;

import cn.j3code.luckyclient.dto.data.ActivityConfigVO;
import cn.j3code.luckyclient.dto.data.AwardVO;
import cn.j3code.luckydomain.award.AwardEntity;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-02-09 10:59
 **/
@Data
@Accessors(chain = true)
public class ActivityDrawContext {

    private ActivityConfigVO activityConfigVO;

    /**
     * 抽奖算法获得到的奖项
     */
    private AwardVO awardVO;
    /**
     * 抽奖算法获得到的奖项entity
     */
    private AwardEntity awardEntity;

    /**
     * 是否中奖,true:中奖
     */
    private Boolean isWinTheLottery;

}
