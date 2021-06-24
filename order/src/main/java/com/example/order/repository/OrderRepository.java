package com.example.order.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.order.entity.Orders;



public interface OrderRepository extends MongoRepository<Orders , Integer> {

	ArrayList<Orders> findByUserEmailId(String emailId);

	List<Orders> findByDate(LocalDate date);



}
