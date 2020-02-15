package com.food;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.food.model.Client;
import com.food.service.ActivationClientService;

@Controller
public class MyFirstController {
	
	private ActivationClientService activationClientService;
	
	public MyFirstController(ActivationClientService activationClientService) {
		this.activationClientService = activationClientService;
	}

	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		
		Client client = new Client("Carl Johnson", "carl.johnson@gmail.com", "11912344432");
		
		activationClientService.activite(client);
		
		return "Hello World!";
	}
}
