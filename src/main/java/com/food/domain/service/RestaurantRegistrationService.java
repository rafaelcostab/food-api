package com.food.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.domain.exception.EntityNotFoundException;
import com.food.domain.model.Kitchen;
import com.food.domain.model.Restaurant;
import com.food.domain.repository.KitchenRepository;
import com.food.domain.repository.RestaurantRepository;

@Service
public class RestaurantRegistrationService {

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private KitchenRepository kitchenRepository;
	
	public Restaurant save(Restaurant restaurant) {

		Long kitchenId = restaurant.getKitchen().getId();
		Kitchen kitchen = kitchenRepository.findById(kitchenId);
		
		if (kitchen == null) {
			throw new EntityNotFoundException(
					String.format("There is no kitchen register with id %d ", kitchenId));
		}
		
		restaurant.setKitchen(kitchen);
		
		return restaurantRepository.add(restaurant);
	}
	
}
