package com.photon.springboot.microservice.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.photon.springboot.microservice.demo.model.Product;
import com.photon.springboot.microservice.demo.service.ProductService;

/**
 * Create a Spring Boot application for the Product Service:
The service should expose a REST API endpoint /products that returns a list of all available products.
Each product should have properties like id, name, description, price, and imageUrl.
Add a /products/{id} endpoint to retrieve a specific product by its ID. Include proper error handling and documentation for the API. 
 *
 */

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

	@Autowired
	private  ProductService productService;
	
	@GetMapping("/getAllProducts")
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> products = productService.getAllProducts();
		return ResponseEntity.ok(products);
	}

	@GetMapping("/getProductById")
	public ResponseEntity<Product> getProductById(@RequestParam Long productId){
		Product product = productService.getProduct(productId);
		return ResponseEntity.ok(product);
	}
	
	@PostMapping("/addProduct")
	public ResponseEntity<Product> addProduct(@RequestParam String productName, @RequestParam Long productPrice, @RequestParam String productImageUrl){
		
		Product product = productService.addProduct(productName, productPrice, productImageUrl);
		return ResponseEntity.ok(product);
	}
}
