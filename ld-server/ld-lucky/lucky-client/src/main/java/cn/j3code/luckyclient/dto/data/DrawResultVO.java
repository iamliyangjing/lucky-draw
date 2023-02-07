package cn.j3code.luckyclient.dto.data;

import lombok.Data;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-31 17:40
 **/
@Data
public class DrawResultVO {
    private String awardName;
    private String prizeName;
    private Boolean isDraw;
}
