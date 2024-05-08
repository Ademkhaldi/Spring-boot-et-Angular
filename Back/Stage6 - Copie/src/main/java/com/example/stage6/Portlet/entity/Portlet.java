package com.example.stage6.Portlet.entity;

import com.example.stage6.BusinessEntity.BusinessEntity;
import com.example.stage6.Chart.entity.Chart;
import com.example.stage6.Dashboard.entity.Dashboard;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@ToString
@Document(collection = "portlet")
@TypeAlias("portlet")
@AllArgsConstructor
@NoArgsConstructor
public class Portlet extends BusinessEntity {


    private String row;
    private String column;


    @DBRef
    private Dashboard dashboard;


    @DBRef
    private Chart chart;



}
