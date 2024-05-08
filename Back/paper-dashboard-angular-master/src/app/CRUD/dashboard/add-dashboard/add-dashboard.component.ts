import { Component, OnInit } from '@angular/core';
import { Dashboard } from 'app/CRUD/dashboard/dashboard.model';
import { DashboardService } from 'app/CRUD/dashboard/service/dashboard.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-dashboard',
  templateUrl: './add-dashboard.component.html',
  styleUrls: ['./add-dashboard.component.scss']
})
export class AddDashboardComponent implements OnInit {

  dashboard: Dashboard = {
    title: '',
  };
  submitted = false;
  creator_id: string = 'creator'; // Nouveau champ creator_id
  constructor(private dashboardService: DashboardService,private router:Router) { }
  ngOnInit(): void {
  }

  saveDashboard(): void {
    const data = {
      title: this.dashboard.title,
      creator_id: this.creator_id // Ajoutez le creator_id lors de la sauvegarde du tableau de bord

    };

    this.dashboardService.createDashboard(data)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.submitted = true;
        },
        error: (e) => console.error(e)
      });
  }


  newDashboard(): void {
    this.submitted = false;
    this.dashboard = {
      title: '',
      
    };
  }

  
  gotoList() {
    this.router.navigate(['/getAllDashboards']); // Assurez-vous que l'URL est correcte pour la liste des markets
  }


}