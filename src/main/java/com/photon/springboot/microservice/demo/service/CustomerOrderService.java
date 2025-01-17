package com.photon.springboot.microservice.demo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.photon.springboot.microservice.demo.model.CustomerOrder;
import com.photon.springboot.microservice.demo.repository.CustomerOrderRepository;

/**
 * The service should expose a REST API endpoint /orders that allows creating new orders.
Each order should have properties like id, customerName, products (list of product IDs), and orderDate.
Implement a mechanism to call the Product Service /products/{id} endpoint to retrieve product details when creating an order.
 */
@Service
public class CustomerOrderService {

	@Autowired
	private CustomerOrderRepository customerOrderRepository;
	
	public CustomerOrder createCustomerOrder(String name, String products,Date orderDate) {
		
		CustomerOrder order = new CustomerOrder();
		order.setCustomerName(name);
		order.setOrderDate(orderDate);
		order.setProducts(products);
		order = customerOrderRepository.save(order);
		return order;
	}
	
}
