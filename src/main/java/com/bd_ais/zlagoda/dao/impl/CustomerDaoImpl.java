package com.bd_ais.zlagoda.dao.impl;

import com.bd_ais.zlagoda.dao.CustomerDao;
import com.bd_ais.zlagoda.model.CustomerEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    private final JdbcTemplate jdbcTemplate;

    public CustomerDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<CustomerEntity> customerRowMapper = (rs, rowNum) -> new CustomerEntity(
            rs.getLong("id"),
            rs.getString("name"),
            rs.getString("surname"),
            rs.getString("patronymic"),
            rs.getString("phone_number"),
            rs.getString("city"),
            rs.getString("street"),
            rs.getString("zip_code"),
            rs.getString("email"),
            rs.getString("password"),
            rs.getInt("percent")
    );

    @Override
    public void save(CustomerEntity customer) {
        String sql = "INSERT INTO customers (name, email) VALUES (?, ?)";
        jdbcTemplate.update(sql, customer.getName(), customer.getEmail());
    }

    @Override
    public CustomerEntity findById(Long id) {
        String sql = "SELECT * FROM customers WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, customerRowMapper, id);
    }

    @Override
    public List<CustomerEntity> findAll() {
        String sql = "SELECT * FROM customers";
        return jdbcTemplate.query(sql, customerRowMapper);
    }

    @Override
    public void update(CustomerEntity customer) {
        String sql = "UPDATE customers SET name = ?, surname = ?, patronymic = ?, " +
                "phone_number = ?, city = ?, street = ?, zip_code = ?, email = ?, " +
                "password = ?, percent = ? WHERE id = ?";
        jdbcTemplate.update(sql,
                customer.getName(),
                customer.getSurname(),
                customer.getPatronymic(),
                customer.getPhone_number(),
                customer.getCity(),
                customer.getStreet(),
                customer.getZip_code(),
                customer.getEmail(),
                customer.getPassword(),
                customer.getPercent(),
                customer.getId()
        );
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM customers WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
