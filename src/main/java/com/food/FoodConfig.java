package com.food;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.food.notification.NotificatorEmail;
import com.food.service.ActivationClientService;

//@Configuration
public class FoodConfig {
	
	@Bean
	public NotificatorEmail notificatorEmail() {
		NotificatorEmail notificator = new NotificatorEmail("smpt.food.com.br");
		notificator.setCapsLock(true);
		
		return notificator;
		
	}
	
	@Bean
	public ActivationClientService activateClientService() {
		return new ActivationClientService(notificatorEmail());
	}
}
