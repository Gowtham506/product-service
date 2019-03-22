package com.epam.service;

import java.util.List;

import com.epam.dtos.ProductDTO;
import com.epam.exception.ProductException;
import com.epam.model.Product;

public interface ProductService {
	
	public ProductDTO saveProduct(Product product);
	public List<Product> getProducts();
	public Product getProductById(Long productId) throws ProductException;

}
