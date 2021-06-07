package com.example.order.order;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface Repository extends MongoRepository<Orders , String> {

}
