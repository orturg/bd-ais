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

    private final String SAVE_PRODUCT = "INSERT INTO products " +
            "(name, description, price, image_url) VALUES (?, ?, ?, ?)";

    private final String UPDATE_PRODUCT = "UPDATE products SET " +
            "name = ?, description = ?, price = ?, image_url = ? " +
            "WHERE id = ?";

    private final String DELETE_PRODUCT = "DELETE FROM products WHERE id = ?";

    private final String FIND_ALL = "SELECT * FROM products";
    private final String FIND_BY_ID = "SELECT * FROM products WHERE id = ?";
    private final String FIND_BY_NAME = "SELECT * FROM products WHERE name = ?";

    public ProductDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Product> productRowMapper = (rs, rowNum) -> new Product(
            rs.getLong("id"),
            rs.getString("name"),
            rs.getString("description"),
            rs.getDouble("price"),
            rs.getString("image_url")
    );

    @Override
    public List<Product> getAll() {
        return jdbcTemplate.query(FIND_ALL, productRowMapper);
    }

    @Override
    public Optional<Product> getById(Long id) {
        return jdbcTemplate.query(FIND_BY_ID, productRowMapper, id).stream().findFirst();
    }

    @Override
    public void create(Product product) {
        jdbcTemplate.update(SAVE_PRODUCT,
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getImageUrl());
    }

    @Override
    public void update(Product product) {
        jdbcTemplate.update(UPDATE_PRODUCT,
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getImageUrl(),
                product.getId());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update(DELETE_PRODUCT, id);
    }

    @Override
    public List<Product> searchByName(String name) {
        return jdbcTemplate.query(FIND_BY_NAME, productRowMapper, name);
    }
}
