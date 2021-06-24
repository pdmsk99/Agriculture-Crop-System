package com.example.order.controller;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.Exceptions.DatabaseException;
import com.example.Exceptions.OrderNotFoundException;
import com.example.order.dto.OrderDTO;
import com.example.order.service.IOrderService;


@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class OrderController {
	
	private static final Logger log = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	private IOrderService orderService;
	
	@GetMapping("/connet")
	public String test() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		String o = restTemplate.getForObject("http://localhost:8000/api/v1/find/{email}" , String.class);
		return o+"Uploaded order";
	}
	
	//End-point to insert order details into the database. 
	@PostMapping("/orders")
	public ResponseEntity<OrderDTO> insertOrder(@Validated @RequestBody OrderDTO order) throws OrderNotFoundException {
		
		System.out.println("Insert order started");
		log.info("Insert Order Start");
		OrderDTO orderReturned= orderService.createOrder(order);
		
		log.info("Order Inserted");
		return new ResponseEntity<OrderDTO>(orderReturned, HttpStatus.OK);
	
	}
	
	
	//End-point to get all orders in the database. 
	@GetMapping("/orders")
	public ResponseEntity<List<OrderDTO>> getAllOrders() throws DatabaseException{
		
		
		log.info("Fetching all orders ");
		List<OrderDTO> orders = orderService.getAllOrders();
		
		log.info("all available orders fetched");
		return new ResponseEntity<List<OrderDTO>>(orders, HttpStatus.OK);
	}
	
	
	//End-point for users to get their order details
	@GetMapping("/orders/user/{emailId}")
	public ResponseEntity<List<OrderDTO>> getAllOrdersByUser(@PathVariable("emailId") String emailId) throws OrderNotFoundException,DatabaseException{
		
		
		log.info("Finding orders by user !");
		List<OrderDTO> orders = orderService.findOrdersByUser(emailId);
		
		
		log.info("Orders received");
		return new ResponseEntity<List<OrderDTO>>(orders, HttpStatus.OK);
	}
	
	
    //End-point to remove order details. 
	@DeleteMapping("orders/{orderId}")
	public ResponseEntity<String> deleteOrder(@PathVariable("orderId")int orderId) throws  OrderNotFoundException {
			                      
		
		String status= orderService.deleteOrder(orderId);
			
		return new ResponseEntity<String>(status, HttpStatus.OK);
		
	}
	
	
	//End-point to find an order by the order id.
	@GetMapping("orders/{orderId}")
	public ResponseEntity<OrderDTO> findOrder (@PathVariable("orderId")Integer orderId) throws OrderNotFoundException {
			                       
		
		log.info("Finding Order");
		OrderDTO order= orderService.findOrder(orderId);
		
		return new ResponseEntity<OrderDTO>(order, HttpStatus.OK);
	}
	
	//End-point to update order details.
	@PutMapping("/orders")
	public ResponseEntity<List<OrderDTO>> updateOrder (@Validated @RequestBody OrderDTO order) throws OrderNotFoundException, DatabaseException {
			                      
		
		log.info("Updating Order");
		List<OrderDTO> orders = orderService.updateOrder(order);
		
		log.info("Order Updated");
		return new ResponseEntity<List<OrderDTO>>(orders,HttpStatus.OK);
	}
	
	
	//End-point to get order details by date.
	@GetMapping("/orders/bydate/{date}")
	public ResponseEntity<List<OrderDTO>> getAllOrdersByDate (@PathVariable("date") String dateInput) throws OrderNotFoundException {
		
		LocalDate date = LocalDate.parse(dateInput);
	                                     
		log.info("Finding orders by user !");
		List<OrderDTO> orders = orderService.findOrdersByDate(date);
		
		log.info("Orders for the given date found !");
		return new ResponseEntity<List<OrderDTO>>(orders,HttpStatus.OK);
	}

}