package com.epam.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.dtos.ProductDTO;
import com.epam.exception.ProductException;
import com.epam.model.Product;
import com.epam.repository.ProductRepository;
import com.epam.service.ProductService;
import com.epam.utils.ProductConversionUtil;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	ProductConversionUtil productConversionUtil;

	@Override
	public ProductDTO saveProduct(Product p) {
		Product product = productRepository.save(p);
		return productConversionUtil.convertToDTO(product);
	}
	
	@Override
	public List<Product> getProducts() {
		List<Product> responselist = new ArrayList<>();
		productRepository.findAll().forEach(product -> responselist.add(product));
		return responselist;
	}
	
	@Override
	public Product getProductById(Long productId) throws ProductException {
		Optional<Product> product = productRepository.findById(productId);
		if (!product.isPresent()) {
			throw new ProductException("Not found productId");
		}
		return product.get();
	}

}
