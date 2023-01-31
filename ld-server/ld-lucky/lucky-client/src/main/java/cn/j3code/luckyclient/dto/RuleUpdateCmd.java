package cn.j3code.luckyclient.dto;

import com.alibaba.cola.dto.Command;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-31 15:06
 **/
@Data
public class RuleUpdateCmd extends Command {
    /**
     *
     */
    @NotNull(message = "id不为空")
    private Long id;

    /**
     * 规则名称
     */
    @NotNull(message = "名称不为空")
    private String ruleName;

    /**
     * 最大可参与次数
     */
    @NotNull(message = "参与次数不为空")
    private Integer maxJoinNumber;

    /**
     * 最大可中奖次数
     */
    @NotNull(message = "中奖次数不为空")
    private Integer maxWinningNumber;
}
