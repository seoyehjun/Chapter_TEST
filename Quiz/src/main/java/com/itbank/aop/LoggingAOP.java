package com.itbank.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.itbank.model.vo.AccountVO;
@Component
@Aspect
public class LoggingAOP 
{
	private long startTime, endTime;
	
	// 지정한 메서드가 실행되기 전에 먼저 수행
		@Before("execution(* com.itbank.service.AccountService.*(..))")
		public void start() {
			startTime = System.currentTimeMillis();
		}
		
	// 지정한 메서드가 실행된 후 수행
		@After("execution(* com.itbank.service.AccountService.*(..))")
		public void end() {
			endTime = System.currentTimeMillis();
			double result = (endTime - startTime) / 1000.0;
			
			System.out.println("실행 시간 : " + result + "초");
		}
}
