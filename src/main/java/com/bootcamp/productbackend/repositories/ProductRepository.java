package com.bootcamp.productbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.productbackend.models.Product;
 
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
