package cn.j3code.luckyclient.dto.query;

import com.alibaba.cola.dto.PageQuery;
import lombok.Data;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-31 14:46
 **/
@Data
public class PrizeListByParamQuery extends PageQuery {

    private Long id;

    private String prizeName;

    private Integer type;
}
