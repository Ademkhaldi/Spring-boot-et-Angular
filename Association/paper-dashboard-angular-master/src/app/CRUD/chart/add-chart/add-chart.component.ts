import { Component, OnInit } from '@angular/core';
import { ChartService } from '../service/chart.service';
import { Router } from '@angular/router';
import { charttype, charttypeLabelMapping } from '../charttype.model';
import { Chart } from '../chart.model';

@Component({
  selector: 'app-add-chart',
  templateUrl: './add-chart.component.html',
  styleUrls: ['./add-chart.component.scss']
})
export class AddChartComponent implements OnInit {
  public charttypeLabelMapping = charttypeLabelMapping;
  public Charttypes = Object.values(charttype);

  chart: Chart = {
    title: '',
    //type: undefined,
    type: charttype.Line,
    x_axis: '',
    y_axis: '',

  };
  submitted = false;
  creator_id: string = 'creator'; // Initialize creator_id as empty string
  navbarTitle: string = 'List'; // Provide a default value for navbarTitle
  constructor(private chartService: ChartService, private router: Router) { }
  ngOnInit(): void {
  }

  saveChart(): void {
    const data = {
      title: this.chart.title,
      type: this.chart.type,
      x_axis: this.chart.x_axis,
      y_axis: this.chart.y_axis,

            
      creator_id: this.creator_id // Add creator_id when saving the datasource
    };

    this.chartService.createChart(data)
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

  newChart(): void {
    this.submitted = false;
    this.chart = {
      title: '',
      type: charttype.Line,
      x_axis: '',
      y_axis: '',
      };
  }

  gotoList() {
    this.router.navigate(['/getAllCharts']); // Make sure the URL is correct for the list of datasources
  }
}
