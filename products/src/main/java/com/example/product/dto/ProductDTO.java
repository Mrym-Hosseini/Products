package com.example.product.dto;

public class ProductDTO {

    private String Id;
    private String name;
    private String type;
    private String category;
    private String description;
    private double price;

    public ProductDTO() {

    }

    public ProductDTO(String name, String type, String category, String description, double price) {
        setName(name);
        setType(type);
        setCategory(category);
        setDescription(description);
        setPrice(price);
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
}
