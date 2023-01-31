package cn.j3code.luckyclient.dto;

import com.alibaba.cola.dto.Command;
import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.NotNull;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyclient.dto
 * @createTime 2022/11/26 - 23:43
 * @description
 */
@Data
@Getter
public class UserUpdateCmd extends Command {

    @NotNull(message = "id不为空")
    private Long id;

    /**
     * 账号
     */
    @NotNull(message = "账号不为空")
    private String username;

    /**
     * 姓名
     */
    @NotNull(message = "姓名不为空")
    private String name;

    private String password;
    /**
     * 电话
     */
    @NotNull(message = "电话不为空")
    private String phone;

}
