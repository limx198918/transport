package com.sto.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sto.auth.CheckToken;
import com.sto.model.User;

@RestController
@RequestMapping("/user")
@RefreshScope
public class UserController {

	@RequestMapping("/getUserById/{id}")
	@CheckToken
	public User getUserById(@PathVariable String id) {
		User user = new User();
		user.setId(id);
		user.setName("测试" + Math.random());
		return user;
	}
	
	@RequestMapping(value = "/getMultiParameter",method = RequestMethod.GET)
	public User getMultiParameter(@RequestParam("id") String id,@RequestParam("name") String name) {
		User user = new User();
		user.setId(id);
		user.setName(name);
		return user;
	}
	
	@Value("${didispace.title:}")
    private String title;
	
	@RequestMapping("/getNacosConfig")
	public String getNacosConfig() {
		return title;
	}
}
