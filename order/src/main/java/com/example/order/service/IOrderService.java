package com.example.order.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Exceptions.OrderNotFoundException;
import com.example.order.dto.OrderDTO;

@Service
public interface IOrderService {

	OrderDTO createOrder(OrderDTO order);

	List<OrderDTO> getAllOrders();

	List<OrderDTO> findOrdersByUser(String emailId);

	String deleteOrder(int orderId);

	OrderDTO findOrder(Integer orderId);

	List<OrderDTO> updateOrder(OrderDTO order);

	List<OrderDTO> findOrdersByDate(LocalDate date);

	/** Method to get an order by the order id. **/
	OrderDTO findOrder(String orderId) throws OrderNotFoundException;

	/** Method to remove an order data. Use carefully! **/
	String deleteOrder(Integer orderId) throws OrderNotFoundException;

}
