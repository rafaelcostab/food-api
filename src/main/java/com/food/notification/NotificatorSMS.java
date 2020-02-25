package com.food.notification;

import org.springframework.stereotype.Component;

import com.food.model.Client;

@NotificatorType(UrgentNivel.URGENT)
@Component
public class NotificatorSMS implements Notificator {
	
	@Override
	public void notify(Client client, String message) {	
		System.out.printf("notifying %s by SMS over the phone %s: %s\n",
				client.getName(), client.getPhone(), message);
	}	
}
