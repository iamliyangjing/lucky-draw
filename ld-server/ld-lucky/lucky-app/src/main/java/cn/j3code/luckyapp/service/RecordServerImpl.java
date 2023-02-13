package cn.j3code.luckyapp.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.j3code.config.util.AssertUtil;
import cn.j3code.luckyapp.record.command.RecordAddCmdExe;
import cn.j3code.luckyapp.record.command.RecordUpdateStatusCmdExe;
import cn.j3code.luckyapp.record.query.RecordListByParamQueryExe;
import cn.j3code.luckyclient.api.IRecordServer;
import cn.j3code.luckyclient.dto.RecordAddCmd;
import cn.j3code.luckyclient.dto.RecordUpdateStatusCmd;
import cn.j3code.luckyclient.dto.data.RecordVO;
import cn.j3code.luckyclient.dto.query.RecordListByParamQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-02-09 14:11
 **/
@Slf4j
@Service
@AllArgsConstructor
public class RecordServerImpl implements IRecordServer {

    private final RecordAddCmdExe recordAddCmdExe;
    private final RecordUpdateStatusCmdExe recordUpdateStatusCmdExe;
    private final RecordListByParamQueryExe recordListByParamQueryExe;


    @Override
    public IPage<RecordVO> page(RecordListByParamQuery query) {
        return recordListByParamQueryExe.execute(query);
    }

    @Override
    public RecordVO add(RecordAddCmd cmd) {
        return recordAddCmdExe.execute(cmd);
    }

    @Override
    public Boolean update(RecordUpdateStatusCmd cmd) {
        return recordUpdateStatusCmdExe.execute(cmd);
    }

    @Override
    public Integer prizeType(Long recordId) {
        final var recordQuery =   new RecordListByParamQuery();
        recordQuery.setRecordId(recordId);

        List<RecordVO> recordVOList = recordListByParamQueryExe.execute(recordQuery).getRecords();

        AssertUtil.isTrue(CollectionUtil.isEmpty(recordVOList) || Objects.isNull(recordVOList.get(0)),"数据不存在!");

        return recordVOList.get(0).getPrizeType();
    }
}
