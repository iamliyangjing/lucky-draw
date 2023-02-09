package cn.j3code.luckyapp.mq.product;

import cn.hutool.core.util.IdUtil;
import cn.j3code.config.dto.ActivityDrawMessage;
import cn.j3code.luckyapp.context.ActivityDrawContext;
import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-02-09 11:55
 **/
@Slf4j
@Component
@AllArgsConstructor
public class ActivityDrawMessageProduct {

    private final RocketMQTemplate rocketMQTemplate;

    public Boolean send(ActivityDrawContext context) {
        final var activityDrawMessage = new ActivityDrawMessage()
                .setUuid(IdUtil.simpleUUID())
                .setBody(JSON.toJSONString(context));

        Message<ActivityDrawMessage> message = MessageBuilder
                .withPayload(activityDrawMessage)
                .build();

        SendResult sendResult = rocketMQTemplate.syncSend("activity-draw-topic", message);

        if (SendStatus.SEND_OK.equals(sendResult.getSendStatus())) {
            log.info("消息发送成功，业务ID：{}.uuid:{}",
                    activityDrawMessage.getId(), activityDrawMessage.getUuid());
            return Boolean.TRUE;
        }
        log.info("消息发送失败！");
        return Boolean.FALSE;
    }
}
