package cn.j3code.luckyclient.dto.query;

import com.alibaba.cola.dto.PageQuery;
import lombok.Data;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-02-09 13:59
 **/
@Data
public class RecordListByParamQuery extends PageQuery {

    private Long userId;

    private Long activityId;

    /**
     * true：中奖，false：未中奖
     */
    private Boolean winTheLottery;


    private Integer status;
}
