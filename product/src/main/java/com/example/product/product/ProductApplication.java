package com.example.product.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductApplication implements CommandLineRunner{
	
    @Autowired
    public Repository repository;
	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Product p1 = new Product(111213 , "SaiKrishna" , 111 , "AbbaPurush" );
		Product p2  = new Product(1112131 , "KrishnaSai" , 112 , "AbbaStre");
		
		repository.save(p1);
		repository.save(p2);
		System.out.println("***************");
		
		List<Product> product = repository.findAll();
		
		for(Product p :product) {
			System.out.println(p.toString());
		}
	}

}
