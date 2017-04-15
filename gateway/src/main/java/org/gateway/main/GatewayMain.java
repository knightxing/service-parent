package org.gateway.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@EnableAutoConfiguration
public class GatewayMain{

	public static void main(String[] args) throws Exception {
		 SpringApplication.run(GatewayMain.class, args);
	}

}