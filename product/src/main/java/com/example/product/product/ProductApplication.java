package com.example.product.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = {
	    DataSourceAutoConfiguration.class, 
	    DataSourceTransactionManagerAutoConfiguration.class, 
	    HibernateJpaAutoConfiguration.class })
public class ProductApplication implements CommandLineRunner{
	
    @Autowired
    public productRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Product p1 = new Product("Rice", 25 , "rich in quality", 10);
		Product p2 = new Product("Brown Rice", 25 , "rich in quality", 10);
		repository.save(p1);
		repository.save(p2);
		
		System.out.println("***************");
		
		List<Product> product = repository.findAll();
		
		for(Product p :product) {
			System.out.println(p.toString());
		}
	}

}
