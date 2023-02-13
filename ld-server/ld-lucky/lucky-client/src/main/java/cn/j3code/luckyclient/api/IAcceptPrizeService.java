package cn.j3code.luckyclient.api;

import cn.j3code.luckyclient.dto.AcceptPrizeAddCmd;
import cn.j3code.luckyclient.dto.data.AcceptPrizeVO;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-02-12 23:32
 **/
public interface IAcceptPrizeService {

    AcceptPrizeVO one(Long recordId);

    AcceptPrizeVO add(AcceptPrizeAddCmd cmd);
}
