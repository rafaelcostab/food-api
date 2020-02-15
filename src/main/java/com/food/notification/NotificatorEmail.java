package com.food.notification;

import com.food.model.Client;

public class NotificatorEmail implements Notificator {

	private boolean capsLock;
	private String hostServerSMTP;
	
	public NotificatorEmail(String hostServerSMTP) {
		this.hostServerSMTP = hostServerSMTP;
		System.out.println("Constructor called");
	}
	
	@Override
	public void notify(Client client, String message) {
		if (this.capsLock) {
			message = message.toUpperCase();
		}
		
		System.out.printf("notifying %s through the email %s: %s using SMTP %s\n",
				client.getName(), client.getEmail(), this.hostServerSMTP, message);
	}

	public void setCapsLock(boolean capsLock) {
		this.capsLock = capsLock;
	}
	
}
