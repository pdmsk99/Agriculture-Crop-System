package com.example.address.address;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AddressApplication implements CommandLineRunner {
	
	@Autowired
	private Repository repository;
	public static void main(String[] args) {
		SpringApplication.run(AddressApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		address a1 = new address("66769", "saiKrishna");
		address a2 = new address("66770", "KrishnaSai");
		
		repository.save(a1);
		repository.save(a2);
		System.out.println("*****************");
		
		List<address> Address =  repository.findAll();
		
		for(address a : Address){
			System.out.println(a.toString());
		}
	}

}
