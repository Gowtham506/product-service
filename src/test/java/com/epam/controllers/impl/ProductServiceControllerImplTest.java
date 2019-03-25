package com.epam.controllers.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.timeout;

import com.epam.dtos.ProductBean;
import com.epam.model.Product;
import com.epam.service.ProductService;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceControllerImplTest {

	@InjectMocks
	private ProductServiceControllerImpl productServiceControllerImpl;

	@Mock
	private ProductService productService;

	@Before
	public void init() {
		// todo prepare data

	}
	
	@Test
	public void shouldReturnValidResponseForAddProductsRequest() {
		Product prd = populateMockProducts(1).get(0);
		ProductBean prdBean = new ProductBean();
		prdBean.setName(prd.getProductName());
		prdBean.setProductType(prd.getProductType());
		prdBean.setPrice((double) prd.getPrice());

		when(productService.addProducts(any(Product.class))).thenReturn(prd);
		productServiceControllerImpl.saveProduct(prdBean);
		verify(productService, timeout(1)).addProducts(any(Product.class));

	}
	
	
	private List<Product> populateMockProducts(int count) {
		Random rnd = new Random(140);// seed value
		List<Product> products = new ArrayList<>(count);
		for (int counter = 0; counter < count; counter++) {

			Product prd = new Product();
			prd.setProductId((long) rnd.nextInt(40000));
			prd.setProductName("Prd" + counter);
			prd.setProductType("productType" + counter);
			prd.setPrice(rnd.nextFloat());
			products.add(prd);
		}

		return products;
	}
}
