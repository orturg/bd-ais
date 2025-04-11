package com.bd_ais.zlagoda.service.impl;

import com.bd_ais.zlagoda.dao.CustomerDao;
import com.bd_ais.zlagoda.model.CustomerEntity;
import com.bd_ais.zlagoda.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDao customerDao;

    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public void addCustomer(CustomerEntity customer) {
        customerDao.save(customer);
    }

    @Override
    public CustomerEntity getCustomerById(Long id) {
        return customerDao.findById(id);
    }

    @Override
    public List<CustomerEntity> getAllCustomers() {
        return customerDao.findAll();
    }

    @Override
    public void updateCustomer(CustomerEntity customer) {
        customerDao.update(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerDao.delete(id);
    }
}
