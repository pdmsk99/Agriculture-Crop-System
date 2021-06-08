package com.example.user.user;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User , String>{
	
	Optional<User>findByEmailId(String emailId);

}
