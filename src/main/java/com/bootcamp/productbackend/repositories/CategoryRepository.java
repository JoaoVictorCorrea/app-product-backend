package com.bootcamp.productbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.productbackend.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
   
}
