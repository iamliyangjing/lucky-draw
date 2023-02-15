package cn.j3code.luckydomain.gateway;

import cn.j3code.luckyclient.dto.query.RecordListByParamQuery;
import cn.j3code.luckydomain.record.RecordEntity;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.math.BigDecimal;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-02-09 14:03
 **/
public interface RecordGateway {

    RecordEntity save(RecordEntity entity);

    IPage<RecordEntity> page(RecordListByParamQuery query);

    Boolean updateStatus(Long id, Integer status);

    BigDecimal getPrizeMoneyByRecordId(Long recordId);

}