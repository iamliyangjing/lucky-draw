package cn.j3code.luckyinfrastructure.gateway.impl;

import cn.j3code.luckydomain.gateway.UserGateway;
import cn.j3code.luckydomain.user.UserEntity;
import cn.j3code.luckyinfrastructure.convertor.UserConvertor;
import cn.j3code.luckyinfrastructure.gateway.impl.dataobject.UserDB;
import cn.j3code.luckyinfrastructure.gateway.impl.mapper.UserMapper;
import com.alibaba.cola.exception.SysException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-30 16:14
 **/
@Slf4j
@Component
@AllArgsConstructor
public class UserGatewayImpl implements UserGateway {

    private final UserMapper userMapper;

    @Override
    public UserEntity save(UserEntity entity) {
        UserDB userDB = UserConvertor.toUserDB(entity);

        int insert = userMapper.insert(userDB);
        if (insert<=0){
            throw new SysException("注册失败！");
        }
        return UserConvertor.toEntity(userDB);
    }

    @Override
    public UserEntity findByUserName(Long id, String username) {
        UserDB userDB = userMapper.findByUserName(id, username);
        if (Objects.isNull(userDB)){
            return null;
        }
        return UserConvertor.toEntity(userDB);
    }
}
