package com.food.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.food.model.Client;
import com.food.notification.Notificator;

@Component
public class ActivationClientService {
	
	@Autowired
	private List<Notificator> notificators;
		
	public void activite(Client client) {
		client.activate();
		
		for (Notificator notificator : notificators) {
			notificator.notify(client, "Your register in system this activated!");
		}
	}

}
