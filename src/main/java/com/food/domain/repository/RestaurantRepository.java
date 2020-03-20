package com.food.domain.repository;

import java.util.List;

import com.food.domain.model.Restaurant;

public interface RestaurantRepository {
	
	List<Restaurant> findAll();
	Restaurant findById(Long id);
	Restaurant add(Restaurant restaurant);
	void remove(Restaurant restaurant);
	
}
