package com.food.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.food.model.Client;
import com.food.notification.Notificator;

@Component
public class ActivationClientService {
	
	// exemple autowired in attribute
	@Autowired
	private Notificator notificator;
	
	/* example autowired in contructor method
	@Autowired
	public ActivationClientService(Notificator notificator) {
		this.notificator = notificator;
	}

	public ActivationClientService(String any) {
		
	}
	*/
	
	public void activite(Client client) {
		client.activate();
		
		notificator.notify(client, "Your register in system is activated!");
	}

	/* example autowired in set method
	@Autowired
	public void setNotificator(Notificator notificator) {
		this.notificator = notificator;
	}
	*/
}
