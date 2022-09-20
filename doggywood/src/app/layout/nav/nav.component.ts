import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../../services/auth/authentication.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {
  public id:number = 0;
  public isEmpLoggedIn:boolean =  false;
   public isCustLoggedIn: boolean = false;
  constructor(private route: ActivatedRoute, public authenticationService: AuthenticationService) {


   }

  ngOnInit() {
    this.isEmpLoggedIn = this.authenticationService.isEmpLoggedIn();
    this.isCustLoggedIn = this.authenticationService.isCustLoggedIn();

    this.id = (this.authenticationService.isCustLoggedIn())? parseInt(sessionStorage.getItem("custId")): parseInt(sessionStorage.getItem("empId"));

     }

}
