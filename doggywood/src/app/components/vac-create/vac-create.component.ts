import { Component, OnInit, Input } from '@angular/core';
import { VaccRecordService } from 'src/app/services/vacc-record.service';
import { PetsService } from 'src/app/services/pets.service';
import { Pet } from 'src/app/models/pet';
import { VaccRecord } from 'src/app/models/vacc-record';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-vac-create',
  templateUrl: './vac-create.component.html',
  styleUrls: ['./vac-create.component.css']
})
export class VacCreateComponent implements OnInit {
  @Input() importPetId: number;
  int: number;
  petId: number;
  vName: string;
  vTime: number;
  vDate: string;
  pet: Pet;


  constructor(private route: ActivatedRoute, private recordService: VaccRecordService, private petService: PetsService) {

  }

  ngOnInit() {

    console.log("ngOnInit: " + this.importPetId)
  }

  addRecord() {

    console.log("addRecord() " + this.importPetId) 
    console.log(0, this.importPetId, this.vName, this.vTime, this.vDate)

    this.recordService.createVaccRecord(new VaccRecord(0,this.importPetId, this.vName, this.vTime, this.vDate)).subscribe(
      response => {
        console.log(response);
        location.reload(true);
      },
      response => {
        console.log(response);
        alert("Oops, failed to add vaccine!!");
      }
    );

    //     this.petService.getPet(this.petId).subscribe(
    //   response => {
    //     console.log(response.weight);
    //     this.weight = response.weight;
    //   },
    //   response => {
    //     console.log("failed to get pet by id");
    //   });
    // console.log(this.weight);

    // this.apptService.addAppointment(new Appointment(0, this.custId, this.petId, this.empId, this.date, this.weight, this.timeSlot, this.description)).subscribe(
    //   response => {
    //     console.log(response);
    //   },
    //   response => {
    //     console.log(response);
    //     console.log("Failed to add appointment.");
    //   });
  }


  getPet() {
    this.petService.getPet(this.petId).subscribe(
      response => {
        this.pet = response;
        console.log(this.pet);
      },
      response => {
        console.log("Failed to get pets")
      }

    )

  }

}
