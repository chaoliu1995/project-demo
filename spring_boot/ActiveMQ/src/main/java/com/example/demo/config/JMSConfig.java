package com.example.demo.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @Author: ChaoLiu
 * @Description:
 * @Date: 2018/9/11 17:01
 */
@Configuration
public class JMSConfig {

    @Bean
    public Queue queue() {
        return new ActiveMQQueue("test.queue");
    }

    @Bean
    public Topic topic() {
        return new ActiveMQTopic("test.topic");
    }

    /**
     * Point-to-Point 点对点
     * @param connectionFactory
     * @return
     */
    @Bean
    public JmsListenerContainerFactory<?> queueJmsListenerContainerFactory(ConnectionFactory connectionFactory){
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(false);
        return factory;
    }

    /**
     * Publish Subscribe 发布订阅
     * @param connectionFactory
     * @return
     */
    @Bean
    public JmsListenerContainerFactory<?> topicJmsListenerContainerFactory(ConnectionFactory connectionFactory){
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(true);
        return factory;
    }

}
