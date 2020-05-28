package com.food.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.food.domain.model.State;
import com.food.domain.repository.StateRepository;

public class StateRepositoryImpl implements StateRepository{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<State> findAll() {
		return manager.createQuery("from State", State.class).getResultList();
	}

	@Override
	public State findById(Long id) {
		return manager.find(State.class, id);
	}

	@Override
	public State add(State state) {
		return manager.merge(state);
	}

	@Override
	public void remove(State state) {
		state = findById(state.getId());
		manager.remove(state);
	}

}
