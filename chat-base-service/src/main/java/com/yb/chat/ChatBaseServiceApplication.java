package com.yb.chat;

import com.yb.chat.server.ChatServer;
import com.yb.chat.server.RequestListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableFeignClients(basePackages = {"com.yb.chat.client"})
@MapperScan("com.yb.chat.dao")
public class ChatBaseServiceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(ChatBaseServiceApplication.class, args);
		ChatServer.setApplicationContext(run);
	}
	@Autowired
	private RequestListener requestListener;
	@Bean
	public ServletListenerRegistrationBean<RequestListener> servletListenerRegistrationBean() {
		ServletListenerRegistrationBean<RequestListener> servletListenerRegistrationBean = new ServletListenerRegistrationBean<>();
		servletListenerRegistrationBean.setListener(requestListener);
		return servletListenerRegistrationBean;
	}
}
