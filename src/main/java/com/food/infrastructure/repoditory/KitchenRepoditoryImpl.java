package com.food.infrastructure.repoditory;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.food.domain.model.Kitchen;
import com.food.domain.repository.KitchenRepository;

@Component
public class KitchenRepoditoryImpl implements KitchenRepository{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Kitchen> findAll(){
		return manager.createQuery("from Kitchen", Kitchen.class).getResultList();		
	}
	
	@Override
	public Kitchen findById(Long id) {
		return manager.find(Kitchen.class, id);
	}
	
	@Transactional
	@Override
	public Kitchen add(Kitchen kitchen) {
		return manager.merge(kitchen);
	}
	
	@Transactional
	@Override
	public void remove(Kitchen kitchen) {
		kitchen = findById(kitchen.getId());
		manager.remove(kitchen);
	}

}
