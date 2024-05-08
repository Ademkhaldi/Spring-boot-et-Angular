package com.example.stage6.Chart.repository;
import com.example.stage6.Chart.entity.Chart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChartRepository extends MongoRepository<Chart, String> {

}
