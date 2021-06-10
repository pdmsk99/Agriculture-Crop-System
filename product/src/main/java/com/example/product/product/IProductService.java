package com.example.product.product;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface IProductService {

	public List<ProductDTO> add(ProductDTO bean);

	public List<ProductDTO> update(ProductDTO bean);

	public List<ProductDTO> delete(String productName);

	public ProductDTO findByproductName(String productName);

	public List<ProductDTO> getAllProducts();


}