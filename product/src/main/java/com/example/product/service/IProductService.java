package com.example.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.product.dto.ProductDTO;

@Service
public interface IProductService {

	public List<ProductDTO> add(ProductDTO bean);

	public List<ProductDTO> update(ProductDTO bean);

	public List<ProductDTO> delete(String Name);

	public ProductDTO findByName(String Name);

	public List<ProductDTO> getAllProducts();

}