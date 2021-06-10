package com.example.product.product;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface productRepository extends MongoRepository<Product , String>{
	
	public Product findByproductName(String productName);

	public void deleteByproductName(String productName);

}
