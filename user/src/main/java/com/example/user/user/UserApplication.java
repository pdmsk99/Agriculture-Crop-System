package com.example.user.user;

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
public class UserApplication implements CommandLineRunner{
	
    @Autowired
    public UserRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User u1 =  new User("sai@mail.com", 999999999, "sai","krishna","SaiKrishna","home","nlr","nlr","Ap",524003,"farmer");
		
		repository.save(u1);
		
		System.out.println("*************");
		
		List<User> user = repository.findAll();
		
		for(User u : user) {
			System.out.println(u.toString());
		}
	}

}
