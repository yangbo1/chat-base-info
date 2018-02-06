package com.yb.chat;

import com.yb.chat.server.ChatServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.yb.chat.dao")
public class ChatBaseServiceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(ChatBaseServiceApplication.class, args);
//		ChatServer.setApplicationContext(run);
	}
}
