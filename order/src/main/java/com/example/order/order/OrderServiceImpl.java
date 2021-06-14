 package com.example.order.order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exceptions.DatabaseException;
import com.example.Exceptions.OrderNotFoundException;


@Service
public class OrderServiceImpl implements IOrderService {
	
	private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

	
	@Autowired
	OrdersRepository ordersRepository;
	
	public static OrderDTO entityToDTO(Orders order) {
		
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setOrderId(order.getOrderId());
		orderDTO.setDate(order.getDate());
		orderDTO.setAmount(order.getAmount());
		
		UserDTO userDTO = UserServiceImpl.convertEntityToDTO(order.getUser());
//		userDTO.setFirstName(order.getUser().getFirstName());
//		userDTO.setLastName(order.getUser().getLastName());
//		userDTO.setMobileNo(order.getUser().getMobileNo());
//		userDTO.setEmailId(order.getUser().getEmailId());
//		userDTO.setPassword(order.getUser().getPassword());
//		userDTO.setHomeAddress(order.getUser().getHomeAddress());
//		userDTO.setDistrict(order.getUser().getDistrict());
//		userDTO.setCity(order.getUser().getCity());
//		userDTO.setState(order.getUser().getState());
//		userDTO.setPincode(order.getUser().getPincode());
		//userDTO.setOrders(null);
		
		
		orderDTO.setUser(userDTO);
		
		Set<ProductDTO> productsDTO = new HashSet<>();
		Set<Product> products = order.getProducts();
		for (Product p : products ) {
			
			ProductDTO productDTO = ProductServiceImpl.convertEntityToDTO(p);
//			productDTO.setCode(p.getCode());
//			productDTO.setName(p.getName());
//			productDTO.setDescription(p.getDescription());
//			productDTO.setPrice(p.getPrice());
//			productDTO.setBrand(p.getBrand());
			productsDTO.add(productDTO);
		
		}
		
		orderDTO.setProducts(productsDTO);
		
		
		return orderDTO;
	}
	
	public static Orders DTOToEntity(OrderDTO orderDTO) {
		Orders orders = new Orders();
		orders.setId(orderDTO.getOrderId());
		orders.setDate(orderDTO.getDate());
		orders.setAmount(orderDTO.getAmount());
		
		User user = UserServiceImpl.convertDTOToEntity(orderDTO.getUser());
//		user.setFirstName(orderDTO.getUser().getFirstName());
//		user.setLastName(orderDTO.getUser().getLastName());
//		user.setMobileNo(orderDTO.getUser().getMobileNo());
//		user.setEmailId(orderDTO.getUser().getEmailId());
//		user.setPassword(orderDTO.getUser().getPassword());
//		user.setHomeAddress(orderDTO.getUser().getHomeAddress());
//		user.setDistrict(orderDTO.getUser().getDistrict());
//		user.setCity(orderDTO.getUser().getDistrict());
//		user.setState(orderDTO.getUser().getState());
//		user.setPincode(orderDTO.getUser().getPincode());
		//user.setOrders(null);
		
		orders.setUser(user);
		
		Set<ProductDTO> productsDTO = orderDTO.getProducts();

		Set<Product> products = new HashSet<>();
		for (ProductDTO p : productsDTO ) {
			
			Product product = ProductServiceImpl.convertDTOToEntity(p);
//			product.setCode(p.getCode());
//			product.setName(p.getName());
//			product.setDescription(p.getDescription());
//			product.setPrice(p.getPrice());
//			product.setBrand(p.getBrand());
			products.add(product);
		}
		
		orders.setProducts(products);
		
        
		return orders;
	}
	
