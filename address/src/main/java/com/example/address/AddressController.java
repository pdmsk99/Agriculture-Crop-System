package com.example.address;

import java.util.List;

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

import com.example.Exceptions.RecordNotFoundException;


@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class AddressController {
	private static final Logger log=LoggerFactory.getLogger(AddressController.class);
	
	@Autowired
    private IAddressService service;
	
	@GetMapping("/hello")
	public String test() {
		System.out.println("hello you have connected to address server");
		return "uploaded Address" ;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/address")
	public ResponseEntity<AddressDTO> addAddress( @RequestBody AddressDTO address){
		log.info("Adding Address START");
		AddressDTO addresses= service.add(address);
		if(addresses==null)
		{
			log.error("No Address available");
			return new ResponseEntity("Sorry! Address not available!", 
					HttpStatus.NOT_FOUND);
		}
		log.info("Address Added Successfully");
		return new ResponseEntity<AddressDTO>(addresses, HttpStatus.OK);
	}  
	
	
	
	@PutMapping("/address")
	public ResponseEntity<AddressDTO> updateAddress(@RequestBody AddressDTO address){
		log.info("START");
		AddressDTO addresses= service.update(address);
		if(addresses==null)
		{
			return new ResponseEntity("Sorry! Products not available!",HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<AddressDTO>(addresses, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/address/{addressId}")
	public ResponseEntity<AddressDTO> deleteProduct(@PathVariable("addressId")Integer addressId) throws RecordNotFoundException{
		log.info("START");
		AddressDTO addresses= service.delete(addressId);
		if(addresses==null) {
			return new ResponseEntity("Sorry! AddressId not available!", 
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<AddressDTO>(addresses, HttpStatus.OK);
}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/address/{addressId}")
	public ResponseEntity<AddressDTO> findById(@PathVariable("addressId")Integer addressId) throws RecordNotFoundException{
		log.info("START");
		AddressDTO address= service.findById(addressId);
		if(address==null) {
			return new ResponseEntity("Sorry! Products not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<AddressDTO>(address, HttpStatus.OK);
	}

	@GetMapping("/address")
	public ResponseEntity<List<AddressDTO>> getAddress(){
		log.info("START");
		List<AddressDTO> addresses= service.getAddress();
//		if(addresses==null) {
//			return new ResponseEntity("Sorry! Products not available!",HttpStatus.NOT_FOUND);
//		}
		
		return new ResponseEntity<List<AddressDTO>>(addresses, HttpStatus.OK);
	}
	
}





