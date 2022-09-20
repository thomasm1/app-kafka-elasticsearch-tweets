import { Injectable } from '@angular/core';
import { HttpHeaders, HttpErrorResponse, HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { Employee } from '../models/employee';
import { catchError } from 'rxjs/operators';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class EmployeesService {

  emps_url: string =  `${environment.baseUrl}/customers`;
  empsByEmail_url: string =  `${environment.baseUrl}/employee-welcome/profile`;
  constructor(private http: HttpClient) { }
 
  // error handler
  private handleError(errorResponse: HttpErrorResponse) {
    if (errorResponse.error instanceof ErrorEvent) {
      console.error('Client-side Error getting employees: ', errorResponse.error.message)
    } else {
      console.error('Server Side Error: ', errorResponse);
    }
    return throwError('Oops, there is a problem  ..');
  }

  getEmployees(): Observable<Employee[]> {
    return this.http.get<Employee[]>(this.emps_url)
      .pipe(catchError(this.handleError));
  }

  getEmployeeByEmail(email: string): Observable<Employee> {
    // return this.listEmployees.find(u => u.id === id)
    return this.http.get<Employee>(`${this.empsByEmail_url}/${email}`)
      .pipe(catchError(this.handleError));
  }
  getEmployee(id: number): Observable<Employee> {
    // return this.listEmployees.find(u => u.id === id)
    return this.http.get<Employee>(`${this.emps_url}/${id}`)
      .pipe(catchError(this.handleError));
  }

  addEmployee(employee: Employee): Observable<Employee> {
    return this.http.post<Employee>(this.emps_url, employee, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    })
      .pipe(catchError(this.handleError));
  }

  updateEmployee(employee: Employee): Observable<void> {
    return this.http.put<void>(`${this.emps_url}/${employee.id}`, employee, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    })
      .pipe(catchError(this.handleError));
  }

  deleteEmployee(id: number): Observable<void> {
    return this.http.delete<void>(`${this.emps_url}/${id}`)
      .pipe(catchError(this.handleError));

  }
}
