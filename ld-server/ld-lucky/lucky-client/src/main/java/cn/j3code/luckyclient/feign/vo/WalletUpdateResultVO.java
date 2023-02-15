package cn.j3code.luckyclient.feign.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-02-14 21:25
 **/
@Data
@Accessors(chain = true)
public class WalletUpdateResultVO {

    private Boolean result;

}