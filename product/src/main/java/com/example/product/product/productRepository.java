package com.example.product.product;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface productRepository extends MongoRepository<Product , String>{
	
	public Product findByName(String Name);

	public void deleteByName(String Name);

}
