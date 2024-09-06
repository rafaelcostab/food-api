package com.food.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.domain.model.Restaurant;
import com.food.domain.repository.RestaurantRepository;

@RestController
@RequestMapping(value = "/restaurants")
public class RestaurantController {

	@Autowired
	RestaurantRepository restaurantRepository;
	
	@GetMapping()
	public List<Restaurant> findAll(){
		return restaurantRepository.findAll();
	}
	
	@GetMapping("/restaurant/{restaurantId}")
	public ResponseEntity<Restaurant> find(@PathVariable Long restaurantId){
		Restaurant restaurant = restaurantRepository.findById(restaurantId);
		
		if (restaurant != null) {
			return ResponseEntity.ok(restaurant);
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
