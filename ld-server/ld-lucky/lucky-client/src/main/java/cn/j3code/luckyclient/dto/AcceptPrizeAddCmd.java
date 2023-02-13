package cn.j3code.luckyclient.dto;

import com.alibaba.cola.dto.Command;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-02-12 23:33
 **/
@Data
public class AcceptPrizeAddCmd extends Command {

    @NotNull(message = "抽奖记录Id不为空")
    private Long recordId;

    /**
     * 电话
     */
    @NotNull(message = "电话不为空")
    private String phone;

    /**
     * 地址
     */
    @NotNull(message = "地址不为空")
    private String address;
}
