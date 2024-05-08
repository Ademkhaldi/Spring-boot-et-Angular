import { Component, OnInit, Output,EventEmitter  } from '@angular/core';
import { Portlet } from '../portlet.model';
import { PortletService } from '../service/portlet.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-portlet',
  templateUrl: './add-portlet.component.html',
  styleUrls: ['./add-portlet.component.scss']
})
export class AddPortletComponent implements OnInit {
  portlet: Portlet = {
    row: '',
    column: '',
  };
  submitted = false;
  creator_id: string = 'creator'; // Initialize creator_id as empty string
  navbarTitle: string = 'List'; // Provide a default value for navbarTitle
  constructor(private portletService: PortletService, private router: Router) { }
  ngOnInit(): void {
  }

  savePortlet(): void {
    const data = {
      row: this.portlet.row,
      column: this.portlet.column,
      creator_id: this.creator_id // Add creator_id when saving the datasource
    };

    this.portletService.createPortlet(data)
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

  newPortlet(): void {
    this.submitted = false;
    this.portlet = {
      row: '',
      column: ''
    };
  }

  gotoList() {
    this.router.navigate(['/getAllPortlets']); // Make sure the URL is correct for the list of datasources
  }
}
