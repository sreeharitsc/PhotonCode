package com.photon.springboot.microservice.demo.exception;

public class ProductListFormatException extends RuntimeException {

	public ProductListFormatException(String message){
		super(message);
	}
}
