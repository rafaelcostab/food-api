package com.food.notification;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.food.model.Client;

@Profile("production")
@NotificatorType(UrgentNivel.NORMAL)
@Component
public class NotificatorEmail implements Notificator {
	
	public NotificatorEmail() {
		System.out.println("Starting: NotificatorEmail");
	}
	
	@Override
	public void notify(Client client, String message) {	
		System.out.printf("notifying %s through the email %s: %s\n",
				client.getName(), client.getEmail(), message);
	}	
}
