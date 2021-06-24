package com.example.product.controller;

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
import org.springframework.web.client.RestTemplate;

import com.example.product.Exeception.RecordNotFoundException;
import com.example.product.dto.ProductDTO;
import com.example.product.service.IProductService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class ProductController {

	@Autowired
	private IProductService productService;

	private static final Logger login = LoggerFactory.getLogger(ProductController.class);

	@GetMapping("/connect")
	public String test() {
		login.info("product data fetching");
		System.out.println("hello you have connected to product server");
		RestTemplate resttemplate = new RestTemplate();

		String s = resttemplate.getForObject("http://localhost:8002/api/v1/connect", String.class);
		return s + "Uploaded Products";
	}

	@GetMapping("/products")
	public ResponseEntity<List<ProductDTO>> getAllCustomers() throws RecordNotFoundException {

		List<ProductDTO> product = productService.getAllProducts();

		login.info("Retrived All Products");

		return new ResponseEntity<List<ProductDTO>>(product, HttpStatus.OK);
	}

	@GetMapping("/products/{productName}")
	public ResponseEntity<ProductDTO> findProduct(@Valid @PathVariable("productName") String productName)
			throws RecordNotFoundException {
		ProductDTO product = productService.findByName(productName);

		login.info("Product Found...!!!");
		return new ResponseEntity<ProductDTO>(product, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<List<ProductDTO>> add(@Valid @RequestBody ProductDTO productDto) {
		System.out.println(productDto);
		List<ProductDTO> product = productService.add(productDto);

		login.info("Added Product Successfull..!!!");
		return new ResponseEntity<List<ProductDTO>>(product, HttpStatus.OK);
	}

	@PutMapping("/update-products")
	public ResponseEntity<List<ProductDTO>> update(@Valid @RequestBody ProductDTO product) {
		System.out.println(product);
		List<ProductDTO> products = productService.update(product);

		login.info("Updated Product");
		return new ResponseEntity<List<ProductDTO>>(products, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{productName}")
	public ResponseEntity<List<ProductDTO>> delete(@Valid @PathVariable("productName") String productName) {
		List<ProductDTO> products = productService.delete(productName);

		login.info("Deleted Product Successfully...!!!");
		return new ResponseEntity<List<ProductDTO>>(products, HttpStatus.OK);
	}

}
