package com.bd_ais.zlagoda.service;

import com.bd_ais.zlagoda.model.Customer;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public interface CustomerService {
    void addCustomer(Customer customer);
    Customer getCustomerById(Long id);
    Optional<Customer> getCustomerByEmail(String email);
    List<Customer> getAllCustomers();
    void updateCustomer(Customer customer);
    void deleteCustomer(Long id);
}
