package com.food.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.api.model.KitchensXmlWrapper;
import com.food.domain.model.Kitchen;
import com.food.domain.repository.KitchenRepository;

@RestController
@RequestMapping(value = "/kitchens")
public class KitckenController {
	
	@Autowired
	private KitchenRepository kitchenRepository;
	
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
		
		//return ResponseEntity.status(HttpStatus.OK).body(kitchen);
		//return ResponseEntity.ok(kitchen);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.LOCATION, "http://localhost:8080/kitchens");
		
		return ResponseEntity
				.status(HttpStatus.FOUND)
				.headers(headers)
				.build();
	}

}
