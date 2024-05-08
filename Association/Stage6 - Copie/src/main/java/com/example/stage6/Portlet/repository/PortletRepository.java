package com.example.stage6.Portlet.repository;
import com.example.stage6.Portlet.entity.Portlet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortletRepository extends MongoRepository<Portlet, String> {

}
