package com.photon.springboot.microservice.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.photon.springboot.microservice.demo.exception.ProductNotFoundException;
import com.photon.springboot.microservice.demo.model.CustomerOrder;
import com.photon.springboot.microservice.demo.model.Product;
import com.photon.springboot.microservice.demo.service.CustomerOrderService;
import com.photon.springboot.microservice.demo.service.ProductService;

/**
 * The service should expose a REST API endpoint /orders that allows creating new orders.
Each order should have properties like id, customerName, products (list of product IDs), and orderDate.
Implement a mechanism to call the Product Service /products/{id} endpoint to retrieve product details when creating an order.
 */

@RestController
@RequestMapping("/api/v1/customerorder")
public class CustomerOrderController {

	public static final Logger logger = LogManager.getLogger(CustomerOrderController.class);
	@Autowired
	private  CustomerOrderService customerOrderService;
	
	@Autowired
	private ProductService productService;
	
	
	@PostMapping("/addCustomerOrder")
	public ResponseEntity<CustomerOrder> addCustomerOrder(@RequestParam String customerName, @RequestParam String orderDate, @RequestParam String products){
		
		List<Product> productList = productService.getAllProducts();
		
		for(String product:products.split(",")) {
			for(Product prod: productList) {
				if(prod.getProductId() != Integer.parseInt(product)) {
					throw new ProductNotFoundException("Given product list is not one among the existing products, also please give product ids with comma separated");
				}
			}
		}
		
		CustomerOrder custOrder = customerOrderService.createCustomerOrder(customerName, products, convertStringToDate(orderDate));
		return ResponseEntity.ok(custOrder);
	}
	
	public Date convertStringToDate(String orderDateStr) {
		
		Date orderDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			orderDate = sdf.parse(orderDateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			logger.error("error during conversion from date str to date object");
		}
		
		return orderDate;
	}
}
