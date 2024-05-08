package com.example.stage6.Portlet.controller;

import com.example.stage6.Dashboard.repository.DashboardRepository;
import com.example.stage6.Portlet.Service.IPortletService;
import com.example.stage6.Portlet.entity.Portlet;
import com.example.stage6.Portlet.repository.PortletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/portlets")
public class PortletController {

    @Autowired
    private IPortletService portletService;

    @Autowired
    private PortletRepository portletRepository;

    @Autowired
    private DashboardRepository dashboardRepository;

    @GetMapping("/getAllPortlets")
    public List<Portlet> getAllPortlets() {
        return portletService.getAllPortlets();
    }

    @GetMapping("/{id}")
    public Portlet retrievePortlet(@PathVariable("id") String id) {
        return portletService.retrievePortlet(id);
    }

    @PostMapping("/Add")
    public ResponseEntity<Portlet> createPortlet(@RequestBody Portlet portlet) {
        Portlet createdPortlet = portletService.createPortlet(portlet);
        return new ResponseEntity<>(createdPortlet, HttpStatus.CREATED);
    }

    @PutMapping("/Update/{id}")
    public ResponseEntity<Map<String, Object>> updatePortlet(@PathVariable String id, @RequestBody Portlet portlet) {
        Portlet updatedPortlet = portletService.updatePortlet(id, portlet);
        if (updatedPortlet != null) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Portlet updated successfully");
            response.put("dashboard", updatedPortlet);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Portlet not found with id: " + id);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<String> deletePortlet(@PathVariable String id) {
        boolean deleted = portletService.deletePortlet(id);
        if (deleted) {
            return new ResponseEntity<>("Portlet removed successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Il n'y a aucun Portlet à supprimer", HttpStatus.NOT_FOUND);
        }

    }


    @DeleteMapping("/deleteAllPortlets")
    public ResponseEntity<String> deleteAllPortlets() {
        try {
            boolean deleted = portletService.deleteAllPortlets();
            if (deleted) {
                return ResponseEntity.ok("Portlets removed successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Il n'y a aucun Portlet à supprimer");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Une erreur s'est produite lors de la suppression");
        }
    }
    //Affectation
                                                     //{idPortlet}{idDashboard}
    @PutMapping("/affecterDashboardAListPortlet/{idPortlet}/{idDashboard}")
    public ResponseEntity<Map<String, String>> affecterDashboardAListPortlet(
            /*{idPortlet}*/ @PathVariable("idPortlet") String idPortlet,
            /*{idDashboard}*/@PathVariable("idDashboard") String idDashboard) {

        boolean affectationReussie =portletService.affecterDashboardAListPortlet(idPortlet, idDashboard);
        // Créez une carte pour stocker les informations de la réponse
        Map<String, String> response = new HashMap<>();
        if(affectationReussie){

            // Ajoutez les détails de l'affectation à la réponse
            response.put("message", "Affectation réussie");
            response.put("portletId", idPortlet);
            response.put("dashboardId", idDashboard);

            // Répondez avec un objet ResponseEntity contenant la carte de réponse
            return ResponseEntity.ok(response);
        } else {

            // Si le client ou le marché n'est pas trouvé, ajoutez un message d'erreur à la réponse
            response.put("message", "Portlet ou Dashboard non trouvé");

            // Répondez avec un statut NOT_FOUND et la carte de réponse
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }



    @PutMapping("/affecterChartAPortlet/{idPortlet}/{idChart}")
    public ResponseEntity<Map<String, String>> affecterChartAPortlet(
            /*{idPortlet}*/ @PathVariable("idPortlet") String idPortlet,
            /*{idDashboard}*/@PathVariable("idChart") String idChart) {

        boolean affectationReussie =portletService.affecterChartAPortlet(idPortlet, idChart);
        // Créez une carte pour stocker les informations de la réponse
        Map<String, String> response = new HashMap<>();
        if(affectationReussie){

            // Ajoutez les détails de l'affectation à la réponse
            response.put("message", "Affectation réussie");
            response.put("portletId", idPortlet);
            response.put("ChartId", idChart);

            // Répondez avec un objet ResponseEntity contenant la carte de réponse
            return ResponseEntity.ok(response);
        } else {

            // Si le client ou le marché n'est pas trouvé, ajoutez un message d'erreur à la réponse
            response.put("message", "Portlet ou idChart non trouvé");

            // Répondez avec un statut NOT_FOUND et la carte de réponse
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

}
