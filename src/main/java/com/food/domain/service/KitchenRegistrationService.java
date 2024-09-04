package com.food.domain.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.food.domain.exception.EntityInUseException;
import com.food.domain.exception.EntityNotFoundException;
import com.food.domain.model.Kitchen;
import com.food.domain.repository.KitchenRepository;

@Service 
public class KitchenRegistrationService {

	@Autowired
	KitchenRepository kitchenRepository;
	
	public Kitchen add(Kitchen kitchen) {
		return kitchenRepository.add(kitchen);
	}
	
	public void remove(Long kitchenId) {
		try {
			kitchenRepository.remove(kitchenId);
		}  catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException(
					String.format("There is no kitchen register with id %d ", kitchenId));
		} catch (DataIntegrityViolationException e) {
			throw new EntityInUseException(
					String.format("Kitchen id %d cannot be removed as it is in use", kitchenId));
		}
	}
	
}
