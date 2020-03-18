package com.food.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.food.FoodApiApplication;
import com.food.domain.model.Kitchen;
import com.food.domain.repository.KitchenRepository;

public class FindAllKitchensMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(FoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		KitchenRepository registerKitchen = applicationContext.getBean(KitchenRepository.class);
		
		List<Kitchen> listKitchen = registerKitchen.findAll();
		
		for (Kitchen kitchen : listKitchen) {
			System.out.println(kitchen.getName());
		}
	}

}
