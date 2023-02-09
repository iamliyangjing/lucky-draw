package cn.j3code.luckyapp.record.query;

import cn.j3code.luckyapp.assembler.RecordAssembler;
import cn.j3code.luckyclient.dto.data.RecordVO;
import cn.j3code.luckyclient.dto.query.RecordListByParamQuery;
import cn.j3code.luckydomain.gateway.RecordGateway;
import cn.j3code.luckydomain.record.RecordEntity;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-02-09 14:09
 **/
@Slf4j
@Component
@AllArgsConstructor
public class RecordListByParamQueryExe {

    private final RecordGateway recordGateway;

    public IPage<RecordVO> execute(RecordListByParamQuery query) {
        IPage<RecordEntity> page = recordGateway.page(query);
        return page.convert(RecordAssembler::toRecordVO);
    }
}
