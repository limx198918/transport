package com.sto.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CheckTokenAdvice {

	@ExceptionHandler(CheckTokenException.class)
	public Object exceptionHandler(CheckTokenException ex) {
		Map<String,String> map = new HashMap<String,String>();
	    map.put("mgs", ex.getMessage());
	    map.put("code", "200");
	    return map;
	}
}
