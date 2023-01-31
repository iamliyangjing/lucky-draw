package cn.j3code.luckydomain.award;

import cn.j3code.config.exception.LdException;
import lombok.Getter;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-31 15:43
 **/
@Getter
public class AwardNumber {

    private Integer number;

    public AwardNumber(Integer number) {

        if (number < 0) {
            throw new LdException("奖项数量不合法，需大于等于 0");
        }

        this.number = number;
    }

}
