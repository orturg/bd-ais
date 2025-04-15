package com.bd_ais.zlagoda.dao.impl;

import com.bd_ais.zlagoda.dao.ProductDao;
import com.bd_ais.zlagoda.model.ProductEntity;
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

    private final RowMapper<ProductEntity> productRowMapper = (rs, rowNum) -> new ProductEntity(
            rs.getLong("id"),
            rs.getString("name"),
            rs.getString("description"),
            rs.getDouble("price"),
            rs.getString("image_url")
    );

    @Override
    public List<ProductEntity> getAll() {
        return jdbcTemplate.query(FIND_ALL, productRowMapper);
    }

    @Override
    public Optional<ProductEntity> getById(Long id) {
        return jdbcTemplate.query(FIND_BY_ID, productRowMapper, id).stream().findFirst();
    }

    @Override
    public void create(ProductEntity product) {
        jdbcTemplate.update(SAVE_PRODUCT,
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getImageUrl());
    }

    @Override
    public void update(ProductEntity product) {
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
    public List<ProductEntity> searchByName(String name) {
        return jdbcTemplate.query(FIND_BY_NAME, productRowMapper, name);
    }
}
