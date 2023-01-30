package cn.j3code.luckyadapter.web.admin;

import cn.j3code.common.annotation.ResponseResult;
import cn.j3code.luckyclient.api.IUserService;
import cn.j3code.luckyclient.dto.data.UserVO;
import cn.j3code.luckyclient.dto.query.UserListByParamQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-30 23:25
 **/
@Slf4j
@AllArgsConstructor
@ResponseResult
@RequestMapping("/admin/v1/user")
public class AdminUserController {

    private final IUserService userService;

    @PostMapping("/page")
    public IPage<UserVO> page(@RequestBody UserListByParamQuery query) {
        return userService.page(query);
    }


    @GetMapping("/one")
    public UserVO one(@RequestParam(value = "id") Long id) {
        return userService.one(id);
    }
}
