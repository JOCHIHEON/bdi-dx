package com.bdi.sp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Aspect
public class AspectLogger {
	
	private static final Logger logger = LoggerFactory.getLogger(AspectLogger.class);

//	@Before("execution(* com.bdi.sp.controller.*Controller.*(..))")
//	public void beforeLog(JoinPoint jp) {
//		logger.debug("@Before=>{}",jp);
//	}
	
	@Around("execution(* com.bdi.sp.controller.*Controller.*(..))")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		String sigName = pjp.getSignature().getName();
		String tarName = pjp.getTarget().toString();
		Object[] params= pjp.getArgs();
		String str ="";
		for(Object o:params) {
			str +=o.toString()+",";
		}
		
		logger.debug("@Around Start");
		logger.debug("{},{},({})", new Object[] {tarName,sigName,str});
		Object obj =null;
		obj = pjp.proceed();
		logger.debug("@Result=>{}",obj);
		logger.debug("@Around End");
		return obj;
	}
	
//	@After("execution(* com.bdi.sp.controller.*Controller.*(..))")
//	public void afterLog(JoinPoint jp) {
//		logger.debug("@After=>{}",jp);
//	}
}
