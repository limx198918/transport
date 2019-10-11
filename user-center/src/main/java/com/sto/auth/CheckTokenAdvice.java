package com.sto.auth;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sto.model.User;

@RestControllerAdvice
public class CheckTokenAdvice {

	@ExceptionHandler(CheckTokenException.class)
	public Object exceptionHandler(CheckTokenException ex) {
		User user = new User();
		user.setId("-100");
		user.setName("exceptionHandler");
	    return user;
	}
}
