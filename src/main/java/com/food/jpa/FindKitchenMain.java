package com.food.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.food.FoodApiApplication;
import com.food.domain.model.Kitchen;
import com.food.domain.repository.KitchenRepository;

public class FindKitchenMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(FoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		KitchenRepository kitchens = applicationContext.getBean(KitchenRepository.class);
		
		Kitchen kitchen = kitchens.findById(1L);

		System.out.println(kitchen.getName());
		
	}

}
