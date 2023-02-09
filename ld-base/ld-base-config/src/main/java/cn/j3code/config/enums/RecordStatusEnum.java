package cn.j3code.config.enums;

import lombok.Getter;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-02-09 13:57
 **/
@Getter
public enum RecordStatusEnum {

    STATUE_0(0, "用户不可见"),

    STATUE_1(1, "待运营人员确认"),

    STATUE_2(2, "待用户签收"),

    STATUE_3(3, "流程结束"),

    ;
    private Integer value;

    private String description;


    RecordStatusEnum(Integer value, String description){
        this.value = value;
        this.description = description;
    }

}