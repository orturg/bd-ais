package com.bd_ais.zlagoda.dao;

import com.bd_ais.zlagoda.model.CustomerEntity;

import java.util.List;
import java.util.Optional;

public interface CustomerDao extends GenericDao<CustomerEntity, Long> {

    List<CustomerEntity> searchByName(String name);
    List<CustomerEntity> searchBySurname(String surname);
    List<CustomerEntity> searchByEmail(String email);
}
