package com.photon.springboot.microservice.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.photon.springboot.microservice.demo.model.Product;

@Repository
public interface ProductReposity extends JpaRepository<Product, Long>{

}
