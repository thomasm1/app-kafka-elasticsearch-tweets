import { Component, OnInit } from '@angular/core';
import { Router  } from '@angular/router';
import { AppointmentService } from 'src/app/services/appointment.service';
import { Appointment } from 'src/app/models/appointment';
import { ClientsService } from 'src/app/services/clients.service';
import { Customer } from 'src/app/models/customer';
import { PetsService } from 'src/app/services/pets.service';
import { Pet } from 'src/app/models/pet';

@Component({
  selector: 'app-appt-create',
  templateUrl: './appt-create.component.html',
  styleUrls: ['./appt-create.component.css']
})
export class ApptCreateComponent implements OnInit {
  public customersList = [];
  customers :Customer[] = [];
  custId :number;
  pets :Pet[] = [];
  petId :number;
  weight :number;
  date :string;
  timeSlot :number;
  description :string;
  storage :any;
  empId :number;

  constructor(private router: Router, private apptService :AppointmentService, private clientService :ClientsService, private petService :PetsService) { }

  ngOnInit() {
    setTimeout(() => { 
        this.storage = sessionStorage; 
        this.empId = parseInt(this.storage.getItem("empId"));
       }, 250);

    this.getAllCustomers();
  }

  addAppointment() {
    this.petService.getPet(this.petId).subscribe(
      response => {
        console.log(response.weight);
        this.weight = response.weight;
      },
      response => {
        console.log("failed to get pet by id");
      });
    console.log(this.weight);
    this.apptService.addAppointment(new Appointment(0, this.custId, this.petId, this.empId, this.date, this.weight, this.timeSlot, this.description)).subscribe(
      response => {
        console.log(response);
        this.router.navigate([`vetLanding`]);
      },
      response => {
        console.log(response);
        console.log("Failed to add appointment.");
      });
  }

  getAllCustomers() {
    this.clientService.getCustomers().subscribe(
      response => {
        console.log(response);
        this.customers = response;
      },
      response => {
        console.log("Failed to get all customers");
      });
  }

  getPets() {
    this.petService.getPetByCust(this.custId).subscribe(
      response => {
        this.pets = response;
      },
      response => {
        console.log("Failed to get pets");
      });
  }
}
