package cn.j3code.luckyapp.assembler;

import cn.j3code.config.util.SecurityUtil;
import cn.j3code.luckyclient.dto.PrizeAddCmd;
import cn.j3code.luckyclient.dto.PrizeUpdateCmd;
import cn.j3code.luckyclient.dto.data.PrizeVO;
import cn.j3code.luckydomain.prize.PrizeEntity;
import cn.j3code.luckydomain.prize.Tnventory;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-31 15:03
 **/
public class PrizeAssembler {
    public static PrizeEntity toAddEntity(PrizeAddCmd cmd) {
        PrizeEntity prizeEntity = new PrizeEntity();
        prizeEntity.setPrizeName(cmd.getPrizeName());
        prizeEntity.setInventory(new Tnventory(cmd.getInventory()));
        prizeEntity.setMoney(new BigDecimal(cmd.getMoney().toString()));
        prizeEntity.setType(cmd.getType());
        prizeEntity.setCreateTime(LocalDateTime.now());
        prizeEntity.setCreator(SecurityUtil.getName());
        prizeEntity.setUpdateTime(LocalDateTime.now());
        prizeEntity.setUpdater(SecurityUtil.getName());

        return prizeEntity;
    }

    public static PrizeVO toPrizeVO(PrizeEntity prizeEntity) {
        PrizeVO prizeVO = new PrizeVO();
        prizeVO.setId(prizeEntity.getId());
        prizeVO.setPrizeName(prizeEntity.getPrizeName());
        prizeVO.setInventory(prizeEntity.getInventory().getInventory());
        prizeVO.setMoney(new BigDecimal(prizeEntity.getMoney().toString()));
        prizeVO.setType(prizeEntity.getType());
        prizeVO.setCreateTime(prizeEntity.getCreateTime());
        prizeVO.setCreator(prizeEntity.getCreator());
        prizeVO.setUpdateTime(prizeEntity.getUpdateTime());
        prizeVO.setUpdater(prizeEntity.getUpdater());

        return prizeVO;
    }

    public static PrizeEntity toUpdateEntity(PrizeUpdateCmd cmd) {
        PrizeEntity prizeEntity = new PrizeEntity();
        prizeEntity.setId(cmd.getId());
        prizeEntity.setPrizeName(cmd.getPrizeName());
        prizeEntity.setInventory(new Tnventory(cmd.getInventory()));
        prizeEntity.setMoney(new BigDecimal(cmd.getMoney().toString()));
        prizeEntity.setType(cmd.getType());
        prizeEntity.setCreateTime(LocalDateTime.now());
        prizeEntity.setCreator(SecurityUtil.getName());
        prizeEntity.setUpdateTime(LocalDateTime.now());
        prizeEntity.setUpdater(SecurityUtil.getName());

        return prizeEntity;
    }
}
