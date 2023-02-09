package cn.j3code.config.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-02-09 11:41
 **/
@Data
@Accessors(chain = true)
public class ActivityDrawMessage {

    /**
     * 业务唯一id
     */
    private Long id;
    private String uuid;

    /**
     * JSON内容对象
     */
    private String body;
}
