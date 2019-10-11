package com.sto.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sto.auth.CheckAuth;
import com.sto.auth.CheckToken;
import com.sto.feignclient.UserFeignClient;
import com.sto.model.User;

@RestController
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	@RequestMapping("/user/getUserById/{id}")
	@CheckToken
	@CheckAuth("admin")
	public User getUserById(@PathVariable String id) {
		return userFeignClient.getUserById(id);
	}
	
	@RequestMapping(value = "/user/getMultiParameter",method = RequestMethod.GET)
	public User getMultiParameter(@RequestParam("id") String id,@RequestParam("name") String name) {
		return userFeignClient.getMultiParameter(id,name);
	}
}
