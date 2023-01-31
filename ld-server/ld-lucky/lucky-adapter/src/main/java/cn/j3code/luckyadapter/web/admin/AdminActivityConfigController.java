package cn.j3code.luckyadapter.web.admin;

import cn.j3code.common.annotation.ResponseResult;
import cn.j3code.luckyclient.api.IActivityConfigService;
import cn.j3code.luckyclient.dto.ActivityConfigAddCmd;
import cn.j3code.luckyclient.dto.ActivityConfigUpdateCmd;
import cn.j3code.luckyclient.dto.data.ActivityConfigCopyVO;
import cn.j3code.luckyclient.dto.data.ActivityConfigVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-31 16:50
 **/
@Slf4j
@AllArgsConstructor
@ResponseResult
@RequestMapping("/admin/v1/activityConfig")
public class AdminActivityConfigController {

    private final IActivityConfigService activityConfigService;

    @PostMapping("/add")
    public ActivityConfigVO add(@Validated @RequestBody ActivityConfigAddCmd cmd){
        return activityConfigService.add(cmd);
    }

    @PostMapping("/update")
    public ActivityConfigVO update(@Validated @RequestBody ActivityConfigUpdateCmd cmd){
        return activityConfigService.update(cmd);
    }
    @GetMapping("/one")
    public ActivityConfigVO one(@RequestParam("id") Long id){
        return activityConfigService.one(id);
    }
    @GetMapping("/copy")
    public ActivityConfigCopyVO copy(@RequestParam("id") Long id){
        return activityConfigService.copy(id);
    }
}
