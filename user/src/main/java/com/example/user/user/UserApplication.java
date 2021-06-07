package com.example.user.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserApplication implements CommandLineRunner{
	
    @Autowired
    public Repository repository;
	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User u1 =  new User(120 ,"SaiKrishna",999999999 ,"abc@def.com");
		User u2 = new User(121 , "KrishnaSai" , 88888888 , "xyz@abc.com");
		
		repository.save(u1);
		repository.save(u2);
		System.out.println("*************");
		
		List<User> user = repository.findAll();
		
		for(User u : user) {
			System.out.println(u.toString());
		}
	}

}
