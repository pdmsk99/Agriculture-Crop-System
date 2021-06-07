package com.example.address.address;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class addressController {

	@RequestMapping("/hello")
	public String test() {
		System.out.println("hello you have connected to address server");
		return "uploaded Address" ;
	}

}
