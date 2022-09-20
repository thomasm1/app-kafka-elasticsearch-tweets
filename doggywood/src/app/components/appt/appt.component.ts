import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AppointmentService } from 'src/app/services/appointment.service';
import { Appointment } from 'src/app/models/appointment';
import { PetsService } from 'src/app/services/pets.service';
import { Pet } from 'src/app/models/pet';
import { ClientsService } from 'src/app/services/clients.service';
import { Customer } from 'src/app/models/customer';
import { NotesService } from 'src/app/services/notes.service';
import { Note } from 'src/app/models/note'; 
// add notes and edit weight need to be fixed 
@Component({
  selector: 'app-appt',
  templateUrl: './appt.component.html',
  styleUrls: ['./appt.component.css']
})
export class ApptComponent implements OnInit {
  apptId :number;
  appointment :Appointment;
  petId :number;
  pet :Pet;
  customer :Customer;
  notes :Note[];
  noteMessage :string;
  newWeight :number;
  // firstDate : Date = new Date("2020-4-20");
  // dateTest :Date = new Date(this.firstDate.valueOf() + 5 * 86400000);
  constructor(
    private route :ActivatedRoute,
    private apptService :AppointmentService,
    private petService :PetsService,
    private clientService :ClientsService,
    private noteService :NotesService
  ) { }
  ngOnInit() {
    this.apptId = this.route.snapshot.params.apptId;
    this.getAppointment(this.apptId);
  }
  getAppointment(id :number) {
    this.apptService.getAppointment(id).subscribe(
      response => {
        this.appointment = response;
        this.getPet(this.appointment.petId);
        this.getNotes(this.appointment.id);
      },
      response => {
        console.log("failed to get appointment");
      });
  }
  getPet(id :number) {
    this.petService.getPet(id).subscribe(
      res => {
        this.pet = res;
        this.getOwner(this.pet.custId);
      },
      res => {
        console.log(res);
        console.log("failed to get pet");
      });
  }
  getOwner(id :number) {
    this.clientService.getCustomer(id).subscribe(
      res => {
        this.customer = res;
      },
      res => {
        console.log("failed to get pet owner");
      });
  }
  getNotes(id :number) {
    this.noteService.getNotesByApptId(id).subscribe(
      res => {
        this.notes = res;
      },
      res => {
        console.log("failed to get notes");
      }
    );
  }
  addNote() {
    this.noteService.createNote(new Note(this.noteMessage, 0, this.apptId, this.appointment.petId)).subscribe(
      res => {
        console.log(res);
        let list = this.notes.slice();
        list.push(res);
        this.notes = list;
      },
      res => {
        console.log("failed to add note");
      }
    )
  }
  updateWeight() {
    this.pet.weight = this.newWeight;
    this.petService.addPet(this.pet).subscribe(
        res => {
          console.log(res);
        },
        res => {
          console.log("failed to update pet weight");
        }
      );
    this.appointment.weight = this.newWeight;
    this.apptService.updateAppointment(this.appointment).subscribe(
      res => {
        console.log(res);
      },
      res => {
        console.log("failed to update appt weight");
      }
    )
  }
  logAppt() {
    console.log(`To do: change how the dates are displayed, AM/PM, display weight, edit weight and then display it`);
    // console.log(this.firstDate)
    // console.log("date + 5 days: " + this.dateTest);
    console.log(this.newWeight);
  }
}