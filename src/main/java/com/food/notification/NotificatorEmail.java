package com.food.notification;

import org.springframework.stereotype.Component;

import com.food.model.Client;

@Component
public class NotificatorEmail implements Notificator {

	public NotificatorEmail() {
		System.out.println("Constructor called");
	}
	
	@Override
	public void notify(Client client, String messagem) {
		System.out.printf("notifying %s through the email %s: %s\n",
				client.getName(), client.getEmail(), messagem);
	}
	
}
