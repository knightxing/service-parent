package org.gateway.main;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("org.gateway.controller")
@EnableAutoConfiguration
public class GatewayMain extends SpringBootServletInitializer implements EmbeddedServletContainerCustomizer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(this.getClass());
	}

	public static void main(String[] args) throws Exception {
		// SpringApplication.run(GateWayMain.class, args);

		SpringApplication app = new SpringApplication(GatewayMain.class);
		app.setWebEnvironment(true);

		Set<Object> set = new HashSet<Object>();
		//set.add("classpath:spring/applicationContext.xml");
		app.setSources(set);
		app.run(args);

		System.in.read(); // 为保证服务一直开着，利用输入流的阻塞来模拟

	}

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setPort(8081);

	}

}