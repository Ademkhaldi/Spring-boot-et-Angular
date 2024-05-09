package com.example.test.DataKPI.Repository;

import com.example.test.DataKPI.entity.Data;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataRepository extends MongoRepository<Data, String> {
    // Vous pouvez ajouter des méthodes personnalisées si nécessaire

    Data save(Data data);

}
