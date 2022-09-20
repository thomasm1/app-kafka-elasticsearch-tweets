import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Vaccination } from '../models/vaccination';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class VaccinationService {

  constructor(private http:HttpClient) { }

  private handleError(errorResponse: HttpErrorResponse) {
    if (errorResponse.error instanceof ErrorEvent) {
      console.error('Client-side Error getting vaccinations: ', errorResponse.error.message)
    } else {
      console.error('Server Side Error: ', errorResponse);
    }
    return throwError('Oops, there is a problem  ..');
  }
  
  getVaccination(id :number) :Observable<Vaccination> {
    return this.http.get<Vaccination>(`${environment.baseUrl}/vaccinations/${id}`)
    .pipe(catchError(this.handleError));
  }

  getAllVaccinations() :Observable<Vaccination[]> {
    return this.http.get<Vaccination[]>(`${environment.baseUrl}/vaccinations/`)
    .pipe(catchError(this.handleError));
  }

}
