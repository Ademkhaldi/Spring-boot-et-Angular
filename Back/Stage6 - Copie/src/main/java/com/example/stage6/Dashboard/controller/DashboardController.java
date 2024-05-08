package com.example.stage6.Dashboard.controller;

import com.example.stage6.Chart.entity.Chart;
import com.example.stage6.Dashboard.Service.IDashboardService;
import com.example.stage6.Dashboard.entity.Dashboard;
import com.example.stage6.Portlet.entity.Portlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/dashboards")
public class DashboardController {



    @Autowired
    private IDashboardService dashboardService;

    @GetMapping("/getAllDashboards")
    public List<Dashboard> getAllDashboards() {
        return dashboardService.getAllDashboards();
    }

    @GetMapping("/{id}")
    public Dashboard retrieveDashboard(@PathVariable("id") String id) {
        return dashboardService.retrieveDashboard(id);
    }

    @PostMapping("/Add")
    public ResponseEntity<Dashboard> createDashboard(@RequestBody Dashboard dashboard) {
        Dashboard createdDashboard = dashboardService.createDashboard(dashboard);
        return new ResponseEntity<>(createdDashboard, HttpStatus.CREATED);
    }

    @PutMapping("/Update/{id}")
    public ResponseEntity<Map<String, Object>> updateDashboard(@PathVariable String id, @RequestBody Dashboard dashboard) {
        Dashboard updatedDashboard = dashboardService.updateDashboard(id, dashboard);
        if (updatedDashboard != null) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Dashboard updated successfully");
            response.put("dashboard", updatedDashboard);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Dashboard not found with id: " + id);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<String> deleteDashboard(@PathVariable String id) {
        boolean deleted = dashboardService.deleteDashboard(id);
        if (deleted) {
            return new ResponseEntity<>("Dashboard removed successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Il n'y a aucun Dashboard à supprimer", HttpStatus.NOT_FOUND);
        }

    }


    @DeleteMapping("/deleteAllDashboards")
    public ResponseEntity<String> deleteAllDashboards() {
        try {
            boolean deleted = dashboardService.deleteAllDashboards();
            if (deleted) {
                return ResponseEntity.ok("Dashboards removed successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Il n'y a aucun Dashboard à supprimer");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Une erreur s'est produite lors de la suppression");
        }
    }
    //Affectation
    // Endpoint pour assigner une liste de variables à une colonne
    @PostMapping("/{idDashboard}/assignerListePortletsAColonnes")
    public Dashboard assignerListePortletsAColonnes(@PathVariable String idDashboard, @RequestBody List<Portlet> portlets) {
        return dashboardService.assignerPortlet(idDashboard, portlets);
    }
}
