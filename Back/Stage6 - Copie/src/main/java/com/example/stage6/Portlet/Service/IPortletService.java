package com.example.stage6.Portlet.Service;

import com.example.stage6.Portlet.entity.Portlet;

import java.util.List;

public interface IPortletService {


    List<Portlet> getAllPortlets();

    Portlet retrievePortlet(String id);

    Portlet createPortlet(Portlet portlet);

    Portlet updatePortlet(String id, Portlet portlet);


    boolean deletePortlet(String id);

    boolean deleteAllPortlets();



    boolean affecterDashboardAListPortlet(String idPortlet, String idDashboard);

    boolean affecterChartAPortlet(String idPortlet, String idChart);

}
