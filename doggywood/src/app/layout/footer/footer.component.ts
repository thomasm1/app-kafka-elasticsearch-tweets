import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../../services/auth/authentication.service';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {

  title: string = 'An Angular-Java-Oracle Full-Stack App by: Thomas Maestas, Brendan Wilson, Davis Cowles, Ruben Colon';
  footerTitle: string = 'Doggywood Boulevard Veterinary';
  footerSubtext: string = 'Safeguarding The Bond We Share with Our Pets';

  constructor(public authenticationService: AuthenticationService) { }

  ngOnInit() {
  }

}
