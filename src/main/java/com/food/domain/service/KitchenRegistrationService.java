package com.food.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.domain.model.Kitchen;
import com.food.domain.repository.KitchenRepository;

@Service 
public class KitchenRegistrationService {

	@Autowired
	KitchenRepository kitchenRepository;
	
	public Kitchen add(Kitchen kitchen) {
		return kitchenRepository.add(kitchen);
	}
	
}
