package cn.j3code.luckydomain.gateway;

import cn.j3code.luckyclient.dto.query.AwardListByParamQuery;
import cn.j3code.luckydomain.award.AwardEntity;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-31 15:44
 **/
public interface AwardGateway {

    AwardEntity save(AwardEntity entity);

    IPage<AwardEntity> page(AwardListByParamQuery query);

}
