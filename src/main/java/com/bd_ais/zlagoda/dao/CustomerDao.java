package com.bd_ais.zlagoda.dao;

import com.bd_ais.zlagoda.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDao extends GenericDao<Customer, Long> {

    List<Customer> searchByName(String name);
    List<Customer> searchBySurname(String surname);
    Optional<Customer> searchByEmail(String email);
    }
