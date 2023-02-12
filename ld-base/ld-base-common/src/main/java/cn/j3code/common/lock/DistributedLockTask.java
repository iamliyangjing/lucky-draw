package cn.j3code.common.lock;

import lombok.Data;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-02-12 21:19
 **/
@Data
public class DistributedLockTask {
    /**
     * key
     */
    private String key;

    /**
     * 过期时间 ，单位：秒
     */
    private Long expiredTime;

    /**
     * 最大续约次数
     */
    private Integer maxToRenewNum;


    /**
     * 当前续约次数
     */
    private Integer newToRenewNum;

    /**
     * 最新更新时间
     */
    private LocalDateTime newUpdatedTime;


    /**
     * 业务线程
     */
    private Thread thread;

    /**
     * 是否到达续约时间
     * @param time
     * @return true :达到最大续约时间，可以续约
     */
    public Boolean isToRenewTime(LocalDateTime time){
        if(Objects.isNull(time)){
            time = this.newUpdatedTime;
        }

        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(time, now);

        return duration.toSeconds() >= (double)((this.expiredTime/3)*2);
    }

    /**
     * 是否达到最大续约次数
     * @param num
     * @return
     */
    public Boolean isMaxToRenewNum(Integer num){
        if (Objects.isNull(num)){
            num = this.newToRenewNum;
        }
        //return num >= this.maxToRenewNum ? Boolean.TRUE : Boolean.FALSE;
        return num >= this.maxToRenewNum;
    }
}
