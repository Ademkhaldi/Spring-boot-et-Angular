package com.example.stage6.Datasource.repository;
import com.example.stage6.Datasource.entity.Datasource;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatasourceRepository extends MongoRepository<Datasource, String> {

}
