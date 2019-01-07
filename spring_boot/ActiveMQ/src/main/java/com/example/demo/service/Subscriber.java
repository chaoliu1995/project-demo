package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * @Author: ChaoLiu
 * @Description: 消息订阅者
 * @Date: 2018/9/11 12:01
 */
@Service
public class Subscriber {

    private static final Logger logger = LoggerFactory.getLogger(Subscriber.class);

    @JmsListener(destination = "test.topic", containerFactory = "topicJmsListenerContainerFactory")
    public void subscribe(String text){
        logger.info("订阅者-1 收到消息："+text);
    }

    @JmsListener(destination = "test.topic", containerFactory = "topicJmsListenerContainerFactory")
    public void subscribe2(String text){
        logger.info("订阅者-2 收到消息："+text);
    }

}

