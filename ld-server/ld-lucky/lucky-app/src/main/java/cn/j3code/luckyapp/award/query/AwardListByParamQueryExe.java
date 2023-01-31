package cn.j3code.luckyapp.award.query;

import cn.j3code.luckyapp.assembler.AwardAssembler;
import cn.j3code.luckyclient.dto.data.AwardVO;
import cn.j3code.luckyclient.dto.query.AwardListByParamQuery;
import cn.j3code.luckydomain.award.AwardEntity;
import cn.j3code.luckydomain.gateway.AwardGateway;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-31 15:47
 **/
@Slf4j
@Component
@AllArgsConstructor
public class AwardListByParamQueryExe {
    private final AwardGateway awardGateway;

    public IPage<AwardVO> execute(AwardListByParamQuery query) {
        IPage<AwardEntity> page = awardGateway.page(query);

        return page.convert(AwardAssembler::toAwardVO);
    }
}
