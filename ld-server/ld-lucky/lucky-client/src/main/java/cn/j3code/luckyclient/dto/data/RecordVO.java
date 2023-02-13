package cn.j3code.luckyclient.dto.data;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-02-09 13:59
 **/
@Data
public class RecordVO {

    /**
     *
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 活动id
     */
    private Long activityId;

    private String activityName;

    /**
     * 奖项id
     */
    private Long awardId;

    private String awardName;

    private String prizeName;

    private Integer prizeType;

    /**
     * 是否中奖：0未中奖，1中奖
     */
    private Integer isWinning;

    /**
     * 状态（0，1，2，3）
     */
    private Integer state;

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
