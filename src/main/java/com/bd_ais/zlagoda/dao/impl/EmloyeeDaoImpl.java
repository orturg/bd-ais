package com.bd_ais.zlagoda.dao.impl;

import com.bd_ais.zlagoda.dao.EmployeeDao;
import com.bd_ais.zlagoda.model.Customer;
import com.bd_ais.zlagoda.model.Employee;
import com.bd_ais.zlagoda.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmloyeeDaoImpl implements EmployeeDao {
    private final String FIND_ALL = "SELECT * FROM employees";
    private final String FIND_BY_ID = "SELECT * FROM employees WHERE id_employee = ?";
    private final String FIND_BY_NAME = "SELECT * FROM employees WHERE emlp_name = ?";
    private final String FIND_BY_SURNAME = "SELECT * FROM employees WHERE emlp_surname = ?";
    private final String FIND_BY_EMAIL = "SELECT * FROM employees WHERE email = ?";
    private final String FIND_BY_ROLE = "SELECT * FROM employees WHERE emlp_role = ?";
    private final String SAVE_EMPLOYEE = "INSERT INTO employees (\n" +
            "  emlp_name, emlp_surname, emlp_patronymic, emlp_role,\n" +
            "  salary, date_of_birth, date_of_start, phone_number,\n" +
            "  city, street, zip_code, email, password\n" +
            ")\n" +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String UPDATE_EMPLOYEE =   "UPDATE employees " +
            "SET emlp_name = ?, emlp_surname = ?, emlp_patronymic = ?, " +
            "emlp_role = ?, salary = ?, date_of_birth = ?, " +
            "date_of_start = ?, phone_number = ?, city = ?, " +
            "street = ?,  zip_code = ?, email = ?, password = ?" +
            "WHERE id = ?";
    private final String DELETE_EMPLOYEE =  "DELETE FROM employees " +
                                            "WHERE id_employee = ?";
    private final String FILTER_BY_SURNAME = "SELECT * FROM employees ORDER BY emlp_surname";
    private final String CASHIER_FILTER_BY_SURNAME =    "SELECT * FROM employees \n" +
                                                        "WHERE emlp_role = 'CASHIER' \n" +
                                                        "ORDER BY emlp_surname";

    private final String FIND_BY_SURNAME_PHONE_AND_ADDRESS =
            "SELECT id_employee, empl_name, empl_surname, phone_number, city, street, zip_code " +
            "FROM employees WHERE emlp_surname = ?";

    private final RowMapper<Employee> employeeRowMapper = (rs, rowNum) -> new Employee(
            rs.getLong("id_employee"),
            rs.getString("emlp_name"),
            rs.getString("emlp_surname"),
            rs.getString("emlp_patronymic"),
            rs.getString("phone_number"),
            rs.getString("city"),
            rs.getString("street"),
            rs.getString("zip_code"),
            rs.getString("email"),
            rs.getString("password"),
            Role.valueOf(rs.getString("emlp_role")),
            rs.getBigDecimal("salary"),
            rs.getDate("date_of_birth"),
            rs.getDate("date_of_start")
    );

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmloyeeDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Employee> searchByName(String name) {
        return jdbcTemplate.query(FIND_BY_NAME, employeeRowMapper, name);
    }

    @Override
    public List<Employee> searchBySurname(String surname) {
        return jdbcTemplate.query(FIND_BY_SURNAME, employeeRowMapper, surname);
    }

    @Override
    public List<Employee> searchByEmail(String email) {
        return jdbcTemplate.query(FIND_BY_EMAIL, employeeRowMapper, email);
    }

    @Override
    public List<Employee> searchByRole(Role role) {
        return jdbcTemplate.query(FIND_BY_ROLE, employeeRowMapper, role.toString());
    }

    @Override
    public List<Employee> filterBySurname() {
        return jdbcTemplate.query(FILTER_BY_SURNAME, employeeRowMapper);
    }

    @Override
    public List<Employee> cashierFilterBySurname() {
        return jdbcTemplate.query(CASHIER_FILTER_BY_SURNAME, employeeRowMapper);
    }

    @Override
    public List<Employee> findBySurnamePhoneAndAddress(String surname) {
        return jdbcTemplate.query(FIND_BY_SURNAME_PHONE_AND_ADDRESS, employeeRowMapper, surname);
    }

    @Override
    public List<Employee> getAll() {
        return jdbcTemplate.query(FIND_ALL, employeeRowMapper);
    }

    @Override
    public Optional<Employee> getById(Long id) {
        return jdbcTemplate.query(FIND_BY_ID, employeeRowMapper, id)
                .stream()
                .findFirst();
    }

    @Override
    public void create(Employee e) {
        jdbcTemplate.update(SAVE_EMPLOYEE,
                e.getName(),
                e.getSurname(),
                e.getPatronymic(),
                e.getEmpl_role().toString(),
                e.getSalary(),
                e.getDate_of_birth(),
                e.getDate_of_start(),
                e.getPhone_number(),
                e.getCity(),
                e.getStreet(),
                e.getZip_code(),
                e.getEmail(),
                e.getPassword()
        );
    }

    @Override
    public void update(Employee e) {
        jdbcTemplate.update(UPDATE_EMPLOYEE,
                e.getName(),
                e.getSurname(),
                e.getPatronymic(),
                e.getPhone_number(),
                e.getCity(),
                e.getStreet(),
                e.getZip_code(),
                e.getEmail(),
                e.getPassword(),
                e.getEmpl_role().toString(),
                e.getId()
        );
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update(DELETE_EMPLOYEE, id);
    }
}
