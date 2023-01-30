package cn.j3code.luckyapp.user.query;

import cn.j3code.luckyapp.assembler.UserAssembler;
import cn.j3code.luckyclient.dto.data.UserVO;
import cn.j3code.luckyclient.dto.query.UserLoginQuery;
import cn.j3code.luckydomain.gateway.UserGateway;
import cn.j3code.luckydomain.user.UserEntity;
import com.alibaba.cola.exception.SysException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-30 17:27
 **/
@Slf4j
@Component
@AllArgsConstructor
public class UserLoginQueryExe {

    private final UserGateway userGateway;

    /**
     *
     * @param query 参数
     * @return
     */
    public UserVO execute(UserLoginQuery query) {
        // 根据账号查询用户
        UserEntity userEntity = userGateway.findByUserName(null, query.getUsername());
        // 不存在报错
        if (Objects.isNull(userEntity)){
            throw new SysException("登录失败，用户不存在！");
        }
        // 判断用户密码
        if (userEntity.getPassword().isEqual(query.getPassword())) {
            return UserAssembler.toUserVO(userEntity);
        }
        return UserAssembler.toUserVO(userEntity);
    }
}
