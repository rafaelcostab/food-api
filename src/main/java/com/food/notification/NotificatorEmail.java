package com.food.notification;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.food.model.Client;

@Qualifier("normal")
@Component
public class NotificatorEmail implements Notificator {
	
	@Override
	public void notify(Client client, String message) {	
		System.out.printf("notifying %s through the email %s: %s\n",
				client.getName(), client.getEmail(), message);
	}	
}
