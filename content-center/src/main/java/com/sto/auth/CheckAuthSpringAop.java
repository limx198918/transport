package com.sto.auth;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CheckAuthSpringAop {

	@Around("@annotation(com.sto.auth.CheckAuth)")
	public Object checkToken(ProceedingJoinPoint joinPoint) throws CheckTokenException {
		try {
			MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
			Method method = methodSignature.getMethod();
			CheckAuth checkAuth = method.getAnnotation(CheckAuth.class);
			String value = checkAuth.value();
			System.out.println("checkAuth注解上的值:" + value);
			return joinPoint.proceed();
		} catch (Throwable e) {
			throw new CheckTokenException(e.getLocalizedMessage());
		}
	}
}
