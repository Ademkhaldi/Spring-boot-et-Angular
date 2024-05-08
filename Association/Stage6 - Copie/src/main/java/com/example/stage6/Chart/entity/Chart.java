package com.example.stage6.Chart.entity;

import com.example.stage6.BusinessEntity.BusinessEntity;
import com.example.stage6.Datasource.entity.Datasource;
import com.example.stage6.Portlet.entity.Portlet;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@ToString
@Document(collection = "chart")
@TypeAlias("chart")
@AllArgsConstructor
@NoArgsConstructor
public class Chart extends BusinessEntity {

    private String title;
    private charttype type;
    private String x_axis;
    private String y_axis;


    @DBRef
    private Datasource datasource;


    @DBRef
    private Portlet portlet;


}
