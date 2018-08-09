package com.app.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class LoggingAspect {

	
	private final Log log = LogFactory.getLog(this.getClass());
	
	@Pointcut("execution(public * com.app..*.*(..))")
	public void point1(){}
	
	
	@Around("point1()") //JP
	public Object getTotalTime(ProceedingJoinPoint jp){
		StopWatch watch=new StopWatch(jp.getTarget().getClass().getName());
		
		Object ob=null;
		try {
			watch.start(jp.getSignature().getName());
			ob = jp.proceed();
			watch.stop();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		log.info(watch.prettyPrint());
		return ob;
	}

	@AfterThrowing(pointcut="point1()",throwing="th")
	public void getErrors(Throwable th){
	  log.error(th.getMessage());
	}
	
	@After("point1()")
	public void afterMsg(){
		log.debug("Method Execution done");
	}
	
	
	
}
