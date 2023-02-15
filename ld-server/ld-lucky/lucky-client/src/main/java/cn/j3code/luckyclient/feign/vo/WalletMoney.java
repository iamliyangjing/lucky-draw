package cn.j3code.luckyclient.feign.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-02-15 10:01
 **/
@Data
@Accessors(chain = true)
public class WalletMoney {

    private Long userId;

    private BigDecimal balance;
}
