package com.food.service;

import org.springframework.stereotype.Component;

import com.food.model.Client;
import com.food.notification.NotificatorEmail;

@Component
public class AtivationClientService {
	
	private NotificatorEmail notificator;
	
	public void activite(Client client) {
		client.activate();
		
		notificator.notify(client, "Your register in system is activated!");
	}
	
}
