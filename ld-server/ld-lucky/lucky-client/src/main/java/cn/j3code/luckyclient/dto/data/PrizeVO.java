package cn.j3code.luckyclient.dto.data;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-31 14:44
 **/
@Data
public class PrizeVO {

    /**
     *
     */
    private Long id;

    /**
     * 奖品名称
     */
    private String prizeName;

    /**
     * 库存
     */
    private Integer inventory;

    /**
     * 金额
     */
    private BigDecimal money;

    /**
     * 类型（1：商品，2：金钱）
     */
    private Integer type;

    /**
     *
     */
    private LocalDateTime createTime;

    /**
     *
     */
    private String creator;

    /**
     *
     */
    private LocalDateTime updateTime;

    /**
     *
     */
    private String updater;

}