package cn.j3code.luckyclient.dto.data;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-02-12 23:33
 **/
@Data
public class AcceptPrizeVO {

    private Long id;

    /**
     * 电话
     */
    private String phone;

    /**
     * 地址
     */
    private String address;

    /**
     *
     */
    private LocalDateTime createTime;
}
