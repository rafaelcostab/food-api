package com.food.domain.repository;

import java.util.List;

import com.food.domain.model.City;

public interface CityRepository {

	List<City> findAll();
	City findById(Long id);
	City add(City city);
	void remove(City city);
	
}
