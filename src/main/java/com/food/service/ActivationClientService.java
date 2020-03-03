package com.food.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.food.event.ActivatedClientEvent;
import com.food.model.Client;

@Component
public class ActivationClientService {

	@Autowired
	private ApplicationEventPublisher eventPublisher;

	public void activite(Client client) {
		client.activate();
		
		eventPublisher.publishEvent(new ActivatedClientEvent(client));
	}

}
