package cn.j3code.luckydomain.prize;

import cn.j3code.config.exception.LdException;
import lombok.Getter;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-31 14:42
 **/
@Getter
public class Tnventory {

    private Integer inventory;

    public Tnventory(Integer inventory) {
        if (inventory < 0) {
            throw new LdException("库存数量请大于等于 0");
        }
        this.inventory = inventory;
    }


}