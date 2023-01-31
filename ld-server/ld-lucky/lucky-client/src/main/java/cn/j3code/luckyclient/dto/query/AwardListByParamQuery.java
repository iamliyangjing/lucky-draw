package cn.j3code.luckyclient.dto.query;

import com.alibaba.cola.dto.PageQuery;
import lombok.Data;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-31 15:36
 **/
@Data
public class AwardListByParamQuery extends PageQuery {

    private Long id;

    private Long activityId;

    private String activityName;

    private String awardName;
}
