package com.douzone.container.videosystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.douzone.container.config.videosystem.DVDPlayerConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { DVDPlayerConfig.class })
public class DVDPlayerJavaConfigTest {

	@Autowired
	// 같은 타입의 빈이 2개 이상 있는 경우
	// 설정 클래스의 빈생성 메소드의 @Bean의 name(default)속성을 이용
	@Qualifier("dvdPlayer") // 메소드 이름이 id 만약 bean에 이름을 주면 그이름이 id가됨
	private DVDPlayer dvdPlayer01;

	@Autowired
	// 같은 타입의 빈이 2개 이상 있는 경우
	// 설정 클래스의 빈생성 메소드의 이름으로 Qualifier 하기
	@Qualifier("dvdPlayer02") // 메소드 이름이 id
	private DVDPlayer dvdPlayer02;
	
	@Autowired
	@Qualifier("dvdPlayer03")
	private DVDPlayer dvdPlayer03;

	@Test
	public void testDVDPlayer01NotNull() {
		assertNotNull(dvdPlayer01);
	}

	@Test
	public void testDVDPlayer02NotNull() {
		assertNotNull(dvdPlayer02);
	}

	@Test
	public void testDVDPlayer03NotNull() {
		assertNotNull(dvdPlayer03);
	}
	
	@Test
	public void testPlay() {
		assertEquals("Playing Movie MARVLE's Avengers", dvdPlayer03.play());
	}
	
}
