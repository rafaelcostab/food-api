package com.food.notification;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.food.model.Client;

@NotificatorType(UrgentNivel.NORMAL)
@Component
public class NotificatorEmail implements Notificator {
	
	@Value("${notificator.email.server-host}")
	private String host;
	
	@Value("$notificator.email.server-port")
	private Integer port;
	
	@Override
	public void notify(Client client, String message) {	
		System.out.println("Host: " + host);
		System.out.println("Port: " + port);
		
		System.out.printf("notifying %s through the email %s: %s\n",
				client.getName(), client.getEmail(), message);
	}	
}
