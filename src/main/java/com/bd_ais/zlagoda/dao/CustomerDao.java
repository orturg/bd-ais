package com.bd_ais.zlagoda.dao;

import com.bd_ais.zlagoda.model.CustomerEntity;

import java.util.List;
import java.util.Optional;

public interface CustomerDao{

    void save(CustomerEntity customer);
    CustomerEntity findById(Long id);
    List<CustomerEntity> findAll();
    void update(CustomerEntity customer);
    void delete(Long id);
}
