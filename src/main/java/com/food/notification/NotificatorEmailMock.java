package com.food.notification;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.food.model.Client;

@Profile("development")
@NotificatorType(UrgentNivel.NORMAL)
@Component
public class NotificatorEmailMock implements Notificator {
	
	public NotificatorEmailMock() {
		System.out.println("Starting: NotificatorEmailMock");
	}

	
	@Override
	public void notify(Client client, String message) {	
		System.out.printf("Mock: Notification would be send by %s through the email %s: %s\n",
				client.getName(), client.getEmail(), message);
	}	
}
