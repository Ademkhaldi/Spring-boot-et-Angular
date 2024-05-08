package com.example.stage6.Datasource.entity;

import com.example.stage6.BusinessEntity.BusinessEntity;
import com.example.stage6.Chart.entity.Chart;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@ToString
@Document(collection = "datasource")
@TypeAlias("datasource")
@AllArgsConstructor
@NoArgsConstructor
public class Datasource extends BusinessEntity {


    private String type;

    private Integer connection_port;


    @DBRef
    private Chart chart;


}
