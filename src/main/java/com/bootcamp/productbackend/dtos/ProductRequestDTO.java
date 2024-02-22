package com.bootcamp.productbackend.dtos;

import com.bootcamp.productbackend.models.Category;
import com.bootcamp.productbackend.models.Product;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProductRequestDTO {
    
    @NotBlank(message = "Name can not be blank")
    @Size(min = 3, max = 255, message = "Name length min=3 and max=255")
    private String name;
    
    @NotBlank(message = "Description can not be blank")
    @Size(min = 3, max = 1024, message = "Description length min=3 and max=1024")
    private String description;

    @Min(value = 0, message = "Price min value = 0")
    private double price;
    
    private boolean promotion;
    private boolean newProduct;

    @NotNull
    @Valid
    private IntegerDTO category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isPromotion() {
        return promotion;
    }

    public void setPromotion(boolean promotion) {
        this.promotion = promotion;
    }

    public boolean isNewProduct() {
        return newProduct;
    }

    public void setNewProduct(boolean newProduct) {
        this.newProduct = newProduct;
    }

    public IntegerDTO getCategory() {
        return category;
    }

    public void setCategory(IntegerDTO category) {
        this.category = category;
    }

    public Product toEntity() {
        return new Product(name, description, price, promotion, newProduct, new Category(category.getId()));
    }
}
