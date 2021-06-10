package com.example.product.product;

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
		
		if(productDto == null)
		{
			return null;
		}
		
		Optional<Product> checking = Optional.of(productrepository.findByproductName(convertDTOToEntity(productDto).getproductName()));
		if(checking.isPresent())
		{
			login.warn("Records Exists");
			throw new DuplicateRecordFoundException("Product Already Exists");
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
		Product find = productrepository.findByproductName(productName);
		if(find== null)
		{
			login.warn("Records Not Found");
			throw new RecordNotFoundException("Records Not Exists");
		}
		productrepository.deleteByproductName(productName);
		List<ProductDTO> productDto = new ArrayList<>();
		for(Product c:productrepository.findAll())
		{
			productDto.add(convertEntityToDTO(c));
		}
		
		login.info("Deleted Product Successfully...!!!");
		
		return productDto;
	}



	@Override
	public ProductDTO findByproductName(String productName) throws RecordNotFoundException{
		if(productName.length() == 0)
		{
			return null;
		}
		Optional<Product>find = Optional.of(productrepository.findByproductName(productName));
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
		
	
		product.setproductName(productDto.getproductName());
		product.setPrice(productDto.getPrice());
		product.setDescription(productDto.getDescription());
		product.setBrand(productDto.getBrand());
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
		
		
		productDto.setproductName(product.getproductName());
		productDto.setPrice(product.getPrice());
		productDto.setDescription(product.getDescription());
		productDto.setBrand(product.getBrand());
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