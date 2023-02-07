package cn.j3code.luckyapp.activity.command;

import cn.j3code.luckyapp.assembler.AwardAssembler;
import cn.j3code.luckyclient.dto.data.ActivityConfigVO;
import cn.j3code.luckyclient.dto.data.ActivityVO;
import cn.j3code.luckyclient.dto.data.AwardVO;
import cn.j3code.luckyclient.dto.data.DrawResultVO;
import cn.j3code.luckydomain.award.AwardEntity;

import java.util.List;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-31 17:42
 **/
public abstract class BaseDrawExe {

    public DrawResultVO execute(ActivityConfigVO activityConfigVO) {
        // 校验活动时间
        checkActivityTime(activityConfigVO.getActivityVO());
        // 校验活动规则
        checkActivityRule(activityConfigVO);
        // 剔除奖项库存为空的项
        List<AwardVO> awardVOList = removeAwardInventoryNull(activityConfigVO.getAwardVOList());
        // 调用抽奖算法进行抽奖
        AwardVO awardVO = getAward(awardVOList);

        AwardEntity awardEntity = AwardAssembler.toAwardEntity(awardVO);
        if (!awardEntity.isPrize()) {
            return getDrawResultVO(awardEntity);
        }
        // 扣减奖项库存
        if (deductionAwardNumber(awardEntity.getId(), 1) != 1) {
            return getDefaultDrawResultVO(awardVOList);
        }
        // 插入获奖记录
        addAcceptPrize(activityConfigVO.getActivityVO().getId(), awardEntity);
        // 返回结果
        return getDrawResultVO(awardEntity);
    }

    protected abstract void addAcceptPrize(Long id, AwardEntity awardEntity);

    protected abstract DrawResultVO getDefaultDrawResultVO(List<AwardVO> awardVOList);

    protected abstract int deductionAwardNumber(Long awardId, Integer number);

    protected abstract DrawResultVO getDrawResultVO(AwardEntity awardEntity);

    protected abstract AwardVO getAward(List<AwardVO> awardVOList);

    protected abstract List<AwardVO> removeAwardInventoryNull(List<AwardVO> awardVOList);

    protected abstract void checkActivityRule(ActivityConfigVO activityConfigVO);

    protected abstract void checkActivityTime(ActivityVO activityVO);
}