package cn.j3code.luckyinfrastructure.gateway.impl.mapper;

import cn.j3code.luckyclient.dto.query.PrizeListByParamQuery;
import cn.j3code.luckyinfrastructure.gateway.impl.dataobject.PrizeDB;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-31 15:00
 **/
public interface PrizeMapper extends BaseMapper<PrizeDB> {

    IPage<PrizeDB> page(@Param("page") Page<PrizeDB> prizeDBPage, @Param("query") PrizeListByParamQuery query);
}
