/*
 * DemoAspect.java 2021. 06. 13
 *
 * Copyright 2021 Naver Cloud Corp. All rights Reserved.
 * Naver Business Platform PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package me.potato.demoInvokeCheck;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author dongju.paek
 */
@Slf4j
@Component
@Aspect
public class DemoAspect {

	@Around("within(me.potato.demoInvokeCheck.DemoController) && execution(* me.potato.demoInvokeCheck.DemoController.hello(..))")
	public Object intercept(final ProceedingJoinPoint joinPoint) throws Throwable {
		Object proceed = joinPoint.proceed();
		doSome();
		doSome();
		return proceed.toString() + " World";
	}

	public void doSome() {
		log.info("called");
	}
}