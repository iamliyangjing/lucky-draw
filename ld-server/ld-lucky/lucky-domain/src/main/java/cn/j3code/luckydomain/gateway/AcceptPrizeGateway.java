package cn.j3code.luckydomain.gateway;

import cn.j3code.luckydomain.acceptprize.AcceptPrizeEntity;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-02-12 23:29
 **/
public interface AcceptPrizeGateway {

    AcceptPrizeEntity save(AcceptPrizeEntity toEntity);

    AcceptPrizeEntity one(Long recordId);
}
