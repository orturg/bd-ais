package com.bd_ais.zlagoda.service;

import com.bd_ais.zlagoda.model.Product;

import java.util.List;

public interface ProductService {
    void addProduct(Product product);
    Product getProductById(Long id);
    List<Product> getAllProducts();
    void updateProduct(Product product);
    void deleteProduct(Long id);
}
