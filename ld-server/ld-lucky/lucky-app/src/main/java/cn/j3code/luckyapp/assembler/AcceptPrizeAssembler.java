package cn.j3code.luckyapp.assembler;

import cn.j3code.config.util.SecurityUtil;
import cn.j3code.luckyclient.dto.AcceptPrizeAddCmd;
import cn.j3code.luckyclient.dto.data.AcceptPrizeVO;
import cn.j3code.luckydomain.acceptprize.AcceptPrizeEntity;

import java.time.LocalDateTime;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-02-13 22:56
 **/
public class AcceptPrizeAssembler {

    public static AcceptPrizeEntity toEntity(AcceptPrizeAddCmd cmd) {
        AcceptPrizeEntity entity = new AcceptPrizeEntity();
        entity.setRecordId(cmd.getRecordId());
        entity.setPhone(cmd.getPhone());
        entity.setAddress(cmd.getAddress());
        entity.setCreateTime(LocalDateTime.now());
        entity.setCreator(SecurityUtil.getUserName());
        entity.setUpdateTime(LocalDateTime.now());
        entity.setUpdater(SecurityUtil.getUserName());

        return entity;
    }

    public static AcceptPrizeVO toAcceptPrizeVO(AcceptPrizeEntity entity) {
        AcceptPrizeVO acceptPrizeVO = new AcceptPrizeVO();
        acceptPrizeVO.setId(entity.getId());
        acceptPrizeVO.setPhone(entity.getPhone());
        acceptPrizeVO.setAddress(entity.getAddress());
        acceptPrizeVO.setCreateTime(entity.getCreateTime());

        return acceptPrizeVO;
    }
}
