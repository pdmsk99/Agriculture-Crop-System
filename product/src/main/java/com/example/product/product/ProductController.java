package com.example.product.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RequestMapping("/product")
@RestController
public class ProductController {
	
	private static final Logger login=LoggerFactory.getLogger(ProductController.class);
	
	@GetMapping("/connect")
	public String test() {
		login.info("product data fetching");
		System.out.println("hello you have connected to product server");
		RestTemplate resttemplate = new RestTemplate();
		
		String s = resttemplate.getForObject("http://localhost:8002/hello", String.class);
		return  s +"Uploaded Products" ;
	}

}
