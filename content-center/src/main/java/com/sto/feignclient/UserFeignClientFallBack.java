package com.sto.feignclient;

import org.springframework.stereotype.Component;

import com.sto.model.User;

@Component
public class UserFeignClientFallBack implements UserFeignClient {

	@Override
	public User getUserById(String id) {
		System.out.println("UserFeignClientFallBack");
		User user = new User();
		user.setId(id);
		user.setName("UserFeignClientFallBack");
		return user;
	}

	@Override
	public User getMultiParameter(String id, String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
