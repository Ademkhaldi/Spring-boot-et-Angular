import { Component, OnInit } from '@angular/core';
import { DatasourceService } from '../service/datasource.service';
import { Router } from '@angular/router';
import { Datasource } from '../datasource.model';

@Component({
  selector: 'app-add-datasource',
  templateUrl: './add-datasource.component.html',
  styleUrls: ['./add-datasource.component.scss']
})
export class AddDatasourceComponent implements OnInit {

  datasource: Datasource = {
    type: '',
    connection_port: 0,
  };
  submitted = false;
  creator_id: string = 'creator'; // Initialize creator_id as empty string
  navbarTitle: string = 'List'; // Provide a default value for navbarTitle
  constructor(private datasourceService: DatasourceService, private router: Router) { }
  ngOnInit(): void {
  }

  saveDatasource(): void {
    const data = {
      type: this.datasource.type,
      connection_port: this.datasource.connection_port,
      creator_id: this.creator_id // Add creator_id when saving the datasource
    };

    this.datasourceService.createDatasource(data)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.submitted = true;
        },
        error: (e) => {
          console.error(e);
          // Handle errors appropriately
        }
      });
  }

  newDatasource(): void {
    this.submitted = false;
    this.datasource = {
      type: '',
      connection_port: 0
    };
  }

  gotoList() {
    this.router.navigate(['/getAllDatasources']); // Make sure the URL is correct for the list of datasources
  }
}
