package cn.j3code.luckyinfrastructure.gateway.impl.mapper;

import cn.j3code.luckyinfrastructure.gateway.impl.dataobject.AcceptPrizeDB;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-02-13 22:06
 **/
public interface AcceptPrizeMapper extends BaseMapper<AcceptPrizeDB> {

    AcceptPrizeDB getByRecordId(@Param("recordId") Long recordId);
}

