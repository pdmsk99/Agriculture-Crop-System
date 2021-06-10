package com.example.address;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.address.Address;
public interface AddressRepository extends MongoRepository<Address, Integer>{

	

}
