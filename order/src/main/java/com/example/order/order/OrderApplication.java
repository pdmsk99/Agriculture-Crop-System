package com.example.order.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = {
	    DataSourceAutoConfiguration.class, 
	    DataSourceTransactionManagerAutoConfiguration.class, 
	    HibernateJpaAutoConfiguration.class })
public class OrderApplication{
	
//	@Autowired
//	private Repository repository;
	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}
	
//	@Override
//	public void run(String... args) throws Exception {
//		Orders o1 = new Orders( 141615 , "SaiKrishna" , 121 , "****************");
//		Orders o2 = new Orders( 141616 , "KrishnaSai" , 122 , "*********");
//		
//		repository.save(o1);
//		repository.save(o2);
//		System.out.println("****************");
//		
//		List<Orders> orders = repository.findAll();
//		
//		for (Orders o : orders) {
//			System.out.println(o.toString());
//		}
//	}

}
