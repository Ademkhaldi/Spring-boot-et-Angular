package com.example.test.Linear.Repository;

import com.example.test.Linear.entity.ChartData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChartDataRepository extends MongoRepository<ChartData, String> {

     ChartData save(ChartData chartData);



}
