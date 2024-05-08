import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DatasourceService } from '../service/datasource.service';
import { Datasource } from '../datasource.model';

@Component({
  selector: 'app-datasource-list',
  templateUrl: './datasource-list.component.html',
  styleUrls: ['./datasource-list.component.scss']
})
export class DatasourceListComponent implements OnInit {

  public datasources: Datasource[] = []; // Initialisez avec un tableau vide

  constructor(private datasourceService: DatasourceService,private router: Router) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData() {
    this.datasourceService.getAllDatasources().subscribe(data => {
      this.datasources = data.map(Datasource => ({
        ...Datasource,
      }));
      console.log(data);
    });
  }

  createDatasource() {
    this.router.navigate(['/AddDatasource']); // Ajustez la route de création
  }
  updateDatasource(id: string) {
    this.router.navigate(['/UpdateDatasource', id]); // Ajustez la route de mise à jour
  }
  deleteDatasource(id: string) {
    this.datasourceService.deleteDatasource(id).subscribe(
      data => {
        console.log(data);
        this.reloadData();
      },
      error => console.log(error)
    );
  }
  deleteAllDatasources(): void {
    this.datasourceService.deleteAllDatasources()
      .subscribe({
        next: (res) => {
          console.log(res);
          this.reloadData();
        },
        error: (e) => console.error(e)
      });
  }
  datasourceDetails(id: string){
    this.router.navigate(['datasource/details', id]); // Ajustez la route de détails

  }

  


  navigateToDashboardForm() {
    this.router.navigate(['getAllDatasources']); // Ajustez la route de navigation vers le formulaire
  }
}
