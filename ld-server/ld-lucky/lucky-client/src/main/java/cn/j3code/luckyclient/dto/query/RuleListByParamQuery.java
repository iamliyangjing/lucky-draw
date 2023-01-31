package cn.j3code.luckyclient.dto.query;

import com.alibaba.cola.dto.PageQuery;
import lombok.Data;

import java.util.List;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-31 15:05
 **/
@Data
public class RuleListByParamQuery extends PageQuery {

    private Long id;

    private List<Long> ids;
    private String ruleName;

}
