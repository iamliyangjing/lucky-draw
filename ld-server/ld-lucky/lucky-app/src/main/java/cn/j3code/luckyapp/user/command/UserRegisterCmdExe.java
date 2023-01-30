package cn.j3code.luckyapp.user.command;

import cn.j3code.luckyapp.assembler.UserAssembler;
import cn.j3code.luckyclient.dto.UserRegisterCmd;
import cn.j3code.luckyclient.dto.data.UserVO;
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
 * @create: 2023-01-30 15:52
 **/
@Slf4j
@Component
@AllArgsConstructor
public class UserRegisterCmdExe {

    private final UserGateway userGateway;

    public UserVO execute(UserRegisterCmd cmd){
        /**
         * 1.校验用户名是否存在
         * 2.注册
         */
        UserEntity lodEntity = userGateway.findByUserName(null,cmd.getUsername());
        if (Objects.nonNull(lodEntity)){
            throw new SysException("账号存在!");
        }

        UserEntity userEntity = UserAssembler.toAddEntity(cmd);
        //...
        UserEntity entity = userGateway.save(userEntity);
        return UserAssembler.toUserVO(entity);
    }
}
