package com.douzone.aoptest.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
	
	//실행하는 시점(접근지시자 리턴타입 호출하는곳위치)
	@Before("execution(public com.douzone.aoptest.vo.ProductVo com.douzone.aoptest.service.ProductService.find(String))")
	public void adviceBefore() {
		System.out.println("--- Before Advice ---");
	}
	//접근지시자 생략가능 *를통해 모든 리턴타입  *..* 모든패키지 ..을 이용해 파라미터줄임
	@After("execution(* *..*.ProductService.find(..))")
	public void adviceAfter() {
		System.out.println("--- After Advice ---");
	}

	@AfterReturning("execution(* *..*.ProductService.*(..))")
	public void adviceAfterReturning() {
		System.out.println("--- AfterReturning Advice ---");
	}

	@AfterThrowing(value="execution(* *..*.*.*(..))", throwing="ex")
	public void adviceAfterThrowing(Throwable ex) {
		System.out.println("--- AfterThrowing Advice " + ex + " ---");
	}
	
	@Around("execution(* *..*.ProductService.*(..))")
	public Object adviceAround(ProceedingJoinPoint pjp) throws Throwable {
		/* Before */
		System.out.println("--- Around(Before) Advice ---");
		
		/* Point Cut Method 실행 */
		//파라미터를 바꾸고 싶을 때 공통적으로 조작할 때
		// Object[] params = {"Camera"}; 
		// Object result = pjp.proceed(params);
		
		Object result = pjp.proceed();
		
		/* After */
		System.out.println("--- Around(After) Advice ---");
		
		return result;
	}
	
}



