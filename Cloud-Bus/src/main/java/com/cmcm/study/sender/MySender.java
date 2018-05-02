package com.cmcm.study.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author hongfei
 * @create 2018-04-26 下午2:36
 */
@Component
public class MySender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String context = "hello" + new Date();
        System.out.println("发送的数据是:" + context);
        this.amqpTemplate.convertAndSend(context);
    }

}
