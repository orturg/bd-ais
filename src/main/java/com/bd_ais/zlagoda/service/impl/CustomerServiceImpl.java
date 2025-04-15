package com.bd_ais.zlagoda.service.impl;

import com.bd_ais.zlagoda.dao.CustomerDao;
import com.bd_ais.zlagoda.model.CustomerEntity;
import com.bd_ais.zlagoda.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDao customerDaoImpl;

    @Autowired
    public CustomerServiceImpl(CustomerDao customerDaoImpl) {
        this.customerDaoImpl = customerDaoImpl;
    }

    @Override
    public void addCustomer(CustomerEntity customer) {
        customerDaoImpl.create(customer);
    }

    @Override
    public CustomerEntity getCustomerById(Long id) {
        return customerDaoImpl.getById(id).orElse(null);
    }

    @Override
    public List<CustomerEntity> getAllCustomers() {
        return customerDaoImpl.getAll();
    }

    @Override
    public void updateCustomer(CustomerEntity customer) {
        customerDaoImpl.update(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerDaoImpl.delete(id);
    }
}
