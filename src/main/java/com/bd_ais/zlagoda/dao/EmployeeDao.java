package com.bd_ais.zlagoda.dao;

import com.bd_ais.zlagoda.model.Customer;
import com.bd_ais.zlagoda.model.Employee;
import com.bd_ais.zlagoda.model.Role;

import java.util.List;

public interface EmployeeDao extends GenericDao<Employee, Long> {
    List<Employee> searchByName(String name);
    List<Employee> searchBySurname(String surname);
    List<Employee> searchByEmail(String email);
    List<Employee> searchByRole(Role role);
    List<Employee> filterBySurname();
    List<Employee> cashierFilterBySurname();
    List<Employee> findBySurnamePhoneAndAddress(String surname);

}
