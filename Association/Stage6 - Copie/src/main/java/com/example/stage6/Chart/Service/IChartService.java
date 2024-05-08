package com.example.stage6.Chart.Service;

import com.example.stage6.Chart.entity.Chart;

import java.util.List;

public interface IChartService {


    List<Chart> getAllCharts();

    Chart retrieveChart(String id);

    Chart createChart(Chart chart);

    Chart updateChart(String id, Chart chart);

    boolean deleteChart(String id);

    boolean deleteAllCharts();


    boolean affecterDatasourceAChart(String idChart, String idDatasource);

    boolean affecterPortletAChart(String idChart,String idPortlet);

     void associateChartWithDatasource(String chartId, String datasourceId);

        void disassociateChartFromDatasource(String chartId) ;


    }