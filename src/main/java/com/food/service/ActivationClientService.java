package com.food.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.food.model.Client;
import com.food.notification.Notificator;

@Component
public class ActivationClientService {
	
	@Autowired(required = false)
	private Notificator notificator;
		
	public void activite(Client client) {
		client.activate();
		
		if (notificator != null) {
			notificator.notify(client, "Your register in system is activated!");
		} else {
			System.out.println("Don't exist notification, but client do activated");
		}
	}

}
