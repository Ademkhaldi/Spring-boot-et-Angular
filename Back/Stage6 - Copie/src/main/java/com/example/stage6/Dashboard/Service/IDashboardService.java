package com.example.stage6.Dashboard.Service;

import com.example.stage6.Dashboard.entity.Dashboard;
import com.example.stage6.Portlet.entity.Portlet;

import java.util.List;

public interface IDashboardService {


    List<Dashboard> getAllDashboards();

    Dashboard retrieveDashboard(String id);

    Dashboard createDashboard(Dashboard dashboard);

    Dashboard updateDashboard(String id, Dashboard dashboard);


    boolean deleteDashboard(String id);

    boolean deleteAllDashboards();

    //Affectation
    Dashboard assignerPortlet(String id, List<Portlet> portlets);


    }
