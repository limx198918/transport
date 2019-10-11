package com.sto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 	网关
 * @author limingxue
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AppGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppGatewayApplication.class, args);
	}

}
