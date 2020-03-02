package com.food.notification;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.food.service.ActivationClientService;

@Configuration
public class ServiceConfiguration {

	@Bean(initMethod = "init", destroyMethod = "destroy")
	public ActivationClientService activationClienteService() {
		return new ActivationClientService();
	}
	
}
