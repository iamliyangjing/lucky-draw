package cn.j3code.luckyapp.assembler;

import cn.j3code.luckyclient.dto.UserRegisterCmd;
import cn.j3code.luckyclient.dto.data.UserVO;
import cn.j3code.luckyclient.dto.UserUpdateCmd;
import cn.j3code.luckydomain.user.PassWord;
import cn.j3code.luckydomain.user.UserEntity;
import cn.j3code.luckydomain.user.UserName;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-30 16:08
 **/
public class UserAssembler {
    public static UserEntity toAddEntity(UserRegisterCmd cmd) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(new UserName(cmd.getUsername()));
        userEntity.setPassword(new PassWord(new PassWord.EncryptionPassWord(PassWord.getEncryptionPassWord(cmd.getPassword()))));
        userEntity.setName(cmd.getName());
        userEntity.setPhone(cmd.getPhone());
        userEntity.setCreateTime(LocalDateTime.now());
        userEntity.setUpdateTime(LocalDateTime.now());

        return userEntity;
    }

    public static UserVO toUserVO(UserEntity entity) {
        UserVO userVO = new UserVO();
        userVO.setId(entity.getId());
        userVO.setUsername(entity.getUsername().getUsername());
        userVO.setName(entity.getName());
        userVO.setPhone(entity.getPhone());
        userVO.setCreateTime(entity.getCreateTime());
        userVO.setUpdateTime(entity.getUpdateTime());

        return userVO;
    }

    public static UserEntity toUpdateEntity(UserUpdateCmd cmd) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(cmd.getId());
        userEntity.setUsername(new UserName(cmd.getUsername()));
        if (Objects.nonNull(cmd.getPassword())){
            userEntity.setPassword(new PassWord(new PassWord.EncryptionPassWord(PassWord.getEncryptionPassWord(cmd.getPassword()))));
        }
        userEntity.setName(cmd.getName());
        userEntity.setPhone(cmd.getPhone());
        userEntity.setUpdateTime(LocalDateTime.now());

        return userEntity;
    }
}
