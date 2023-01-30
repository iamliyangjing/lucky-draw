package cn.j3code.luckydomain.gateway;

import cn.j3code.luckyclient.dto.query.UserListByParamQuery;
import cn.j3code.luckydomain.user.UserEntity;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-30 16:02
 **/
public interface UserGateway {

    UserEntity save(UserEntity entity);

    UserEntity findByUserName(Long id,String username);

    IPage<UserEntity> listByParamQuery(UserListByParamQuery query);
}
