package com.example.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.dto.UserDTO;
import com.example.user.service.IUserService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private IUserService userService;

	@GetMapping("/test")
	public String test() {
		System.out.println("hello you have connected to user server");
//		RestTemplate resttemplate = new RestTemplate();
//		
//		String s = resttemplate.getForObject("http://localhost:8001/product/connect", String.class);
		return "Uploaded user";
	}

	// add
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/users")
	public ResponseEntity<List<UserDTO>> add(@Valid @RequestBody UserDTO userDto) {

		log.info("Insert User Start");
		List<UserDTO> users = userService.add(userDto);
		if (users.isEmpty()) {
			log.warn("User Already Avaliable");
			return new ResponseEntity("Sorry! Users not available!", HttpStatus.NOT_FOUND);
		}

		log.info("User addded successfully");
		return new ResponseEntity<List<UserDTO>>(users, HttpStatus.OK);
	}

	// getAllUsers
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/users")
	public ResponseEntity<List<UserDTO>> getAllUsers() {

		log.info("Fetching Users Started");
		List<UserDTO> users = userService.getAllUsers();
		if (users.isEmpty()) {
			log.warn("No Users Available");
			return new ResponseEntity("Sorry! Users not available!", HttpStatus.NOT_FOUND);
		}
		log.info("User retrived successfully");
		return new ResponseEntity<List<UserDTO>>(users, HttpStatus.OK);
	}

	// delete
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@DeleteMapping("/delete/{email}")
	public ResponseEntity<List<UserDTO>> delete(@Valid @PathVariable("email") String emailId) {

		List<UserDTO> users = userService.delete(emailId);
		if (users.isEmpty() || users == null) {
			log.warn("No User Available");
			return new ResponseEntity("Sorry! User not available!", HttpStatus.NOT_FOUND);
		}
		log.info("Delete User Successfully");
		return new ResponseEntity<List<UserDTO>>(users, HttpStatus.OK);
	}

	// update
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PutMapping("/update")
	public ResponseEntity<List<UserDTO>> update(@Valid @RequestBody UserDTO userDto) {

		List<UserDTO> users = userService.update(userDto);
		if (users.isEmpty()) {
			log.warn("No User Available");
			return new ResponseEntity("Sorry! Users not available!", HttpStatus.NOT_FOUND);
		}
		log.info("Update User Successfully");
		return new ResponseEntity<List<UserDTO>>(users, HttpStatus.OK);
	}

	// finddByLogin
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/find/{email}")
	public ResponseEntity<UserDTO> findByLogin(@Valid @PathVariable("email") String emailId) {

		UserDTO user = userService.findByLogin(emailId);
		if (user == null) {
			log.warn("No User Available");
			return new ResponseEntity("Sorry! User not found!", HttpStatus.NOT_FOUND);
		}
		log.info("Retrieved User Successfully");

		return new ResponseEntity<UserDTO>(user, HttpStatus.OK);
	}

	// signin
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/login")
	public ResponseEntity<UserDTO> loginUser(@RequestBody UserDTO userDto) {
		UserDTO user = userService.findByLogin(userDto.getEmailId());
		if (user == null) {
			return new ResponseEntity("Sorry! Users not available!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UserDTO>(user, HttpStatus.OK);
	}
}
