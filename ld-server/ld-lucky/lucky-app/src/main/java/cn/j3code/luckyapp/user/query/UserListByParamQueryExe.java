package cn.j3code.luckyapp.user.query;

import cn.j3code.luckyapp.assembler.UserAssembler;
import cn.j3code.luckyclient.dto.data.UserVO;
import cn.j3code.luckyclient.dto.query.UserListByParamQuery;
import cn.j3code.luckydomain.gateway.UserGateway;
import cn.j3code.luckydomain.user.UserEntity;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-30 22:40
 **/
@Slf4j
@Component
@AllArgsConstructor
public class UserListByParamQueryExe {

    private final UserGateway userGateway;


    public IPage<UserVO> excute(UserListByParamQuery query) {
        IPage<UserEntity> entityIPage = userGateway.listByParamQuery(query);
        return entityIPage.convert(UserAssembler::toUserVO);
    }
}
