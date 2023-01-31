package cn.j3code.luckyinfrastructure.gateway.impl.mapper;

import cn.j3code.luckyclient.dto.query.ActivityListByParamQuery;
import cn.j3code.luckyinfrastructure.gateway.impl.dataobject.ActivityDB;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-31 15:50
 **/
public interface ActivityMapper extends BaseMapper<ActivityDB> {
    /**
     * 分页查询
     * @param activityDBPage
     * @param query
     * @return
     */
    IPage<ActivityDB> page(@Param("activityDBPage") Page<ActivityDB> activityDBPage, @Param("query") ActivityListByParamQuery query);
}



