package com.food.service;

import org.springframework.stereotype.Component;

import com.food.model.Client;
import com.food.notification.Notificator;

@Component
public class ActivationClientService {
	
	private Notificator notificator;
	
	public ActivationClientService(Notificator notificator) {
		this.notificator = notificator;
		
		System.out.println("ActivationClientService: " + notificator);
	}

	public void activite(Client client) {
		client.activate();
		
		notificator.notify(client, "Your register in system is activated!");
	}
	
}
