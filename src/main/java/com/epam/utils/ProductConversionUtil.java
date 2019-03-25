
package com.epam.utils;

import org.springframework.stereotype.Component;

import com.epam.dtos.ProductDTO;
import com.epam.model.Product;

@Component
public class ProductConversionUtil {
	
	public ProductDTO convertToDTO(Product product) {
		ProductDTO dto = new ProductDTO();
		dto.setProductRequestId(product.getProductId());
		dto.setPrice(product.getPrice());
		dto.setProductName(product.getProductName());
		dto.setProductType(product.getProductType());
		return dto;
	}

}
