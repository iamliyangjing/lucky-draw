package cn.j3code.luckyclient.feign.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-02-14 21:24
 **/
@Data
public class UpdateWalletForm {

    private Long userId;

    private BigDecimal updateMoney;
}
