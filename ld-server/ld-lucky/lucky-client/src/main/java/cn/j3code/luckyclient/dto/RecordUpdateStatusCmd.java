package cn.j3code.luckyclient.dto;

import com.alibaba.cola.dto.Command;
import lombok.Data;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-02-09 13:59
 **/
@Data
public class RecordUpdateStatusCmd extends Command {

    /**
     *
     */
    private Long id;

    /**
     * 状态（0，1，2，3）
     */
    private Integer state;
}
