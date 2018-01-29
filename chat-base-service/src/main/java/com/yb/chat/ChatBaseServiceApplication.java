package com.yb.chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.yb.chat.dao")
public class ChatBaseServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatBaseServiceApplication.class, args);
	}
}
