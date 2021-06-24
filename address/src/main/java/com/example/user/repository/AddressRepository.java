package com.example.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.address.model.Address;

public interface AddressRepository extends MongoRepository<Address, Integer> {

}
