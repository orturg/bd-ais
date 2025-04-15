package com.bd_ais.zlagoda.dao.impl;

import com.bd_ais.zlagoda.dao.CustomerDao;
import com.bd_ais.zlagoda.model.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    private final String SAVE_CUSTOMER = "INSERT INTO customers " +
                                            "SET name = ?, surname = ?, patronymic = ?, " +
                                                "phone_number = ?, city = ?, street = ?, " +
                                                "zip_code = ?, email = ?, password = ?, " +
                                                "percent = ? " +
                                            " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String UPDATE_CUSTOMER = "UPDATE customers SET " +
                                                "name = ?, surname = ?, patronymic = ?, " +
                                                "phone_number = ?, city = ?, street = ?, " +
                                                "zip_code = ?, email = ?, password = ?, " +
                                                "percent = ? " +
                                            "WHERE id = ?";
    private final String DELETE_CUSTOMER = "DELETE FROM customers WHERE id = ?";


    private final String FIND_BY_ID_SQL = "SELECT * FROM customers WHERE id = ?";
    private final String FIND_ALL_CUSTOMERS = "SELECT * FROM customers";
    private final String FIND_CUSTOMER_BY_NAME = "SELECT * FROM customers WHERE name = ?";
    private final String FIND_CUSTOMER_BY_SURNAME = "SELECT * FROM customers WHERE surname = ?";
    private final String FIND_CUSTOMER_BY_EMAIL = "SELECT * FROM customers WHERE email = ?";

    private final JdbcTemplate jdbcTemplate;

    public CustomerDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Customer> customerRowMapper = (rs, rowNum) -> new Customer(
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
    public List<Customer> searchByName(String name) {
        return jdbcTemplate.query(FIND_CUSTOMER_BY_NAME, customerRowMapper, name);
    }

    @Override
    public List<Customer> searchBySurname(String surname) {
        return jdbcTemplate.query(FIND_CUSTOMER_BY_SURNAME, customerRowMapper, surname);
    }

    @Override
    public Optional<Customer> searchByEmail(String email) {
        return jdbcTemplate.query(FIND_CUSTOMER_BY_EMAIL, customerRowMapper, email)
                .stream()
                .findFirst();
    }

    @Override
    public List<Customer> getAll() {
        return jdbcTemplate.query(FIND_ALL_CUSTOMERS, customerRowMapper);
    }

    @Override
    public Optional<Customer> getById(Long id) {
        return jdbcTemplate.query(FIND_BY_ID_SQL, customerRowMapper, id)
                .stream()
                .findFirst();
    }

    @Override
    public void create(Customer customer) {
        jdbcTemplate.update(SAVE_CUSTOMER,
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
    public void update(Customer customer) {
        jdbcTemplate.update(UPDATE_CUSTOMER,
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
        jdbcTemplate.update(DELETE_CUSTOMER, id);
    }
}
