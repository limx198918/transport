package com.sto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;

/**
 * 
 * @author limingxue
 *
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class ContentCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContentCenterApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	@SentinelRestTemplate
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
