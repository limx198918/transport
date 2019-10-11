package com.sto.auth;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class CheckTokenSpringAop {

	@Around("@annotation(com.sto.auth.CheckToken)")
	public Object checkToken(ProceedingJoinPoint pjp) throws CheckTokenException {
		try {
			HttpServletRequest httpServletRequest = getHttpServletRequest();
			String token = httpServletRequest.getHeader("X-Token");
			if(StringUtils.isEmpty(token)) throw new CheckTokenException("token不能为空!");
			return pjp.proceed();
		} catch (Throwable e) {
			throw new CheckTokenException(e.getLocalizedMessage());
		}
	}

	public HttpServletRequest getHttpServletRequest() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		return attr.getRequest();
	}
}
