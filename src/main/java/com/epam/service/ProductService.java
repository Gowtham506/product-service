package com.epam.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import com.epam.dtos.ProductBean;
import com.epam.dtos.ProductDTO;
import com.epam.exception.ProductException;
import com.epam.model.Product;

public interface ProductService {
	
	public ProductDTO saveProduct(Product product) throws ProductException;
	public List<Product> getProducts();
	public Product getProductById(Long productId) throws ProductException;
	public void deleteProductById(@PathVariable("productId") @Min(2) Long productId);
	public Product updateProducts(@Valid @RequestBody ProductBean product);

}
