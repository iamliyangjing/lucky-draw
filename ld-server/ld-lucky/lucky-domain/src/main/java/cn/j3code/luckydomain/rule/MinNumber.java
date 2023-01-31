package cn.j3code.luckydomain.rule;

import cn.j3code.config.exception.LdException;
import lombok.Getter;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-31 15:15
 **/
@Getter
public class MinNumber {

    private Integer number;

    public MinNumber(Integer number){
        if (number < 1){
            throw new LdException("规则次数必须大于等于 1");
        }

        this.number = number;
    }

}
