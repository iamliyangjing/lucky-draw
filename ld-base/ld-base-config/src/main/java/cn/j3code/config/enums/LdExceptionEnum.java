package cn.j3code.config.enums;

import cn.j3code.config.vo.FailInfo;
import lombok.Getter;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-31 16:07
 **/
@Getter
public enum LdExceptionEnum {

    ADD_ERROR(FailInfo.DEFAULT_CODE, "保存数据失败！"),

    UPDATE_ERROR(FailInfo.DEFAULT_CODE, "保存数据失败！"),

    ;
    private Integer code;

    private String description;

    LdExceptionEnum(Integer code, String description){
        this.code = code;
        this.description = description;
    }

}
