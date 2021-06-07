package com.example.product.product;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProductController {
	
	@RequestMapping("/hello")
	public String test() {
		System.out.println("hello you have connected to product server");
		RestTemplate resttemplate = new RestTemplate();
		
		String s = resttemplate.getForObject("http://localhost:8002/hello", String.class);
		return  s +"Uploaded Products" ;
	}

}
