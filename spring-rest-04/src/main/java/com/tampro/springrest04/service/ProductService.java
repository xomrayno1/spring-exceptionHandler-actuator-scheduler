package com.tampro.springrest04.service;

import java.util.List;

import com.tampro.springrest04.model.Product;

public interface ProductService {
		
	public List<Product> getAllProducts();
	
	public Product getProductById(long id);
	
	public Product createProduct(Product product);
	
	public Product updateProduct(Product product);
	
	public void deleteProduct(Product product);
	
	public boolean isProductExist(Product product);
}
