package com.wedevol.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * Service Profiler to log the execution time (Question 7)
 */

@Aspect
public class MenuServiceProfiler {

	private static final Logger logger = LoggerFactory.getLogger(MenuServiceProfiler.class);

	@Pointcut("execution(* com.wedevol.service.impl.*.*(..))")
	public void businessMethods() {
	}

	@Around("businessMethods()")
	public Object profile(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();
		logger.debug("Going to call the method: " + pjp.getSignature().getName());
		Object output = pjp.proceed();
		logger.debug("Method execution completed.");
		long elapsedTime = System.currentTimeMillis() - start;
		logger.debug("Method execution time: " + elapsedTime + " milliseconds.");
		return output;
	}

}
