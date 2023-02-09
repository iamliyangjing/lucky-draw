package cn.j3code.luckyapp.listener.event;

import cn.j3code.luckyclient.dto.data.ActivityConfigVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-02-07 21:53
 **/
@Slf4j
public class ActivityCreateEvent extends ApplicationEvent {

    /**
     * 活动创建id
     */
    private final ActivityConfigVO activityConfigVO;

    public ActivityConfigVO getActivityConfig() {
        return activityConfigVO;
    }
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public ActivityCreateEvent(Object source, ActivityConfigVO activityConfigVO) {
        super(source);
        this.activityConfigVO = activityConfigVO;
    }
}
