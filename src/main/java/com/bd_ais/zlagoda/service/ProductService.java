package com.bd_ais.zlagoda.service;

import com.bd_ais.zlagoda.model.ProductEntity;

import java.util.List;

public interface ProductService {
    void addProduct(ProductEntity product);
    ProductEntity getProductById(Long id);
    List<ProductEntity> getAllProducts();
    void updateProduct(ProductEntity product);
    void deleteProduct(Long id);
}
