package com.bootcamp.productbackend.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.bootcamp.productbackend.dtos.ProductRequestDTO;
import com.bootcamp.productbackend.dtos.ProductResponseDTO;
import com.bootcamp.productbackend.models.Category;
import com.bootcamp.productbackend.models.Product;
import com.bootcamp.productbackend.repositories.CategoryRepository;
import com.bootcamp.productbackend.repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    
    public Product getById(long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));

        return product;
    }

    public ProductResponseDTO getDTOById(long id) {

        Product product = getById(id);
        return product.toDTO();
    }
    
    public List<ProductResponseDTO> getAll() {

        return productRepository.findAll()
                                .stream()
                                .map(p -> p.toDTO())
                                .collect(Collectors.toList());
    }
    
    public ProductResponseDTO save(ProductRequestDTO productRequest) {

        Product product = productRepository.save(productRequest.toEntity());
        return product.toDTO();
    }
    
    public void deleteById(long id) {

        Product product = getById(id);

        productRepository.delete(product);
    }
    
    public void update(long id, ProductRequestDTO productUpdate) {
        
        Product product = getById(id);
        
        Category category = categoryRepository.findById(productUpdate.getCategory().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
        
        product.setDescription(productUpdate.getDescription());
        product.setName(productUpdate.getName());
        product.setPrice(productUpdate.getPrice());
        product.setNewProduct(productUpdate.isNewProduct());
        product.setPromotion(productUpdate.isPromotion());
        product.setCategory(category);

        productRepository.save(product);
    }
}
