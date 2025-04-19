package com.bd_ais.zlagoda.service.impl;



import com.bd_ais.zlagoda.dao.impl.CartDaoImpl;
import com.bd_ais.zlagoda.dao.impl.EmloyeeDaoImpl;
import com.bd_ais.zlagoda.model.Product;
import com.bd_ais.zlagoda.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    private final CartDaoImpl cartDaoImpl;

    @Autowired
    public CartServiceImpl(CartDaoImpl cartDaoImpl) {
        this.cartDaoImpl = cartDaoImpl;
    }

    @Override
    public List<Product> getAllProducts() { return cartDaoImpl.getAll(); }
}
