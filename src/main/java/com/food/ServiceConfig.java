package com.food;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.food.notification.Notificator;
import com.food.service.ActivationClientService;

@Configuration
public class ServiceConfig {
	@Bean
	public ActivationClientService activateClientService(Notificator notificator) {
		return new ActivationClientService(notificator);
	}
}
