import { Component, OnInit } from '@angular/core';
import { Portlet } from '../portlet.model';
import { ActivatedRoute, Router } from '@angular/router';
import { PortletService } from '../service/portlet.service';

@Component({
  selector: 'app-update-portlet',
  templateUrl: './update-portlet.component.html',
  styleUrls: ['./update-portlet.component.scss']
})
export class UpdatePortletComponent implements OnInit {

  id: string = '';
  portlet: Portlet = new Portlet();
  updator_id: string = 'updator'; // Nouveau champ updator_id
  constructor(private route: ActivatedRoute, private router: Router,
              private portletService: PortletService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.portletService.retrievePortlet(this.id)
      .subscribe(data => {
        console.log(data);
        this.portlet = data;
      }, error => console.log(error));
  } 

  updatePortlet() {
    const updateData = {
      ...this.portlet, // Copier toutes les autres propriétés du tableau de bord
      updator_id: this.updator_id // Ajouter l'updator_id
    };
  
    this.portletService.updatePortlet(this.id, updateData).subscribe(
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
    this.updatePortlet();
  }

  gotoList() {
    this.router.navigate(['/getAllPortlets']);
  }
  cancelUpdatePortlet() {
    this.gotoList(); // Naviguer vers la liste des tableaux de bord
  }
}
