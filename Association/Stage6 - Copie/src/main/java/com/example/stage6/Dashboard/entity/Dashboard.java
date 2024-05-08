package com.example.stage6.Dashboard.entity;

import com.example.stage6.BusinessEntity.BusinessEntity;
import com.example.stage6.Portlet.entity.Portlet;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "dashboard")
@TypeAlias("dashboard")
public class Dashboard extends BusinessEntity {

    private String title;
    @DBRef
    private List<Portlet> portlets;

}

