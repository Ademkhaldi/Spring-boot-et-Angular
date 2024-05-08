package com.example.stage6.Chart.controller;

import com.example.stage6.Chart.Service.IChartService;
import com.example.stage6.Chart.entity.Chart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/Charts")
public class ChartController {

    @Autowired
    private IChartService chartService;

    @GetMapping("/getAllCharts")
    public List<Chart> getAllCharts() {
        return chartService.getAllCharts();
    }

    @GetMapping("/{id}")
    public Chart retrieveChart(@PathVariable("id") String id) {
        return chartService.retrieveChart(id);
    }

    @PostMapping("/Add")
    public ResponseEntity<Chart> createChart(@RequestBody Chart chart) {
        Chart createChart = chartService.createChart(chart);
        return new ResponseEntity<>(createChart, HttpStatus.CREATED);
    }

    @PutMapping("/Update/{id}")
    public ResponseEntity<Map<String, Object>> updateChart(@PathVariable String id, @RequestBody Chart chart) {
        Chart updatedChart = chartService.updateChart(id, chart);
        if (updatedChart != null) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Chart updated successfully");
            response.put("chart", updatedChart);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Chart not found with id: " + id);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<String> deleteChart(@PathVariable String id) {
        boolean deleted = chartService.deleteChart(id);
        if (deleted) {
            return new ResponseEntity<>("Chart removed successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Il n'y a aucun champ à supprimer", HttpStatus.NOT_FOUND);
        }

    }


    @DeleteMapping("/deleteAllCharts")
    public ResponseEntity<String> deleteAllCharts() {
        try {
            boolean deleted = chartService.deleteAllCharts();
            if (deleted) {
                return ResponseEntity.ok("Charts removed successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aucune suppression");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Une erreur s'est produite lors de la suppression");
        }
    }

    //Affectation
    //{idPortlet}{idDashboard}
    @PutMapping("/affecterDatasourceAChart/{idChart}/{idDatasource}")
    public ResponseEntity<Map<String, String>> affecterDatasourceAChart(
            /*{idPortlet}*/ @PathVariable("idChart") String idChart,
            /*{idDashboard}*/@PathVariable("idDatasource") String idDatasource) {

        boolean affectationReussie =chartService.affecterDatasourceAChart(idChart, idDatasource);
        // Créez une carte pour stocker les informations de la réponse
        Map<String, String> response = new HashMap<>();
        if(affectationReussie){

            // Ajoutez les détails de l'affectation à la réponse
            response.put("message", "Affectation réussie");
            response.put("ChartId", idChart);
            response.put("DatasourceId", idDatasource);

            // Répondez avec un objet ResponseEntity contenant la carte de réponse
            return ResponseEntity.ok(response);
        } else {

            // Si le client ou le marché n'est pas trouvé, ajoutez un message d'erreur à la réponse
            response.put("message", "Chart ou Datasource non trouvé");

            // Répondez avec un statut NOT_FOUND et la carte de réponse
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PutMapping("/affecterPortletAChart/{idChart}/{idPortlet}")
    public ResponseEntity<Map<String, String>> affecterPortletAChart(
            /*{idDashboard}*/@PathVariable("idChart") String idChart,
            /*{idPortlet}*/ @PathVariable("idPortlet") String idPortlet) {

        boolean affectationReussie =chartService.affecterPortletAChart(idChart,idPortlet);
        // Créez une carte pour stocker les informations de la réponse
        Map<String, String> response = new HashMap<>();
        if(affectationReussie){

            // Ajoutez les détails de l'affectation à la réponse
            response.put("message", "Affectation réussie");
            response.put("ChartId", idChart);
            response.put("portletId", idPortlet);

            // Répondez avec un objet ResponseEntity contenant la carte de réponse
            return ResponseEntity.ok(response);
        } else {

            // Si le client ou le marché n'est pas trouvé, ajoutez un message d'erreur à la réponse
            response.put("message", "idChart ou Portlet non trouvé");

            // Répondez avec un statut NOT_FOUND et la carte de réponse
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

}
