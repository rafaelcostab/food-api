package com.food;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.food.notification.NotificatorEmail;

@Configuration
public class NotificationConfig {
	
	@Bean
	public NotificatorEmail notificatorEmail() {
		NotificatorEmail notificator = new NotificatorEmail("smpt.food.com.br");
		notificator.setCapsLock(true);
		
		return notificator;
		
	}
}
