package com.food.domain.repository;

import java.util.List;

import com.food.domain.model.State;

public interface StateRepository {

	List<State> findAll();
	State findById(Long id);
	State add(State state);
	void remove(State state);
	
}
