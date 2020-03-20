package com.food.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.food.FoodApiApplication;
import com.food.domain.model.Restaurant;
import com.food.domain.repository.RestaurantRepository;

public class FindAllRestaurantsMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(FoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		RestaurantRepository restaurantRespository = applicationContext.getBean(RestaurantRepository.class);
		
		List<Restaurant> restaurants = restaurantRespository.findAll();
		
		for (Restaurant restaurant : restaurants) {
			System.out.println(restaurant.getName());
		}
	}

}
