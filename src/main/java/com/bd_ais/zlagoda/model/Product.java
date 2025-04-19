package com.bd_ais.zlagoda.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Product {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imageUrl;
    private String producer;

    public Product() {}

    public Product(Long id, String name, String description, Double price, String imageUrl, String producer) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
        this.producer = producer;
    }

    public void setId(Long id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public void setDescription(String description) { this.description = description; }

    public void setPrice(Double price) { this.price = price; }

    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public void setProducer(String producer) { this.producer = producer; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) &&
                Objects.equals(description, product.description) &&
                Objects.equals(price, product.price) &&
                Objects.equals(imageUrl, product.imageUrl) &&
                Objects.equals(producer, product.producer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, price, imageUrl);
    }
}
