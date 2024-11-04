package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Product")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String ProductName, SizeProduct;
    private Float PriceProduct;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getPriceProduct() {
        return PriceProduct;
    }

    public void setPriceProduct(Float priceProduct) {
        PriceProduct = priceProduct;
    }

    public String getSizeProduct() {
        return SizeProduct;
    }

    public void setSizeProduct(String sizeProduct) {
        SizeProduct = sizeProduct;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public Post(String productName, String sizeProduct, Float priceProduct) {
        ProductName = productName;
        SizeProduct = sizeProduct;
        PriceProduct = priceProduct;
    }

    public Post() {
    }
}
