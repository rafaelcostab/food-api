package com.food.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.food.event.ActivatedClientEvent;

@Component
public class InvoiceIssuance {

	@EventListener
	public void activatedClientListener(ActivatedClientEvent event) {
		System.out.println("by issuing an invoice to client: " + event.getClient().getName());
	}
}
