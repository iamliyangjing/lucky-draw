package cn.j3code.luckyapp.activity.query;

import cn.j3code.luckyapp.assembler.ActivityAssembler;
import cn.j3code.luckyclient.dto.data.ActivityVO;
import cn.j3code.luckyclient.dto.query.ActivityListByParamQuery;
import cn.j3code.luckydomain.activity.ActivityEntity;
import cn.j3code.luckydomain.gateway.ActivityGateway;
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
public class ActivityListByParamQueryExe {

    private final ActivityGateway activityGateway;

    public IPage<ActivityVO> execute(ActivityListByParamQuery query) {
        IPage<ActivityEntity> page = activityGateway.page(query);

        return page.convert(ActivityAssembler::toActivityVO);
    }
}

