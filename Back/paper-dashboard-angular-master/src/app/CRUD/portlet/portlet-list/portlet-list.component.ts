import { Component, OnInit } from '@angular/core';
import { Portlet } from '../portlet.model';
import { PortletService } from '../service/portlet.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-portlet-list',
  templateUrl: './portlet-list.component.html',
  styleUrls: ['./portlet-list.component.scss']
})
export class PortletListComponent implements OnInit {

  public portlets: Portlet[] = []; // Initialisez avec un tableau vide

  constructor(private portletService: PortletService,private router: Router) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData() {
    this.portletService.getAllPortlets().subscribe(data => {
      this.portlets = data.map(Portlet => ({
        ...Portlet,
      }));
      console.log(data);
    });
  }

  createPortlet() {
    this.router.navigate(['AddPortlet'], { state: { title: 'Ajout Portlet' } });
  }
  updatePortlet(id: string) {
    this.router.navigate(['UpdatePortlet', id]); // Ajustez la route de mise à jour
  }
  deletePortlet(id: string) {
    this.portletService.deletePortlet(id).subscribe(
      data => {
        console.log(data);
        this.reloadData();
      },
      error => console.log(error)
    );
  }
  deleteAllPortlets(): void {
    this.portletService.deleteAllPortlets()
      .subscribe({
        next: (res) => {
          console.log(res);
          this.reloadData();
        },
        error: (e) => console.error(e)
      });
  }
  portletDetails(id: string){
    this.router.navigate(['portlet/details', id]); // Ajustez la route de détails

  }

  


  navigateToDashboardForm() {
    this.router.navigate(['getAllPortlets']); // Ajustez la route de navigation vers le formulaire
  }
}
