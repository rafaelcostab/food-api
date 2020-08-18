package com.food.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.domain.model.Kitchen;
import com.food.domain.repository.KitchenRepository;

@RestController
@RequestMapping(value = "/kitchens") //, produces = MediaType.APPLICATION_JSON_VALUE)
public class KitckenController {
	
	@Autowired
	private KitchenRepository kitchenRepository;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Kitchen> list1(){
		System.out.println("List 1");
		return kitchenRepository.findAll();
	}
	
	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public List<Kitchen> list2(){
		System.out.println("List 2");
		return kitchenRepository.findAll();
	}
	
}
