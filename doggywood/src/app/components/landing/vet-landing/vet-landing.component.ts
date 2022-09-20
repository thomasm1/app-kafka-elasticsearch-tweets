import { Component, OnInit } from "@angular/core";
import { timeout } from "rxjs/operators";
import { timeoutWith } from "rxjs/operators";
import { map } from "rxjs/operators";
import { of, TimeoutError } from "rxjs";

import { Observable, throwError } from "rxjs";
import { catchError } from "rxjs/operators";
import {
  HttpHeaders,
  HttpErrorResponse,
  HttpClient,
} from "@angular/common/http";
import { AppointmentService } from "../../../services/appointment.service";
import { Appointment } from "../../../models/appointment";
import { EmployeesService } from "../../../services/employees.service";
import { Employee } from "../../../models/employee";
import { ClientsService } from "../../../services/clients.service";
import { Router, ActivatedRoute } from "@angular/router";
import { isNumber } from "util";
import { AuthenticationService } from "src/app/services/auth/authentication.service";

@Component({
  selector: "app-vet-landing",
  templateUrl: "./vet-landing.component.html",
  styleUrls: ["./vet-landing.component.css"],
})
export class VetLandingComponent implements OnInit {
  eid: number;
  panelTitle: string = "Welcome, ";
  object: string;
  email: string;

  id: number;
  empId: number;
  firstName: string;
  lastName: string;
  phone: string;
  eType: string;

  storage: any;
  custId: number;
  petId: number;
  date: string;
  weight: number;
  timeSlot: number;
  description: string;
  today: any;
  custNameDisp: string;

  public employee: Employee;
  public appointment: Appointment;
  public apptList = [];
  constructor(
    private employeesService: EmployeesService,
    private apptService: AppointmentService,
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private clientService: ClientsService,
    private authenticationService: AuthenticationService
  ) {}

  ngOnInit() {
    this.displayDate();
    setTimeout(() => {
      // this.employeesService.getEmployeeByEmail(this.email).subscribe(data => {
      //   this.employee = data,
      //     console.log("emp object: "+ this.employee)
      // })

      this.employee = JSON.parse(localStorage.getItem("emp"));
      this.email = this.employee.email;
      this.empId = this.employee.id;
      console.log("vet landing email: " + this.email);

      this.apptService.getAppointmentsByEmployee(this.empId).subscribe(
        (data) => {
          this.apptList = data;
        },
        (data) => {
          console.log("w e l o s t b o y s");
        }
      );
    }, 500);
  }

  displayDate() {
    this.today = new Date();
    var dd: any = this.today.getDate();
    var mm: any = this.today.getMonth() + 1;
    var yyyy: any = this.today.getFullYear();
    if (dd < 10) {
      dd = "0" + dd;
    }

    if (mm < 10) {
      mm = "0" + mm;
    }

    this.today = dd + "-" + mm + "-" + yyyy;
    console.log(this.today);
  }
}
