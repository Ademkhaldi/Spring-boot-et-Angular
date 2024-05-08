package com.example.stage6.Datasource.DTO;

import com.example.stage6.BusinessEntity.BusinessEntity;
import com.example.stage6.Chart.DTO.ChartDTO;
import com.example.stage6.Datasource.entity.Datasource;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DatasourceDTO extends BusinessEntity {
    private String type;
    private Integer connection_port;
    private ChartDTO chart;

}
