package com.food.jpa;

import java.math.BigDecimal;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.food.FoodApiApplication;
import com.food.domain.model.Restaurant;
import com.food.domain.repository.RestaurantRepository;

public class UpdateKitchenMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(FoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		RestaurantRepository restaurantRepository = applicationContext.getBean(RestaurantRepository.class);
		
		Restaurant restaurant = new Restaurant();
		restaurant.setId(1L);
		restaurant.setName("Esquerda Esquerta");
		restaurant.setTaxFreight(new BigDecimal(12.0));
		
		restaurantRepository.add(restaurant);
		
	}

}