	/** Method the get a list of all orders in the database **/
	@Override
	public List<OrderDTO> getAllOrders() throws DatabaseException {
		
		List<Orders> orders =  ordersRepository.findAll();
		if(orders.size()<1) {
			
			log.error("No orders in database!");
			throw new DatabaseException();
		}
		
		List<OrderDTO> ordersReturn = new ArrayList<>();
		for (Order o : orders ) {
			ordersReturn.add(entityToDTO(o));
		}
		
		log.info("Orders fetched!");
		return ordersReturn;
	}

	
	/** Method to get an order by the order id. **/
	@Override
	public OrderDTO findOrder(Integer orderId) throws OrderNotFoundException {
		if(orderId == null) {
			log.info("Please enter valid orderId.");
			return null;
		}
		
		Optional<Orders> order = ordersRepository.findById(orderId);
		
		if(!order.isPresent() || order == null) {
			log.error("Order not present.");
			throw new OrderNotFoundException();
		}
		
		log.info("Order fetched!");
		return entityToDTO(order.get());
	}
	
	
	/** Method to get list of oders purchased on a particular date. **/
	@Override
	public List<OrderDTO> findOrdersByDate (LocalDate date) throws OrderNotFoundException, DatabaseException{
		if(date == null) {
			log.info("Please enter valid orderId.");
			return null;
		}
		
		List<Orders> orders;
		try {
			
			log.warn("Checking for order by date");
		    orders = ordersRepository.findByDate(date);
		}
		catch(Exception e) {
			log.warn("Order not present.");
			throw new OrderNotFoundException();
		}
	
		List<OrderDTO> ordersReturn = new ArrayList<>();
		for (Orders o : orders ) {
			ordersReturn.add(entityToDTO(o));
		}
		
		log.info("Order fetched");
		return ordersReturn;	
		
	}


	/** Method to remove an order data. Use carefully! **/
	@Override
	public String deleteOrder(Integer orderId) throws OrderNotFoundException {
		if(orderId == null) {
			log.info("Enter valid id");
			return null;
		}
		
		try {
			
			log.warn("Checking for orderID to be deleted.");
		    ordersRepository.deleteById(orderId);
		}
		
		catch(Exception e) {
			log.error("Order not present");
			throw new OrderNotFoundException();
		}
		
		return "Order deleted!";	
	}

	
	/** Method the insert an order and return the entire list of orders present. **/
	@Override
	public OrderDTO createOrder(OrderDTO orderDTO) throws OrderNotFoundException, DatabaseException{
		if(orderDTO == null) {
			log.info("Please enter valid orderId.");
			return null;
		}
		System.out.println("add dto"+orderDTO);
		
		Orders order = DTOToEntity(orderDTO);
		System.out.println("add entity"+order);
		
		Orders returned = ordersRepository.save(order);
		
	    return entityToDTO(returned);	
	}

	/** Method the update an order. **/
	@Override
	public List<OrderDTO> updateOrder(OrderDTO orderDTO) throws OrderNotFoundException, DatabaseException{
		if(orderDTO == null) {
			log.info("Please enter valid orderId.");
			return null;
		}
		
		Optional<Orders> order = ordersRepository.findById(orderDTO.getOrderId());
		
		if(!order.isPresent() || order == null) {
			log.info("Order not present");
			throw new OrderNotFoundException();
		}
		
        ordersRepository.save(DTOToEntity(orderDTO));
		
		List<OrderDTO> ordersReturn = new ArrayList<>();
		List<Order> orders = orderDao.findAll();
		
		if(orders.size()<1) {
			log.error("No orders in database! Please check");
			throw new OrderNotFoundException();
	    }
	
		for (Orders o : orders ) {
			ordersReturn.add(entityToDTO(o));
		}
		
		return ordersReturn;
	}
			

	//Method for users to find their order details.
	@Override
	public List<OrderDTO> findOrdersByUser(String emailId) throws DatabaseException{
		if(emailId == null) {
			log.info("Please enter valid orderId.");
			return null;
		}
		
		List<Orders> orders = new ArrayList<>();
		ordersRepository.findByUserEmailId(emailId).forEach(orders::add);
		
		if(orders.size()<1 || orders == null) {
			
			log.error("No order details found");
			throw new DatabaseException();
		}
		
		List<OrderDTO> ordersReturn = new ArrayList<>();
		for (Orders o : orders ) {
			ordersReturn.add(entityToDTO(o));
		}
		log.info("User order fetched");
		
		return ordersReturn;
	}

}
