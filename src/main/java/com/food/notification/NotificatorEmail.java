package com.food.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.food.model.Client;

@NotificatorType(UrgentNivel.NORMAL)
@Component
public class NotificatorEmail implements Notificator {
	
	@Autowired
	private NotificatorProperties properties;
	
	@Override
	public void notify(Client client, String message) {	
		System.out.println("Host: " + properties.getServerHost());
		System.out.println("Port: " + properties.getServerPort());
		
		System.out.printf("notifying %s through the email %s: %s\n",
				client.getName(), client.getEmail(), message);
	}	
}
