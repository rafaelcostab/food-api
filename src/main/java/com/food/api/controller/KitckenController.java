package com.food.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.domain.model.Kitchen;
import com.food.domain.repository.KitchenRepository;

@RestController
@RequestMapping("/kitchens")
public class KitckenController {
	
	@Autowired
	private KitchenRepository kitchenRepository;
	
	@GetMapping
	public List<Kitchen> list(){
		return kitchenRepository.findAll();
	}
	
}
