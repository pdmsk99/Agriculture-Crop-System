package com.example.user.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {
	
	@RequestMapping("/hello")
	public String test() {
		RestTemplate resttemplate= new RestTemplate();
		
		String s = resttemplate.getForObject("http://localhost:8001/hello", String.class);

		return s +"Uploaded User";
		
	}

}
