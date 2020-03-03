package com.food.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.food.event.ActivatedClientEvent;
import com.food.notification.Notificator;
import com.food.notification.NotificatorType;
import com.food.notification.UrgentNivel;

@Component
public class NotificationService {

	@NotificatorType(UrgentNivel.NORMAL)
	@Autowired
	private Notificator notificator;
	
	@EventListener
	public void activatedClientListener(ActivatedClientEvent event) {
		notificator.notify(event.getClient(), "your register in system is activated!");
	}
}
