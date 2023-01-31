package cn.j3code.luckydomain.gateway;

import cn.j3code.config.exception.LdException;
import cn.j3code.luckyclient.dto.query.PrizeListByParamQuery;
import cn.j3code.luckydomain.prize.PrizeEntity;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-31 14:57
 **/
public interface PrizeGateway {


    PrizeEntity save(PrizeEntity entity);

    IPage<PrizeEntity> page(PrizeListByParamQuery query);
    default PrizeEntity one(Long id) {
        final var query = new PrizeListByParamQuery();
        query.setId(id);
        PrizeEntity prizeEntity = null;
        try {
            prizeEntity = page(query).getRecords().get(0);
        } catch (Exception e) {
            //错误处理
            throw new LdException(String.format("奖品id：%s，不存在！", id));
        }
        return prizeEntity;
    }
    int deductionInventory(Long prizeId, Integer number);

}
