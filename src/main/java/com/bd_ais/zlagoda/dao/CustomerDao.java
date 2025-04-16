package com.bd_ais.zlagoda.dao;

import com.bd_ais.zlagoda.model.Customer;

import java.util.List;

public interface CustomerDao extends GenericDao<Customer, Long> {

    List<Customer> searchByName(String name);
    List<Customer> searchBySurname(String surname);
    List<Customer> searchByEmail(String email);
}
