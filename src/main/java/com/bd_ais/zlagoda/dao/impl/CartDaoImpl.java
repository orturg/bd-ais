package com.bd_ais.zlagoda.dao.impl;

import com.bd_ais.zlagoda.dao.CartDao;
import com.bd_ais.zlagoda.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CartDaoImpl implements CartDao {

    String GET_ALL_PRODUCTS = "SELECT id, name, description, price, image_url, producer FROM products";

    private final JdbcTemplate jdbcTemplate;

    public CartDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Product> getAll() {
        return jdbcTemplate.query(GET_ALL_PRODUCTS, (rs, rowNum) -> {
            Product product = new Product();
            product.setId(rs.getLong("id"));
            product.setName(rs.getString("name"));
            product.setDescription(rs.getString("description"));
            product.setPrice(rs.getDouble("price"));
            product.setImageUrl(rs.getString("image_url"));
            product.setProducer(rs.getString("producer"));
            return product;
        });
    }

    @Override
    public Optional getById(Object id) {
        return Optional.empty();
    }

    @Override
    public void create(Object e) {

    }

    @Override
    public void update(Object e) {

    }

    @Override
    public void delete(Object id) {

    }
}
