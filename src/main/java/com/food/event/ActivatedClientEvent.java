package com.food.event;

import com.food.model.Client;

public class ActivatedClientEvent {

	private Client client;
	
	public ActivatedClientEvent(Client client) {
		this.client = client;
	}
	
	public Client getClient() {
		return client;
	}

}
