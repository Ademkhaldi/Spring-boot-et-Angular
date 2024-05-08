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
    
     // Vérification de Title
     if (this.dashboard.title.length === 0 ) {
      this.showErrorMessage('title', "title ne peut pas être vide");
      return;
    }
    
    
    
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
    // Méthode pour afficher un message d'erreur sous le champ correspondant
    showErrorMessage(inputId: string, message: string): void {
      const inputElement = document.getElementById(inputId);
      const errorDiv = inputElement.nextElementSibling;
      if (errorDiv && errorDiv.classList.contains('text-danger')) {
        errorDiv.textContent = message;
      } else {
        const div = document.createElement('div');
        div.textContent = message;
        div.classList.add('text-danger');
        inputElement.insertAdjacentElement('afterend', div);
      }
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