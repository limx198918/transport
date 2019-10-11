package com.sto.feignclient;

import org.springframework.stereotype.Component;

import com.sto.model.User;

import feign.hystrix.FallbackFactory;

@Component
public class UserFeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {

	@Override
	public UserFeignClient create(Throwable cause) {
		return new UserFeignClient() {
			
			@Override
			public User getUserById(String id) {
				System.out.println("UserFeignClientFallbackFactory");
				User user = new User();
				user.setId(id);
				user.setName("UserFeignClientFallbackFactory");
				return user;
			}
			
			@Override
			public User getMultiParameter(String id, String name) {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}

}
