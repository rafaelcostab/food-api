package com.food.domain.repository;

import java.util.List;

import com.food.domain.model.Kitchen;

public interface KitchenRepository {
	
	List<Kitchen> findAll();
	List<Kitchen> findByName(String name);
	Kitchen findById(Long id);
	Kitchen add(Kitchen kitchen);
	void remove(Long kitchenId);
	
}
