package com.epam.controllers.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.epam.dtos.ProductBean;
import com.epam.model.Product;
import com.epam.service.ProductService;

@RestController
public class ProductServiceControllerImpl {
	
	ProductService productService;

	public ResponseEntity<Object> saveProduct(@RequestBody ProductBean productBean) {
		ProductDto productDto = productService.saveProduct(productBean);
		return ResponseEntity.ok().body(product);
	}
}
