package cn.j3code.luckydomain.gateway;

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

}
