package cn.j3code.luckyapp.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.j3code.config.util.AssertUtil;
import cn.j3code.config.util.SecurityUtil;
import cn.j3code.luckyapp.award.query.AwardListByParamQueryExe;
import cn.j3code.luckyapp.prize.query.PrizeListByParamQueryExe;
import cn.j3code.luckyapp.record.command.RecordAddCmdExe;
import cn.j3code.luckyapp.record.command.RecordUpdateStatusCmdExe;
import cn.j3code.luckyapp.record.query.RecordListByParamQueryExe;
import cn.j3code.luckyapp.record.query.RecordMoneyParamQueryExe;
import cn.j3code.luckyclient.api.IRecordServer;
import cn.j3code.luckyclient.dto.RecordAddCmd;
import cn.j3code.luckyclient.dto.RecordUpdateStatusCmd;
import cn.j3code.luckyclient.dto.data.AwardVO;
import cn.j3code.luckyclient.dto.data.RecordVO;
import cn.j3code.luckyclient.dto.query.AwardListByParamQuery;
import cn.j3code.luckyclient.dto.query.RecordListByParamQuery;
import cn.j3code.luckyclient.feign.WalletFeignApi;
import cn.j3code.luckyclient.feign.form.UpdateWalletForm;
import cn.j3code.luckyclient.feign.vo.WalletUpdateResultVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
public class RecordServiceImpl implements IRecordServer {

    private final RecordAddCmdExe recordAddCmdExe;
    private final RecordUpdateStatusCmdExe recordUpdateStatusCmdExe;
    private final RecordListByParamQueryExe recordListByParamQueryExe;
    private final RecordMoneyParamQueryExe recordMoneyParamQueryExe;
    private final WalletFeignApi walletFeignApi;

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
        return getPrizeByRecordId(recordId).getPrizeType();
    }

    public RecordVO getPrizeByRecordId(Long recordId) {
        final var recordQuery = new RecordListByParamQuery();
        recordQuery.setRecordId(recordId);

        List<RecordVO> recordVOList = recordListByParamQueryExe.execute(recordQuery).getRecords();
        AssertUtil.isTrue(CollUtil.isEmpty(recordVOList) || Objects.isNull(recordVOList.get(0)), "??????????????????");

        return recordVOList.get(0);
    }

    @Override
    public Boolean exchangeMoney(Long recordId) {

        RecordVO recordVO = getPrizeByRecordId(recordId);
        AssertUtil.isTrue(recordVO.getPrizeType() != 2, "???????????????????????????");

        AssertUtil.isTrue(recordVO.getState() != 1, "?????????????????????");

        // ??????????????????
        BigDecimal money = recordMoneyParamQueryExe.execute(recordId);

        // ????????????????????????4
        final var statusCmd = new RecordUpdateStatusCmd();
        statusCmd.setId(recordId);
        statusCmd.setState(4);
        update(statusCmd);

        try {
            // TODO: ?????????????????????????????????
            final var walletForm = new UpdateWalletForm();
            walletForm.setUpdateMoney(money);
            walletForm.setUserId(SecurityUtil.getUserId());
            WalletUpdateResultVO walletUpdateResultVO = walletFeignApi.updateBalance(walletForm);

            if (Boolean.FALSE.equals(walletUpdateResultVO.getResult())) {
                return Boolean.FALSE;
            }
        } catch (Exception e) {
            //????????????
            log.error("???????????????????????????????????????", e);

            // ??????????????????
            statusCmd.setState(1);
            update(statusCmd);

            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }


}
