package com.food.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.food.FoodApiApplication;
import com.food.domain.model.Kitchen;

public class IncludeKitchenMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(FoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		RegisterKitchen registerKitchen = applicationContext.getBean(RegisterKitchen.class);
		
		Kitchen kitchen1 = new Kitchen();
		kitchen1.setName("Brasilian");
		
		Kitchen kitchen2 = new Kitchen();
		kitchen2.setName("Japonese");
		
		kitchen1 = registerKitchen.save(kitchen1);
		kitchen2 = registerKitchen.save(kitchen2);
		
		System.out.printf("%d - %s\n", kitchen1.getId(), kitchen1.getName());
		System.out.printf("%d - %s\n", kitchen2.getId(), kitchen2.getName());
	}

}