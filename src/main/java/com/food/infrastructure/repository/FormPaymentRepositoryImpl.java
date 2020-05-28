package com.food.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.food.domain.model.FormPayment;
import com.food.domain.repository.FormPaymentRepository;

@Component
public class FormPaymentRepositoryImpl implements FormPaymentRepository{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<FormPayment> findAll() {
		return manager.createQuery("from FormPayment", FormPayment.class).getResultList();
	}

	@Override
	public FormPayment findById(Long id) {
		return manager.find(FormPayment.class, id);
	}

	@Transactional
	@Override
	public FormPayment add(FormPayment formPayment) {
		return manager.merge(formPayment);
	}

	@Transactional
	@Override
	public void remove(FormPayment formPayment) {
		formPayment = findById(formPayment.getId());
		manager.remove(formPayment);
	}

}
