package com.sto.feignclient;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import feign.RequestInterceptor;
import feign.RequestTemplate;

@Configuration
public class FeignHeadersInterceptor implements RequestInterceptor {

	private HttpServletRequest getHttpServletRequest() {
		try {
			// 这种方式获取的HttpServletRequest是线程安全的
			return ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void apply(RequestTemplate template) {
		HttpServletRequest request = getHttpServletRequest();
		String token = request.getHeader("X-Token");
		template.header("X-Token", token);
	}
}
