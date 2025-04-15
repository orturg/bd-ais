package com.bd_ais.zlagoda.dao;

import com.bd_ais.zlagoda.model.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface ProductDao extends GenericDao<ProductEntity, Long> {
    List<ProductEntity> searchByName(String name);
}
