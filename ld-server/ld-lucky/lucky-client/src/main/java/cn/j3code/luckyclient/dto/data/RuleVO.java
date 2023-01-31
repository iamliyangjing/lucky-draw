package cn.j3code.luckyclient.dto.data;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-31 15:05
 **/
@Data
public class RuleVO {
    /**
     *
     */
    private Long id;

    /**
     * 规则名称
     */
    private String ruleName;

    /**
     * 最大可参与次数
     */
    private Integer maxJoinNumber;

    /**
     * 最大可中奖次数
     */
    private Integer maxWinningNumber;

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

    private String updater;
}
