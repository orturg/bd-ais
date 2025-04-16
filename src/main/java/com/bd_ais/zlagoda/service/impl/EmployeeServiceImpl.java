package com.bd_ais.zlagoda.service.impl;

import com.bd_ais.zlagoda.dao.impl.EmloyeeDaoImpl;
import com.bd_ais.zlagoda.model.Employee;
import com.bd_ais.zlagoda.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmloyeeDaoImpl employeeDaoImpl;

    @Autowired
    public EmployeeServiceImpl(EmloyeeDaoImpl employeeDaoImpl) {
        this.employeeDaoImpl = employeeDaoImpl;
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeDaoImpl.create(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeDaoImpl.getById(id).orElse(null);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDaoImpl.getAll();
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeDaoImpl.update(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeDaoImpl.delete(id);
    }
}
