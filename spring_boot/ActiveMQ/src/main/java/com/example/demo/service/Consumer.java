package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * @Author: ChaoLiu
 * @Description: 消息消费者
 * @Date: 2018/9/11 12:01
 */
@Service
public class Consumer {

    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @JmsListener(destination = "test.queue", containerFactory = "queueJmsListenerContainerFactory")
    public void reciveMsg(String text){
        logger.info("处理器-1 收到消息："+text);
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @JmsListener(destination = "test.queue", containerFactory = "queueJmsListenerContainerFactory")
    public void reciveMsg2(String text){
        logger.info("处理器-2 收到消息："+text);
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
