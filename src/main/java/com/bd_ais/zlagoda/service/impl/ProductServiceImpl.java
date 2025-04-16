package com.bd_ais.zlagoda.service.impl;

import com.bd_ais.zlagoda.dao.ProductDao;
import com.bd_ais.zlagoda.model.Product;
import com.bd_ais.zlagoda.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;

    @Autowired
    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void addProduct(Product product) {
        productDao.create(product);
    }

    @Override
    public Product getProductById(Long id) {
        return productDao.getById(id).orElse(null);
    }

    @Override
    public List<Product> getAllProducts() {
        return productDao.getAll();
    }

    @Override
    public void updateProduct(Product product) {
        productDao.update(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productDao.delete(id);
    }
}
