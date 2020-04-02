package com.example.demo;

import com.example.demo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedisDemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(RedisDemoApplication.class, args);
    }

    @Autowired
    private RedisService redisService;

    @Override
    public void run(String... args) throws Exception {
        String value = redisService.get("StringR.data:album:120:32860");
        System.out.println(value);
    }
}
