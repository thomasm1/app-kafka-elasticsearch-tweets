import { Injectable } from "@angular/core";
import {
  HttpHeaders,
  HttpErrorResponse,
  HttpClient,
} from "@angular/common/http";
import { Observable, throwError } from "rxjs";
import { Customer } from "../models/customer";
import { catchError } from "rxjs/operators";
import { environment } from "src/environments/environment";

@Injectable({
  providedIn: "root",
})
export class ClientsService {
  email: string;
  custs_url: string = `${environment.baseUrl}/customers`;
  base_url: string = `${environment.baseUrl}`;
  private headers = new HttpHeaders({ "Content-Type": "application/json" });

  constructor(private http: HttpClient) {}

  // error handler
  private handleError(errorResponse: HttpErrorResponse) {
    if (errorResponse.error instanceof ErrorEvent) {
      console.error(
        "Client-side Error getting customers: ",
        errorResponse.error.message
      );
    } else {
      console.error("Server Side Error: ", errorResponse);
    }
    return throwError("Oops, there is a problem  ..");
  }

  getCustomers(): Observable<Customer[]> {
    return this.http
      .get<Customer[]>(this.custs_url)
      .pipe(catchError(this.handleError));
  }
  // getAllCustomer() :Observable<Customer[]> {
  //   return this.http.get<Customer[]>("http://localhost:3000/customer");
  // }

  getCustomer(id: number): Observable<Customer> {
    // return this.listCustomers.find(u => u.id === id)
    return this.http
      .get<Customer>(`${this.custs_url}/${id}`)
      .pipe(catchError(this.handleError));
  }
  getClientByEmail(email: string) {
    return this.http.get<Customer>(
      `${this.base_url}/customer-welcome/profile/${email}`
    );
  }

  addCustomer(customer: Customer): Observable<Customer> {
    return this.http
      .post<Customer>(this.custs_url, customer, {
        headers: new HttpHeaders({
          "Content-Type": "application/json",
        }),
      })
      .pipe(catchError(this.handleError));
  }
  // addCustomer(cust :Customer) :Observable<Customer> {
  //   return this.http.post<Customer>("http://localhost:3000/customer", cust, {headers: this.headers});
  // }

  updateCustomer(customer: Customer): Observable<void> {
    return this.http
      .put<void>(`${this.custs_url}`, customer, {
        headers: new HttpHeaders({
          "Content-Type": "application/json",
        }),
      })
      .pipe(catchError(this.handleError));
  } ///${customer.id}

  deleteCustomer(id: number): Observable<void> {
    return this.http
      .delete<void>(`${this.custs_url}/${id}`)
      .pipe(catchError(this.handleError));
  }
}
