package com.douzone.container.user.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.douzone.container.user.User;

public class XmlConfigTest {

	public static void main(String[] args) {
		// XML Auto Configuration(Annotation Scanning)
//		testBeanFactory01();

		// XML Bean Configuration(Explicit Configuration)
//		testBeanFactory02();

		// XML Auto Configuration(Annotation Scanning)
		testApplicationContext01();

		// XML Bean Configuration(Explicit Configuration)
		testApplicationContext02();

	}

	private static void testApplicationContext01() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"com/douzone/container/config/user/applicationContext01.xml");

		User user = null;

		user = ac.getBean(User.class);
		System.out.println(user.getName());
		// Annotation Scan 설정에서는 Bean id가 자동으로 부여된다
		user = (User) ac.getBean("user");
	}

	private static void testApplicationContext02() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"com/douzone/container/config/user/applicationContext02.xml");
		User user = null;
		
		// id로 빈 가져오기 object로 리턴함
		// 명시적으로 할땐 id를 줘야함
		user = (User) ac.getBean("user");
		System.out.println(user.getName());

		//name으로 가져오기
		user = (User) ac.getBean("usr");
		System.out.println(user.getName());
		
		//type으로 빈 가져오기
		//같은 클래스가 빈에 2가지로 있을 때는 타입이 유니크하지 않음
		// 1.id + type
		// 2.name + type
		user = ac.getBean("user2",User.class);
		user = ac.getBean("usr2",User.class);
		System.out.println(user);
		
		user = ac.getBean("user3",User.class);
		System.out.println(user);
		
		user = ac.getBean("user4",User.class);
		System.out.println(user);
		
		//setter를 사용한 빈 가져오기1
		user = ac.getBean("user5",User.class);
		System.out.println(user);

		//setter를 사용한 빈 가져오기2 (DI)
		user = ac.getBean("user6",User.class);
		System.out.println(user); 
		
		//setter를 사용한 빈 가져오기3 (Collection Property)
		user = ac.getBean("user7",User.class);
		System.out.println(user); 
	}

	private static void testBeanFactory01() {
		BeanFactory bf = new XmlBeanFactory(
				new ClassPathResource("com/douzone/container/config/user/applicationContext01.xml"));

		User user = bf.getBean(User.class);
		System.out.println(user.getName());

	}

	private static void testBeanFactory02() {
		BeanFactory bf = new XmlBeanFactory(
				new ClassPathResource("com/douzone/container/config/user/applicationContext02.xml"));

		User user = bf.getBean(User.class);
		System.out.println(user.getName());

	}
}
