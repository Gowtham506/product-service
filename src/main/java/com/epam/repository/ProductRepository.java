package com.epam.repository;

import org.springframework.data.repository.CrudRepository;

import com.epam.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
