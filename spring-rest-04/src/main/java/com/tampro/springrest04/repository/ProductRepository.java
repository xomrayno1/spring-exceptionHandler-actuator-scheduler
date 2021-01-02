package com.tampro.springrest04.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tampro.springrest04.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

	@Override
	List<Product> findAll();
	
	Product  findByName(String name);
}
