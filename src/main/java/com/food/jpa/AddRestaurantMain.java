package com.food.jpa;

import java.math.BigDecimal;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.food.FoodApiApplication;
import com.food.domain.model.Restaurant;
import com.food.domain.repository.RestaurantRepository;

public class AddRestaurantMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(FoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		RestaurantRepository restaurantRepository = applicationContext.getBean(RestaurantRepository.class);
		
		for (int i = 0; i < 1000; i++) {
			Restaurant restaurant = new Restaurant();
			restaurant.setName("restaurant_" + i);
			restaurant.setTaxFreight(new BigDecimal(i));
			
			restaurantRepository.add(restaurant);
		}
		
	}

}
