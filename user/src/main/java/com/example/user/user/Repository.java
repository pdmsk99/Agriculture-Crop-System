package com.example.user.user;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface Repository extends MongoRepository<User , String>{

}
