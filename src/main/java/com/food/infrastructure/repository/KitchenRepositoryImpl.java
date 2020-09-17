 package com.food.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.food.domain.model.Kitchen;
import com.food.domain.repository.KitchenRepository;

@Repository
public class KitchenRepositoryImpl implements KitchenRepository{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Kitchen> findAll(){
		return manager.createQuery("from Kitchen", Kitchen.class).getResultList();		
	}
	
	@Override
	public List<Kitchen> findByName(String name) {
		return manager.createQuery("from Kitchen where name like :name", Kitchen.class)
				.setParameter("name", "%" + name + "%")
				.getResultList();
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
