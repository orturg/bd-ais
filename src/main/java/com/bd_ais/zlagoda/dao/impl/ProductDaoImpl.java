package com.bd_ais.zlagoda.dao.impl;

import com.bd_ais.zlagoda.dao.ProductDao;
import com.bd_ais.zlagoda.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductDaoImpl implements ProductDao {

    private final JdbcTemplate jdbcTemplate;

    public ProductDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public Optional<Product> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public void create(Product e) {

    }

    @Override
    public void update(Product e) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Product> searchByName(String name) {
        return null;
    }

    @Override
    public void addToBasket(Product product) {

    }
}
