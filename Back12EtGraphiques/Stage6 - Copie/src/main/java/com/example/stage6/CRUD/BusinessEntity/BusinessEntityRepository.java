package com.example.stage6.CRUD.BusinessEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessEntityRepository extends CrudRepository<BusinessEntity, String> {
}
