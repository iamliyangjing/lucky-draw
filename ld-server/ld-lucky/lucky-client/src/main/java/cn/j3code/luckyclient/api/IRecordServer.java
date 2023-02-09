package cn.j3code.luckyclient.api;

import cn.j3code.luckyclient.dto.RecordAddCmd;
import cn.j3code.luckyclient.dto.RecordUpdateStatusCmd;
import cn.j3code.luckyclient.dto.data.RecordVO;
import cn.j3code.luckyclient.dto.query.RecordListByParamQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-02-09 14:00
 **/
public interface IRecordServer {

    IPage<RecordVO> page(RecordListByParamQuery query);

    RecordVO add(RecordAddCmd cmd);

    Boolean update(RecordUpdateStatusCmd cmd);
}
