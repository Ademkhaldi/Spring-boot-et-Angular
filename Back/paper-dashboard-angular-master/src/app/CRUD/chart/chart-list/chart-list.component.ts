import { Component, OnInit } from '@angular/core';
import { Chart } from '../chart.model';
import { ChartService } from '../service/chart.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-chart-list',
  templateUrl: './chart-list.component.html',
  styleUrls: ['./chart-list.component.scss']
})
export class ChartListComponent implements OnInit {

  public charts: Chart[] = []; // Initialisez avec un tableau vide

  constructor(private chartService: ChartService,private router: Router) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData() {
    this.chartService.getAllCharts().subscribe(data => {
      this.charts = data.map(Chart => ({
        ...Chart,
      }));
      console.log(data);
    });
  }

  createChart() {
    this.router.navigate(['AddChart'], { state: { title: 'Ajout Chart' } });
  }
  updateChart(id: string) {
    this.router.navigate(['UpdateChart', id]); // Ajustez la route de mise à jour
  }
  deleteChart(id: string) {
    this.chartService.deleteChart(id).subscribe(
      data => {
        console.log(data);
        this.reloadData();
      },
      error => console.log(error)
    );
  }
  deleteAllCharts(): void {
    this.chartService.deleteAllCharts()
      .subscribe({
        next: (res) => {
          console.log(res);
          this.reloadData();
        },
        error: (e) => console.error(e)
      });
  }
  chartDetails(id: string){
    this.router.navigate(['chart/details', id]); // Ajustez la route de détails

  }

  


  navigateToDashboardForm() {
    this.router.navigate(['getAllCharts']); // Ajustez la route de navigation vers le formulaire
  }
}
