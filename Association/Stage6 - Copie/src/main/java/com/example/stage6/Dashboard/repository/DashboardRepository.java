package com.example.stage6.Dashboard.repository;
import com.example.stage6.Dashboard.entity.Dashboard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DashboardRepository extends MongoRepository<Dashboard, String> {

}
