import { Injectable } from "@angular/core";
import { ClientsService } from "../../services/clients.service";
import { Customer } from "../../models/customer";
import { Employee } from "../../models/employee";
import { BehaviorSubject, Observable, throwError } from "rxjs";
import { map } from "rxjs/operators";
import { CliLandingService } from "../cli-landing.service";
import {
  HttpHeaders,
  HttpErrorResponse,
  HttpClient,
  JsonpClientBackend,
} from "@angular/common/http";
import { Router } from "@angular/router";
import { environment } from "src/environments/environment";

export class CustomerWelcomeBean {
  constructor(public message: string) {}
}
export class CustomerDataBean {
  constructor(public message: string) {}
}

@Injectable({
  providedIn: "root",
})
export class AuthenticationService {
  private customer: Customer;
  private custSubject: BehaviorSubject<Customer>;
  private custObservable: Observable<Customer>;
  public custObject: Customer; // session OBJECT
  public custId: number;

  private empSubject: BehaviorSubject<Employee>;
  private empObservable: Observable<Employee>;
  public empObject: Employee;
  public empId: number;

  loggedIn: string;
  object: any;
  url = `${environment.baseUrl}/customer-welcome/profile`;
  emp_url = `${environment.baseUrl}/employee-welcome/profile`;

  constructor(
    private clientService: ClientsService,
    private cliLandingService: CliLandingService,
    private http: HttpClient,
    private router: Router
  ) {
    this.custSubject = new BehaviorSubject<Customer>(
      JSON.parse(localStorage.getItem("cust"))
    );
    this.custObservable = this.custSubject.asObservable();

    this.empSubject = new BehaviorSubject<Employee>(
      JSON.parse(localStorage.getItem("emp"))
    );
    this.empObservable = this.empSubject.asObservable();
  }

  // GETTERS
  public get custValue(): Customer {
    return this.custSubject.value;
  }
  public get empValue(): Employee {
    return this.empSubject.value;
  }

  // UPDATE LOCAL STORAGE AFTER PROFILE CHANGE
  public updateLocalStorage() {
    this.clientService.getCustomer(this.getCustId()).subscribe(
      (response) => {
        this.customer = response;
        localStorage.removeItem("cust");
        localStorage.setItem("cust", JSON.stringify(this.customer));
        this.custSubject.next(this.customer);
      },
      (response) => {
        console.log("Failed to update local storage");
      }
    );
  }

  loginCust(email: string, password: string): Observable<Customer> {
    return this.http
      .post<Customer>(`${this.url}/login`, { email, password })
      .pipe(
        map((cust) => {
          // store user details and jwt token in local storage to keep user logged in between page refreshes
          localStorage.setItem("cust", JSON.stringify(cust));
          this.custSubject.next(cust);
          return cust;
        })
      );
  }

  loginEmp(email: string, password: string): Observable<Employee> {
    return this.http
      .post<Employee>(`${this.emp_url}/login`, { email, password })
      .pipe(
        map((emp) => {
          // store user details and jwt token in local storage to keep user logged in between page refreshes
          localStorage.setItem("emp", JSON.stringify(emp));
          this.empSubject.next(emp);
          return emp;
        })
      );
  }


  public getCustId() {
    this.custObject = JSON.parse(localStorage.getItem("cust"));
    console.log("get custId:" + this.custObject.id);
    return this.custObject.id;
  }
  public getEmpId() {
    this.empObject = JSON.parse(localStorage.getItem("emp"));
    console.log("get empId:" + this.empObject.id);
    return this.empObject.id;
  }

  // get cust data from email
  public getClientDataByEmail(email) {
    this.cliLandingService
      .getClientByEmail(email)
      .subscribe((data) => (this.custObject = data));
  }

  // verify Logged in
  public isCustLoggedIn() {
    this.custObject = JSON.parse(localStorage.getItem("cust"));
    return !(this.custObject === null); // i.e. true
  }
  public isEmpLoggedIn() {
    this.empObject = JSON.parse(localStorage.getItem("emp"));
    return !(this.empObject === null); // i.e. true
  }

  public logout() {
    localStorage.removeItem("cust");
    localStorage.removeItem("emp");
    this.custSubject.next(null);
    this.empSubject.next(null);
  }
}
