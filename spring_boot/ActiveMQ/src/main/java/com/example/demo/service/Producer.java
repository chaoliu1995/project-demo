package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @Author: ChaoLiu
 * @Description: 消息生产者
 * @Date: 2018/9/11 12:00
 */
@Service("producer")
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private Queue queue;
    @Autowired
    private Topic topic;

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void sendQueueMsg(String message){
        logger.info("发送消息：queue------"+message);
        jmsMessagingTemplate.convertAndSend(this.queue,message);
    }
    public void sendTopicMsg(String message){
        logger.info("发送消息：topic------"+message);
        jmsMessagingTemplate.convertAndSend(this.topic,message);
    }
}
