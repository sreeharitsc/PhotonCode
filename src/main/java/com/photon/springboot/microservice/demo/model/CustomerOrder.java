package com.photon.springboot.microservice.demo.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customerorder")
public class CustomerOrder {

	//Each order should have properties like id, customerName, products (list of product IDs), and orderDate
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	private String customerName;
	private Date orderDate;
	
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "productId")
	 */
	private String products;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getProducts() {
		return products;
	}

	public void setProducts(String products) {
		this.products = products;
	}

	/*
	 * public Set<Product> getProducts() { return products; }
	 * 
	 * public void setProducts(Set<Product> products) { this.products = products; }
	 */
	
	
}
