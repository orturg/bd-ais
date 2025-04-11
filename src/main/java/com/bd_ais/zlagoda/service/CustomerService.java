package com.bd_ais.zlagoda.service;

import com.bd_ais.zlagoda.model.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {
    void addCustomer(CustomerEntity customer);
    CustomerEntity getCustomerById(Long id);
    List<CustomerEntity> getAllCustomers();
    void updateCustomer(CustomerEntity customer);
    void deleteCustomer(Long id);
}
