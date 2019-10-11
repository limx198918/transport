package com.sto.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sto.model.User;

@FeignClient(name="user-center",
//fallback = UserFeignClientFallBack.class,
fallbackFactory = UserFeignClientFallbackFactory.class
)
public interface UserFeignClient {

	/**
	 * http://user-center/user/getUserById/{1}
	 */
	@RequestMapping("/user/getUserById/{id}")
	public User getUserById(@PathVariable String id);
	
	@RequestMapping(value = "/user/getMultiParameter",method = RequestMethod.GET)
	public User getMultiParameter(@RequestParam("id") String id,@RequestParam("name") String name);
	
}