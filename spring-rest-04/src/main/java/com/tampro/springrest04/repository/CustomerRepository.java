package com.tampro.springrest04.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tampro.springrest04.model.Customer;

@Repository
public interface CustomerRepository  extends CrudRepository<Customer, Long>{

	@Override
	List<Customer> findAll();
}
