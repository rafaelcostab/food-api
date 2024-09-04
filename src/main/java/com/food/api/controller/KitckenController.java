package com.food.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.food.api.model.KitchensXmlWrapper;
import com.food.domain.exception.EntityInUseException;
import com.food.domain.exception.EntityNotFoundException;
import com.food.domain.model.Kitchen;
import com.food.domain.repository.KitchenRepository;
import com.food.domain.service.KitchenRegistrationService;

@RestController
@RequestMapping(value = "/kitchens")
public class KitckenController {
	
	@Autowired
	private KitchenRepository kitchenRepository;
	
	@Autowired
	private KitchenRegistrationService kitchenRegistration;
	
	@GetMapping
	public List<Kitchen> list(){
		return kitchenRepository.findAll();
	}
	
	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public KitchensXmlWrapper findXml() {
		return new KitchensXmlWrapper(kitchenRepository.findAll());
	}
	
	@GetMapping("/{kitchenId}")
	public ResponseEntity<Kitchen> find(@PathVariable Long kitchenId){
		Kitchen kitchen = kitchenRepository.findById(kitchenId);
		
		if (kitchen != null ) {
			return ResponseEntity.ok(kitchen);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Kitchen add(@RequestBody Kitchen kitchen) {
		return kitchenRegistration.add(kitchen);
	}
	
	@PutMapping("/{kitchenId}")
	public ResponseEntity<Kitchen> update (@PathVariable Long kitchenId, @RequestBody Kitchen kitchen){
		Kitchen kitchenActual = kitchenRepository.findById(kitchenId);
		
		if (kitchenActual != null) {
			BeanUtils.copyProperties(kitchen, kitchenActual, "id");
			
			kitchenActual = kitchenRepository.add(kitchenActual);

			return ResponseEntity.ok(kitchenActual);
		}
		
		return ResponseEntity.notFound().build();
		
	}

	@DeleteMapping("/{kitchenId}")
	public ResponseEntity<Kitchen> remove(@PathVariable Long kitchenId){

		try {

			kitchenRegistration.remove(kitchenId);
			return ResponseEntity.noContent().build();

		} catch (EntityNotFoundException e) {

			return ResponseEntity.notFound().build();

		} catch (EntityInUseException e) {

			return ResponseEntity.status(HttpStatus.CONFLICT).build();

		}
	}
	
}
