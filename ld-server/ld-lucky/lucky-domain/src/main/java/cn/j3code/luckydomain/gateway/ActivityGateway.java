package cn.j3code.luckydomain.gateway;

import cn.j3code.luckyclient.dto.query.ActivityListByParamQuery;
import cn.j3code.luckydomain.activity.ActivityEntity;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-31 15:43
 **/
public interface ActivityGateway {

    ActivityEntity save(ActivityEntity entity);


    IPage<ActivityEntity> page(ActivityListByParamQuery query);

}
