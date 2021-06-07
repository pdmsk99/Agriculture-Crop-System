package com.example.order.order;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
	
	@RequestMapping("/hello")
	public String test() {
		RestTemplate resttemplate = new RestTemplate();
		System.out.println("hello you have connected to Order server");
		String s = resttemplate.getForObject("http://localhost:8003/hello", String.class);
		return s+"uploaded Orders" ;
	}
	
	

}
