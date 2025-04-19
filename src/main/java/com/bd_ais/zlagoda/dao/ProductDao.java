package com.bd_ais.zlagoda.dao;

import com.bd_ais.zlagoda.model.Product;

import java.util.List;

public interface ProductDao extends GenericDao<Product, Long> {
    List<Product> searchByName(String name);

    void addToBasket(Product product);
}
