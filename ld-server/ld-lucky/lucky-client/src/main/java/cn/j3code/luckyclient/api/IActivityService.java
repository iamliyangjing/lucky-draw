package cn.j3code.luckyclient.api;

import cn.j3code.luckyclient.dto.ActivityAddCmd;
import cn.j3code.luckyclient.dto.ActivityUpdateCmd;
import cn.j3code.luckyclient.dto.data.ActivityVO;
import cn.j3code.luckyclient.dto.data.DrawResultVO;
import cn.j3code.luckyclient.dto.query.ActivityListByParamQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-31 15:35
 **/
public interface IActivityService {

    ActivityVO add(ActivityAddCmd cmd);

    ActivityVO update(ActivityUpdateCmd cmd);


    IPage<ActivityVO> page(ActivityListByParamQuery query);

    ActivityVO one(Long id);

    /**
     * 用户抽奖接口
     * @param activityId
     * @return
     */
    DrawResultVO draw(Long activityId);
}