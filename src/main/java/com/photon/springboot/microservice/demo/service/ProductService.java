package com.photon.springboot.microservice.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.photon.springboot.microservice.demo.exception.ProductNotFoundException;
import com.photon.springboot.microservice.demo.model.Product;
import com.photon.springboot.microservice.demo.repository.ProductReposity;

/**
 * Create a Spring Boot application for the Product Service:
The service should expose a REST API endpoint /products that returns a list of all available products.
Each product should have properties like id, name, description, price, and imageUrl.
Add a /products/{id} endpoint to retrieve a specific product by its ID. Include proper error handling and documentation for the API. 
 *
 */
@Service
public class ProductService {

	@Autowired
	private ProductReposity productRepository;
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	public Product addProduct(String productName, Long productPrice, String productImageUrl) {
		
		Product product = new Product();
		product.setProductImageUrl(productImageUrl);
		product.setProductName(productName);
		product.setProductPrice(productPrice);
		product = productRepository.save(product);
		return product;
	}
	
	public Product getProduct(Long productId) {
		
		Product product = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("Given product is not found"+productId));
		return product;
	}
}
