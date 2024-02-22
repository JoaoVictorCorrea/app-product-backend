package com.bootcamp.productbackend.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.bootcamp.productbackend.dtos.ProductRequestDTO;
import com.bootcamp.productbackend.dtos.ProductResponseDTO;
import com.bootcamp.productbackend.models.Category;
import com.bootcamp.productbackend.models.Product;
import com.bootcamp.productbackend.repositories.ProductRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    
    public ProductResponseDTO getById(long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));

        return product.toDTO();
    }
    
    public List<ProductResponseDTO> getAll() {

        return productRepository.findAll()
                                .stream()
                                .map(p -> p.toDTO())
                                .collect(Collectors.toList());
    }
    
    public ProductResponseDTO save(ProductRequestDTO productRequest) {

        try{
            Product product = productRepository.save(productRequest.toEntity());
            return product.toDTO();
        }
        catch(DataIntegrityViolationException e){
            throw new EntityNotFoundException("Category not found");
        } 
    }
    
    public void deleteById(long id) {

        getById(id);
        productRepository.deleteById(id);
    }
    
    public void update(long id, ProductRequestDTO productUpdate) {

        try{
            Product product = productRepository.getReferenceById(id);
            Category category = new Category(productUpdate.getCategory().getId());
        
            product.setDescription(productUpdate.getDescription());
            product.setName(productUpdate.getName());
            product.setPrice(productUpdate.getPrice());
            product.setNewProduct(productUpdate.isNewProduct());
            product.setPromotion(productUpdate.isPromotion());
            product.setCategory(category);

            productRepository.save(product);
        }
        catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Product not found");
        }
        catch(DataIntegrityViolationException e){
            throw new EntityNotFoundException("Category not found");
        } 
    }
}
