package com.bootcamp.productbackend.dtos;

public class ProductResponseDTO {
    
    private long id;
    private String name;
    private String description;
    private double price;
    private boolean promotion;
    private boolean newProduct;
    private CategoryResponseDTO category;

    public ProductResponseDTO() {}

    public ProductResponseDTO(long id, String name, String description, double price, boolean promotion,
            boolean newProduct, CategoryResponseDTO category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.promotion = promotion;
        this.newProduct = newProduct;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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

    public CategoryResponseDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryResponseDTO category) {
        this.category = category;
    }
}
