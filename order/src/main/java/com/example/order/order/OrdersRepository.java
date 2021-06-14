package com.example.order.order;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface OrdersRepository extends MongoRepository<Orders , String> {
	
public List<Orders> findByUserEmailId(String emailId);
	
	public List<Orders> findByDate(LocalDate date);

}
