package com.food.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.food.domain.model.City;
import com.food.domain.repository.CityRepository;

public class CityRepositoryImpl implements CityRepository{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<City> findAll() {
		return manager.createQuery("from City", City.class).getResultList();
	}

	@Override
	public City findById(Long id) {
		return manager.find(City.class, id);
	}

	@Transactional
	@Override
	public City add(City city) {
		return manager.merge(city);
	}

	@Transactional
	@Override
	public void remove(City city) {
		city = findById(city.getId());
		manager.remove(city);
	}

}
