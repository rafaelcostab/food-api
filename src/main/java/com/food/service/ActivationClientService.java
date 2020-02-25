package com.food.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.food.model.Client;
import com.food.notification.Notificator;

@Component
public class ActivationClientService {
	
	@Qualifier("urgent")
	@Autowired
	private Notificator notificator;
		
	public void activite(Client client) {
		client.activate();
		
		notificator.notify(client, "Your register in system this activated!");
	}

}
