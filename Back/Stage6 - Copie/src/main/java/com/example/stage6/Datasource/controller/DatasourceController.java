package com.example.stage6.Datasource.controller;

import com.example.stage6.Datasource.Service.IDatasourceService;
import com.example.stage6.Datasource.entity.Datasource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/datasources")
public class DatasourceController {

    @Autowired
    private IDatasourceService datasourceService;

    @GetMapping("/getAllDatasources")
    public List<Datasource> getAllDatasources() {
        return datasourceService.getAllDatasources();
    }

    @GetMapping("/{id}")
    public Datasource retrieveDatasource(@PathVariable("id") String id) {
        return datasourceService.retrieveDatasource(id);
    }

    @PostMapping("/Add")
    public ResponseEntity<Datasource> createDatasource(@RequestBody Datasource datasource) {
        Datasource createdDatasource = datasourceService.createDatasource(datasource);
        return new ResponseEntity<>(createdDatasource, HttpStatus.CREATED);
    }

    @PutMapping("/Update/{id}")
    public ResponseEntity<Map<String, Object>> updateDashboard(@PathVariable String id, @RequestBody Datasource datasource) {
        Datasource updatedDatasource = datasourceService.updateDatasource(id, datasource);
        if (updatedDatasource != null) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Datasource updated successfully");
            response.put("dashboard", updatedDatasource);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Datasource not found with id: " + id);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<String> deleteDatasource(@PathVariable String id) {
        boolean deleted = datasourceService.deleteDatasource(id);
        if (deleted) {
            return new ResponseEntity<>("Datasource removed successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Il n'y a aucun Datasource à supprimer", HttpStatus.NOT_FOUND);
        }

    }


    @DeleteMapping("/deleteAllDatasources")
    public ResponseEntity<String> deleteAllDatasources() {
        try {
            boolean deleted = datasourceService.deleteAllDatasources();
            if (deleted) {
                return ResponseEntity.ok("Datasource removed successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Il n'y a aucun Datasource à supprimer");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Une erreur s'est produite lors de la suppression");
        }
    }




    //Affectation
    //{idPortlet}{idDashboard}
    @PutMapping("/affecterChartADatasource/{idDatasource}/{idChart}")
    public ResponseEntity<Map<String, String>> affecterChartADatasource(
            /*{idPortlet}*/ @PathVariable("idDatasource") String idDatasource,
            /*{idDashboard}*/@PathVariable("idChart") String idChart) {

        boolean affectationReussie =datasourceService.affecterChartADatasource(idDatasource, idChart);
        // Créez une carte pour stocker les informations de la réponse
        Map<String, String> response = new HashMap<>();
        if(affectationReussie){

            // Ajoutez les détails de l'affectation à la réponse
            response.put("message", "Affectation réussie");
            response.put("datasourceId", idDatasource);
            response.put("chartId", idChart);

            // Répondez avec un objet ResponseEntity contenant la carte de réponse
            return ResponseEntity.ok(response);
        } else {

            // Si le client ou le marché n'est pas trouvé, ajoutez un message d'erreur à la réponse
            response.put("message", "Chart ou Datasource non trouvé");

            // Répondez avec un statut NOT_FOUND et la carte de réponse
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
