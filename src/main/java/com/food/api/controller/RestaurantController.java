package com.food.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.food.domain.exception.EntityNotFoundException;
import com.food.domain.model.Restaurant;
import com.food.domain.repository.RestaurantRepository;
import com.food.domain.service.RestaurantRegistrationService;

@RestController
@RequestMapping(value = "/restaurants")
public class RestaurantController {

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private RestaurantRegistrationService restaurantRegistration;
	
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

	@PostMapping
	public ResponseEntity<?> add (@RequestBody Restaurant restaurant){
		try {
			restaurant = restaurantRegistration.save(restaurant);
			
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(restaurant);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.badRequest()
					.body(e.getMessage());
		}
	}
	
}
	
