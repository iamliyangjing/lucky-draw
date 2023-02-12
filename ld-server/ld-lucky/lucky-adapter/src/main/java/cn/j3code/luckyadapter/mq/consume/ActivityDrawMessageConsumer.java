package cn.j3code.luckyadapter.mq.consume;

import cn.j3code.config.dto.ActivityDrawMessage;
import cn.j3code.config.util.AssertUtil;
import cn.j3code.luckyapp.activity.command.RedisDeductionAwardNumberDrawExe;
import cn.j3code.luckyapp.context.ActivityDrawContext;
import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-02-09 11:54
 **/
@Slf4j
@Component
@AllArgsConstructor
@RocketMQMessageListener(topic = "activity-draw-topic", consumerGroup = "lucky_draw")
public class ActivityDrawMessageConsumer implements RocketMQListener<ActivityDrawMessage> {

    private final RedisDeductionAwardNumberDrawExe drawExe;

    @Override
    public void onMessage(ActivityDrawMessage activityDrawMessage) {
        log.info("接受到MQ消息了，{}", JSON.toJSONString(activityDrawMessage));
        String body = activityDrawMessage.getBody();
        //类型转换
        ActivityDrawContext context = JSON.parseObject(body, ActivityDrawContext.class);

        if (Boolean.FALSE.equals(drawExe.mqDeductionOfInventoryAndUpdateRecordStatus(context))){
            AssertUtil.isTrue(true, "执行消费MQ逻辑失败（扣减库存和修改不可见记录）");
        }
    }
}
