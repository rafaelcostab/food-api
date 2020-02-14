package com.food.notification;

import com.food.model.Client;

public interface Notificator {

	void notify(Client client, String messagem);

}