package cn.j3code.luckyapp.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.j3code.config.exception.LdException;
import cn.j3code.config.util.JwtUtil;
import cn.j3code.luckyapp.user.command.UserRegisterCmdExe;
import cn.j3code.luckyapp.user.command.UserUpdateCmdExe;
import cn.j3code.luckyapp.user.query.UserListByParamQueryExe;
import cn.j3code.luckyapp.user.query.UserLoginQueryExe;
import cn.j3code.luckyclient.api.IUserService;
import cn.j3code.luckyclient.dto.UserRegisterCmd;
import cn.j3code.luckyclient.dto.data.UserVO;
import cn.j3code.luckyclient.dto.query.UserListByParamQuery;
import cn.j3code.luckyclient.dto.query.UserLoginQuery;
import cn.j3code.luckyclient.dto.UserUpdateCmd;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-29 22:16
 **/
@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    /**
     * （构造器注入： 循环依赖不能解决,交给java工程师解决）
     * 体系就是高度内聚
     */
    private final UserRegisterCmdExe userRegisterCmdExe;
    private final UserLoginQueryExe userLoginQueryExe;
    private final UserListByParamQueryExe userListByParamQueryExe;
    private final UserUpdateCmdExe userUpdateCmdExe;
    @Override
    public UserVO register(UserRegisterCmd cmd) {
        return userRegisterCmdExe.execute(cmd);
    }

    @Override
    public String login(UserLoginQuery query) {
        UserVO userVO = userLoginQueryExe.execute(query);
         return JwtUtil.createToken(Map.of("name",userVO.getName(),"phone",userVO.getPhone()));
    }

    @Override
    public IPage<UserVO> page(UserListByParamQuery query) {
        return userListByParamQueryExe.excute(query);
    }

    @Override
    public UserVO one(Long id) {
        final var query = new UserListByParamQuery();
        query.setId(id);
        IPage<UserVO> iPage =  userListByParamQueryExe.excute(query);
        if (CollectionUtil.isEmpty(iPage.getRecords())){
            throw new LdException("该用户不存在");
        }
        return iPage.getRecords().get(0);
    }

    @Override
    public UserVO update(UserUpdateCmd cmd) {
        return userUpdateCmdExe.execute(cmd);
    }
}
