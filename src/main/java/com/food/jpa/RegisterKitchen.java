package com.food.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.food.domain.model.Kitchen;

@Component
public class RegisterKitchen {
	
	@PersistenceContext
	private EntityManager manager;
	
	public List<Kitchen> list(){
		return manager.createQuery("from Kitchen", Kitchen.class).getResultList();		
	}
}
