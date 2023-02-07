package cn.j3code.luckyinfrastructure.gateway.impl.mapper;

import cn.j3code.luckyclient.dto.query.AwardListByParamQuery;
import cn.j3code.luckyinfrastructure.gateway.impl.dataobject.AwardDB;
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
public interface AwardMapper extends BaseMapper<AwardDB> {

    IPage<AwardDB> page(@Param("awardDBPage") Page<AwardDB> awardDBPage, @Param("query") AwardListByParamQuery query);

    int deductionAwardNumber(@Param("awardId") Long awardId, @Param("number") Integer number);
}



