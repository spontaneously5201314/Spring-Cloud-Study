package com.cmcm.study.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author hongfei
 * @create 2018-04-26 下午4:27
 */
@Component
@RabbitListener(queues = "hello")
public class MyReceiver {

    @RabbitHandler
    public void process(String context){
        System.out.println("收到的数据是:" + context);
    }
}
