package com.epam.controllers.impl;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.dtos.ProductBean;
import com.epam.dtos.ProductDTO;
import com.epam.exception.ProductException;
import com.epam.model.Product;
import com.epam.service.ProductService;

@RestController
@RequestMapping("product-service/")
public class ProductServiceControllerImpl {
	
	@Autowired
	ProductService productService;

	@PostMapping("/save")
	public ResponseEntity<Object> saveProduct(@RequestBody ProductBean productBean) {
		Product product = new Product();
		product.setProductName(productBean.getProductName());
		product.setProductType(productBean.getProductType());
		try {
			return ResponseEntity.ok().body( productService.saveProduct(product));
		} catch (ProductException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping("getProducts")
	public List<Product> getAllProducts() {
		return productService.getProducts();
	}

	@GetMapping("getProduct/{productId}")
	public ResponseEntity<Object> getProductById(@PathVariable("productId") @Min(2) Long productId) {
		Product p = null;
		try {
			p = productService.getProductById(productId);
		} catch (ProductException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok().body(p);
	}
	

	@DeleteMapping("deleteProduct/{productId}")
	public void deleteProductById(@PathVariable("productId") @Min(2) Long productId) {
		productService.deleteProductById(productId);
	}

}
