package com.food.domain.repository;

import java.util.List;

import com.food.domain.model.FormPayment;

public interface FormPaymentRepository {
	
	List<FormPayment> findAll();
	FormPayment findById(Long id);
	FormPayment add(FormPayment formPayment);
	void remove(FormPayment formPayment);
	
}
