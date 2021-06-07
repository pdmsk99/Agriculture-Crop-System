package com.example.product.product;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface Repository extends MongoRepository<Product , String>{

}
