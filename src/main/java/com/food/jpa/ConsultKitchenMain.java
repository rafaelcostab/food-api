package com.food.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.food.FoodApiApplication;
import com.food.domain.model.Kitchen;

public class ConsultKitchenMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(FoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		RegisterKitchen registerKitchen = applicationContext.getBean(RegisterKitchen.class);
		
		Kitchen kitchen = registerKitchen.find(1L);

		System.out.println(kitchen.getName());
		
	}

}
