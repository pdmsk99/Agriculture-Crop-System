package com.example.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.product.model.Product;

public interface productRepository extends MongoRepository<Product , String>{
	
	public Product findByName(String Name);

	public void deleteByName(String Name);

}
