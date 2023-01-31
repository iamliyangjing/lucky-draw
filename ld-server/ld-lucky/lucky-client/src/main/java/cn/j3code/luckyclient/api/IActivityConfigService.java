package cn.j3code.luckyclient.api;

import cn.j3code.luckyclient.dto.ActivityConfigAddCmd;
import cn.j3code.luckyclient.dto.ActivityConfigUpdateCmd;
import cn.j3code.luckyclient.dto.data.ActivityConfigCopyVO;
import cn.j3code.luckyclient.dto.data.ActivityConfigVO;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-31 16:13
 **/
public interface IActivityConfigService {

    ActivityConfigVO add(ActivityConfigAddCmd cmd);

    ActivityConfigVO update(ActivityConfigUpdateCmd cmd);

    ActivityConfigVO one(Long id);

    ActivityConfigCopyVO copy(Long id);

}