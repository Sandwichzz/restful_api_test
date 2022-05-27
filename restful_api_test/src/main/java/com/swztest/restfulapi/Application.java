package com.swztest.restfulapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("启动");
        // 启动测试
        // post数据
        SendMessage message = new SendMessage();
        message.SendPost();
        
    }
}
