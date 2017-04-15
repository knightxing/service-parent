package org.gateway.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("org.gateway.controller")
@EnableAutoConfiguration
public class GatewayMain{

	public static void main(String[] args) throws Exception {
		 SpringApplication.run(GatewayMain.class, args);


	}

}