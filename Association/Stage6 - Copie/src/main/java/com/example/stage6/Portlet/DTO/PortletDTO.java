package com.example.stage6.Portlet.DTO;


import com.example.stage6.BusinessEntity.BusinessEntity;
import com.example.stage6.Chart.DTO.ChartDTO;
import com.example.stage6.Chart.entity.Chart;
import com.example.stage6.Chart.entity.charttype;
import com.example.stage6.Dashboard.DTO.DashboardDTO;
import com.example.stage6.Dashboard.entity.Dashboard;
import com.example.stage6.Datasource.DTO.DatasourceDTO;
import com.example.stage6.Portlet.entity.Portlet;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PortletDTO extends BusinessEntity{

    private String row;
    private String column;


    private DashboardDTO dashboard;

    private ChartDTO chart;


}
