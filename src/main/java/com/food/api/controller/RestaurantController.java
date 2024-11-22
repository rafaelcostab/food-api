package com.food.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.domain.exception.EntityNotFoundException;
import com.food.domain.model.Restaurant;
import com.food.domain.repository.KitchenRepository;
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
	
	@PutMapping("/{restaurantId}")
	public ResponseEntity<Object> update (@PathVariable Long restaurantId, @RequestBody Restaurant restaurant){
		try {
			Restaurant restaurantToUpdate = restaurantRepository.findById(restaurantId);
		
			if (restaurantToUpdate == null) {
				throw new EntityNotFoundException(
					String.format("There is no restaurant register with id %d ", restaurantId)
				);
			}
			
			BeanUtils.copyProperties(restaurant, restaurantToUpdate, "id");
		
			restaurant = restaurantRegistration.save(restaurantToUpdate);
		} catch (EntityNotFoundException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
	    }
		
		return ResponseEntity.ok(restaurant);
		
	}
	
}
	
