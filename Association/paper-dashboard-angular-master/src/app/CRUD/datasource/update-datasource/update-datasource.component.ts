import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DatasourceService } from '../service/datasource.service';
import { Datasource } from '../datasource.model';

@Component({
  selector: 'app-update-datasource',
  templateUrl: './update-datasource.component.html',
  styleUrls: ['./update-datasource.component.scss']
})
export class UpdateDatasourceComponent implements OnInit {

  id: string = '';
  datasource: Datasource = new Datasource();
  updator_id: string = 'updator'; // Nouveau champ updator_id
  constructor(private route: ActivatedRoute, private router: Router,
              private datasourceService: DatasourceService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.datasourceService.retrieveDatasource(this.id)
      .subscribe(data => {
        console.log(data);
        this.datasource = data;
      }, error => console.log(error));
  } 

  updateDatasource() {
    const updateData = {
      ...this.datasource, // Copier toutes les autres propriétés du tableau de bord
      updator_id: this.updator_id // Ajouter l'updator_id
    };
  
    this.datasourceService.updateDatasource(this.id, updateData).subscribe(
      (data) => {
        console.log(data);
        this.gotoList();
      },
      (error) => {
        console.log(error);
      }
    );
  }

  onSubmit() {
    this.updateDatasource();
  }

  gotoList() {
    this.router.navigate(['/getAllDatasources']);
  }
  cancelUpdate() {
    this.gotoList(); // Naviguer vers la liste des tableaux de bord
  }
}
