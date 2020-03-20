package com.food.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.food.domain.model.Restaurant;
import com.food.domain.repository.RestaurantRepository;

@Component
public class RestaurantRepositoryImpl implements RestaurantRepository{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Restaurant> findAll(){
		return manager.createQuery("from Restaurant", Restaurant.class).getResultList();		
	}
	
	@Override
	public Restaurant findById(Long id) {
		return manager.find(Restaurant.class, id);
	}
	
	@Transactional
	@Override
	public Restaurant add(Restaurant restaurant) {
		return manager.merge(restaurant);
	}
	
	@Transactional
	@Override
	public void remove(Restaurant restaurant) {
		restaurant = findById(restaurant.getId());
		manager.remove(restaurant);
	}

}
