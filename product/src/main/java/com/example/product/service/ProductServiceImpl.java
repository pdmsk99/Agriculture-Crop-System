package com.example.product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product.Exeception.DuplicateRecordFoundException;
import com.example.product.Exeception.RecordNotFoundException;
import com.example.product.dto.ProductDTO;
import com.example.product.model.Product;
import com.example.product.repository.productRepository;


@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private productRepository productrepository;
	
	private static final Logger login = LoggerFactory.getLogger(ProductServiceImpl.class);
	 
	@Override
	public List<ProductDTO> getAllProducts() throws RecordNotFoundException{

		List<ProductDTO> productDTO = new ArrayList<>();
		for(Product c:productrepository.findAll())
		{
			productDTO.add(convertEntityToDTO(c));
		}
		if(productDTO.isEmpty())
		{
			login.warn("Records Not Found");
			throw new RecordNotFoundException("Records Not Exists");
		}
		
		login.info("Retrived All Products");
		
		return productDTO;
	}
	
	@Override
	public List<ProductDTO> add(ProductDTO productDto) throws DuplicateRecordFoundException{
		System.out.println(productDto);
		if(productDto == null)
		{
			return null;
		}
		

		Product product = convertDTOToEntity(productDto);
		product = productrepository.save(product);
		productDto = convertEntityToDTO(product);
		List<ProductDTO> dto = new ArrayList<>();
		dto.add(productDto);	
		
		login.info("Added Product Successfull..!!!");
		
		return dto;
	}


	@Override
	public List<ProductDTO> delete(String productName) throws RecordNotFoundException{
		
		if(productName == null)
		{
			return null;
		}
		Product find = productrepository.findByName(productName);
		if(find== null)
		{
			login.warn("Records Not Found");
			throw new RecordNotFoundException("Records Not Exists");
		}
		productrepository.deleteByName(productName);
		List<ProductDTO> productDto = new ArrayList<>();
		for(Product c:productrepository.findAll())
		{
			productDto.add(convertEntityToDTO(c));
		}
		
		login.info("Deleted Product Successfully...!!!");
		
		return productDto;
	}



	@Override
	public ProductDTO findByName(String Name) throws RecordNotFoundException{
		if(Name.length() == 0)
		{
			return null;
		}
		Optional<Product>find = Optional.of(productrepository.findByName(Name));
		if(!find.isPresent() || find == null)
		{
			login.warn("Records Not Found");
			throw new RecordNotFoundException("Records Not Exists");
		}
		
		login.info("Product Found...!!!");
		
		return convertEntityToDTO(find.get());
	}
	
	public static Product convertDTOToEntity(ProductDTO productDto)
	{
		Product product = new Product();
		
	    product.setQuantity(productDto.getQuantity());
		product.setName(productDto.getName());
		product.setPrice(productDto.getPrice());
		product.setDescription(productDto.getDescription());
//		product.setImage(productDto.getImage());

		
		return product;
	}
	
	public List<Product> convertDTOToEntity(List<ProductDTO> productDto)
	{
		return productDto.stream().map(x -> convertDTOToEntity(x)).collect(Collectors.toList());
	}
	
	public static ProductDTO convertEntityToDTO(Product product)
	{
		ProductDTO productDto = new ProductDTO();
		
		productDto.setQuantity(product.getQuantity());
		productDto.setName(product.getName());
		productDto.setPrice(product.getPrice());
		productDto.setDescription(product.getDescription());

//		productDto.setImage(product.getImage());
		
		
		
		return productDto;
	}
	
	public List<ProductDTO> convertEntityToDTO(List<Product> product)
	{
		return product.stream().map(x -> convertEntityToDTO(x)).collect(Collectors.toList());
	}

	@Override
	public List<ProductDTO> update(ProductDTO bean) throws RecordNotFoundException{
		if(bean == null)
		{
			return null;
		}
		Product product = convertDTOToEntity(bean);
		product = productrepository.save(product);
		bean = convertEntityToDTO(product);
		List products = new ArrayList<>();
		products.add(bean);
		if(bean == null)
		{
			login.warn("Records Not Found");
			throw new RecordNotFoundException("Record not found");
		}
		
		login.info("Updated Product");
		
		return products;
	}


}