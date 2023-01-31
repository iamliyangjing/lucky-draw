package cn.j3code.luckyclient.dto;

import com.alibaba.cola.dto.Command;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-31 14:46
 **/
@Data
public class PrizeUpdateCmd extends Command {
    /**
     *
     */
    @NotNull(message = "id不为空")
    private Long id;

    /**
     * 奖品名称
     */
    @NotNull(message = "奖品名称不为空")
    private String prizeName;

    /**
     * 库存
     */
    @NotNull(message = "库存不为空")
    private Integer inventory;

    /**
     * 金额
     */
    @NotNull(message = "金额不为空")
    private BigDecimal money;

    /**
     * 类型（1：商品，2：金钱）
     */
    @NotNull(message = "类型不为空")
    private Integer type;
}
