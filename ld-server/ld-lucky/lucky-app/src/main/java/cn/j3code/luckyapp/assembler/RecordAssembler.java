package cn.j3code.luckyapp.assembler;

import cn.j3code.config.util.SecurityUtil;
import cn.j3code.luckyclient.dto.RecordAddCmd;
import cn.j3code.luckyclient.dto.data.RecordVO;
import cn.j3code.luckydomain.record.RecordEntity;
import cn.j3code.luckydomain.record.RecordStatus;

import java.time.LocalDateTime;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-02-09 14:06
 **/
public class RecordAssembler {
    public static RecordEntity toAddEntity(RecordAddCmd cmd) {
        RecordEntity recordEntity = new RecordEntity();
        recordEntity.setId(cmd.getId());
        recordEntity.setUserId(cmd.getUserId());
        recordEntity.setActivityId(cmd.getActivityId());
        recordEntity.setActivityName(cmd.getActivityName());
        recordEntity.setAwardId(cmd.getAwardId());
        recordEntity.setIsWinning(cmd.getIsWinning());
        recordEntity.setState(new RecordStatus(cmd.getState()));
        recordEntity.setCreateTime(LocalDateTime.now());
        recordEntity.setCreator(SecurityUtil.getName());
        recordEntity.setUpdateTime(LocalDateTime.now());
        recordEntity.setUpdater(SecurityUtil.getName());

        return recordEntity;
    }

    public static RecordVO toRecordVO(RecordEntity entity) {
        RecordVO recordVO = new RecordVO();
        recordVO.setAwardName(entity.getAwardName());
        recordVO.setPrizeName(entity.getPrizeName());
        recordVO.setId(entity.getId());
        recordVO.setUserId(entity.getUserId());
        recordVO.setActivityId(entity.getActivityId());
        recordVO.setActivityName(entity.getActivityName());
        recordVO.setAwardId(entity.getAwardId());
        recordVO.setIsWinning(entity.getIsWinning());
        recordVO.setState(entity.getState().getState());
        recordVO.setCreateTime(entity.getCreateTime());
        recordVO.setCreator(entity.getCreator());
        recordVO.setUpdateTime(entity.getUpdateTime());
        recordVO.setUpdater(entity.getUpdater());
        recordVO.setPrizeType(entity.getPrizeType());


        return recordVO;
    }
}