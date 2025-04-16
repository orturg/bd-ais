package com.bd_ais.zlagoda.service.impl;

import com.bd_ais.zlagoda.dao.impl.CustomerDaoImpl;
import com.bd_ais.zlagoda.model.Customer;
import com.bd_ais.zlagoda.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDaoImpl customerDaoImpl;

    @Autowired
    public CustomerServiceImpl(CustomerDaoImpl customerDaoImpl) {
        this.customerDaoImpl = customerDaoImpl;
    }

    @Override
    public void addCustomer(Customer customer) {
        customerDaoImpl.create(customer);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerDaoImpl.getById(id).orElse(null);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerDaoImpl.getAll();
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerDaoImpl.update(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerDaoImpl.delete(id);
    }
}
