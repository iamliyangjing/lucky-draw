package cn.j3code.luckyinfrastructure.gateway.impl.mapper;

import cn.j3code.luckyclient.dto.query.RecordListByParamQuery;
import cn.j3code.luckyinfrastructure.gateway.impl.dataobject.RecordDB;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-02-09 14:02
 **/
public interface RecordMapper extends BaseMapper<RecordDB> {

    IPage<RecordDB> page(@Param("recordDBPage") Page<RecordDB> recordDBPage, @Param("query") RecordListByParamQuery query);

    Integer updateStatus(@Param("id") Long id, @Param("status") Integer status);

}
