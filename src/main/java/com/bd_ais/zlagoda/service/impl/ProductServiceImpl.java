package com.bd_ais.zlagoda.service.impl;

import com.bd_ais.zlagoda.dao.ProductDao;
import com.bd_ais.zlagoda.dao.impl.EmloyeeDaoImpl;
import com.bd_ais.zlagoda.dao.impl.ProductDaoImpl;
import com.bd_ais.zlagoda.model.Product;
import com.bd_ais.zlagoda.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDaoImpl productDaoImpl;

    @Autowired
    public ProductServiceImpl(ProductDaoImpl productDaoImpl) { this.productDaoImpl = productDaoImpl; }

    @Override
    public void addProduct(Product product) {

    }

    @Override
    public void addProductToBasket(Product product) { productDaoImpl.addToBasket(product); }

    @Override
    public Product getProductById(Long id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public void deleteProduct(Long id) {

    }
}
