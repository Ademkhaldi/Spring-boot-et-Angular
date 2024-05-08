package com.example.stage6.Dashboard.Service;

import com.example.stage6.Dashboard.entity.Dashboard;
import com.example.stage6.Dashboard.repository.DashboardRepository;
import com.example.stage6.Portlet.entity.Portlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DashboardService implements IDashboardService {

    @Autowired
    private DashboardRepository dashboardRepository;

    @Override

    public List<Dashboard> getAllDashboards() {
        return dashboardRepository.findAll();
    }
    @Override
    public Dashboard retrieveDashboard(String id) {
        return dashboardRepository.findById(id).orElse(null);
    }    @Override


    public Dashboard createDashboard(Dashboard dashboard) {
        dashboard.setCreationDate(new Date()); // Utilise la date et l'heure actuelles lors de la création
        return dashboardRepository.save(dashboard);
    }
    @Override

    public Dashboard updateDashboard(String id, Dashboard dashboard) {
        Optional<Dashboard> existingDashboardOptional = dashboardRepository.findById(id);
        if (existingDashboardOptional.isPresent()) {
            Dashboard existingDashboard = existingDashboardOptional.get();
            existingDashboard.setTitle(dashboard.getTitle());
            existingDashboard.setPortlets(dashboard.getPortlets());

            // Mise à jour de la date de mise à jour et de l'identifiant du metteur à jour
            existingDashboard.setUpdate_date(new Date());
            existingDashboard.setUpdator_id(dashboard.getUpdator_id());

            return dashboardRepository.save(existingDashboard);
        } else {
            return null; // Gérer l'absence de l'élément à mettre à jour comme vous le souhaitez
        }
    }

    @Override

    public boolean deleteDashboard(String id) {
        if (dashboardRepository.existsById(id)) {
            dashboardRepository.deleteById(id);
            return true;
        } else {
            return false; // Gérer l'absence de l'élément à supprimer comme vous le souhaitez
        }
    }

    @Override
    public boolean deleteAllDashboards() {
        long countBeforeDelete = dashboardRepository.count();
        dashboardRepository.deleteAll();
        long countAfterDelete = dashboardRepository.count();
        return countBeforeDelete != countAfterDelete;

    }

    //Affectation
    @Override
    public Dashboard assignerPortlet(String id, List<Portlet> portlets) {
        Optional<Dashboard> optionalDashboard = dashboardRepository.findById(id);

        if (optionalDashboard.isPresent()) {
            Dashboard dashboard = optionalDashboard.get();
            dashboard.setPortlets(portlets);
            return dashboardRepository.save(dashboard);
        } else {
            // Gérer le cas où la colonne n'est pas trouvée
            // Vous pouvez lancer une exception appropriée ou renvoyer null, selon vos besoins
            return null;
        }
    }

}
