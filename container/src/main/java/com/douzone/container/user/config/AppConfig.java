package com.douzone.container.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.douzone.container.user.Friend;

@Configuration
//자동설정
@ComponentScan(basePackages={"com.douzone.container.user"})
public class AppConfig {
	//수동설정 user이 아이디가됨
//	@Bean
//	public User user() {
//		return new User();
//	}
	
	@Bean
	public Friend friend() {
		return new Friend("Loopy");
	}
}
