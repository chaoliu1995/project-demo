package com.example.demo.controller;

import com.example.demo.service.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: ChaoLiu
 * @Description:
 * @Date: 2018/9/11 15:43
 */
@Controller
@RequestMapping("/msg")
public class MessageController {

    @Autowired
    private Producer producer;

    @RequestMapping("/queue/send")
    @ResponseBody
    public String send(String msg){
        producer.sendQueueMsg(msg);
        return "success";
    }

    @RequestMapping("/topic/send")
    @ResponseBody
    public String sendForTopic(String msg){
        producer.sendTopicMsg(msg);
        return "success";
    }
}
