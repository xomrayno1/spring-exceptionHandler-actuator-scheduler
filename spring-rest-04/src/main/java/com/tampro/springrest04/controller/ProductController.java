package com.tampro.springrest04.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.tampro.springrest04.exception.ApiRequestException;
import com.tampro.springrest04.model.Product;
import com.tampro.springrest04.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<Product>> getAll(){
		List<Product> products = productService.getAllProducts();
		if(products.isEmpty()) {
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") long id){
		Product product = productService.getProductById(id);
		if(product == null) {
			throw new ApiRequestException("product not found with id : "+id);
		}
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Product> createProduct(@Valid @RequestBody Product productRequest
			,UriComponentsBuilder uriComponentsBuilder){	 
		if(productService.isProductExist(productRequest)) {
			return  new ResponseEntity<Product>(HttpStatus.CONFLICT);
		}
		Product product = productService.createProduct(productRequest);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder.path("/api/products/{id}").buildAndExpand(product.getId()).toUri());
		return new ResponseEntity<Product>(product,HttpStatus.CREATED);
	}
	 
	@DeleteMapping("/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable("id") long id){
		Product product = productService.getProductById(id);
		if(product == null) {
			throw new ApiRequestException("product not found with id : "+id);
		}
		productService.deleteProduct(product);
		return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
	}
}
