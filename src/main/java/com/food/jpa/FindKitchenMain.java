package com.food.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.food.FoodApiApplication;
import com.food.domain.model.Kitchen;

public class FindKitchenMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(FoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		RegisterKitchen registerKitchen = applicationContext.getBean(RegisterKitchen.class);
		
		List<Kitchen> listKitchen = registerKitchen.list();
		
		for (Kitchen kitchen : listKitchen) {
			System.out.println(kitchen.getName());
		}
	}

}
