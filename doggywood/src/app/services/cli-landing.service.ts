import { Injectable } from '@angular/core';
import { ClientsService } from './clients.service';
import { Observable, throwError } from 'rxjs';
import { Customer } from '../models/customer';
import { catchError } from 'rxjs/operators';
import { HttpHeaders, HttpErrorResponse, HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

export class CustomerWelcomeBean {
  constructor(public message: string) { }
}


@Injectable({
  providedIn: 'root'
})
export class CliLandingService {
  base_url: string =  `${environment.baseUrl}/`;
  email: string;
  emailUser: string;
  emailEmployee: string;
  public customerObject: Customer; // session OBJECT

  constructor( private http: HttpClient) { }
 
  public getSessionEmail() {
    this.emailUser = sessionStorage.getItem('authUser');
    this.emailEmployee = sessionStorage.getItem('authEmployee');
    
    this.email = (this.emailEmployee) ? this.emailEmployee : this.emailUser; 
    console.log(this.email);
    return this.email;
  }
//  public makeSessionData() {
//     //  console.log(this.customerObject.cusUrl)
//      sessionStorage.setItem("custId", (this.customerObject.id).toString());//this.number.toString());
//      sessionStorage.setItem("firstName", this.customerObject.firstName);
//      sessionStorage.setItem("lastName", this.customerObject.lastName);
//      sessionStorage.setItem("email", this.customerObject.email);
//      sessionStorage.setItem("phone", this.customerObject.email);
//      sessionStorage.setItem("cusUrl", this.customerObject.cusUrl) 
//   }

  getClientByEmail(email) { 
     return  this.http.get<Customer>(`${this.base_url}/customer-welcome/profile/${email}`);
  }
  // BEAN 
  collectClientBean() {
    return this.http.get<CustomerWelcomeBean>(`${this.base_url}/customer-welcome-bean`);
  } 
}
