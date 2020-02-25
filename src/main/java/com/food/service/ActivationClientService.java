package com.food.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.food.model.Client;
import com.food.notification.Notificator;
import com.food.notification.NotificatorType;
import com.food.notification.UrgentNivel;

@Component
public class ActivationClientService {

	@NotificatorType(UrgentNivel.URGENT)
	@Autowired
	private Notificator notificator;
		
	public void activite(Client client) {
		client.activate();
		
		notificator.notify(client, "Your register in system this activated!");
	}

}
