package com.food.domain.repository;

import java.util.List;

import com.food.domain.model.Kitchen;

public interface KitchenRepository {
	
	List<Kitchen> findAll();
	Kitchen findById(Long id);
	Kitchen add(Kitchen kitchen);
	void remove(Kitchen kitchen);
	
}
