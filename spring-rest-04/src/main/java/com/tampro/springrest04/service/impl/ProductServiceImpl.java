package com.tampro.springrest04.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tampro.springrest04.model.Product;
import com.tampro.springrest04.repository.ProductRepository;
import com.tampro.springrest04.service.ProductService;

@Service
public class ProductServiceImpl  implements ProductService{
	@Autowired
	ProductRepository proRepo;

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return proRepo.findAll();
	}

	@Override
	public Product getProductById(long id) {
		// TODO Auto-generated method stub
		return proRepo.findById(id).orElse(null);
	}

	@Override
	public Product createProduct(Product product) {
		// TODO Auto-generated method stub
		return proRepo.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		return proRepo.save(product);
	}

	@Override
	public void deleteProduct(Product product) {
		// TODO Auto-generated method stub
		proRepo.delete(product);
	}

	@Override
	public boolean isProductExist(Product product) {
		// TODO Auto-generated method stub
		if(proRepo.findByName(product.getName()) != null) {
			return true;
		}
		return false;
	}
	
}
