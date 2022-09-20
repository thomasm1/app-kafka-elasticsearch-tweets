import { Component, OnInit } from '@angular/core';

import {Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import {HttpHeaders, HttpErrorResponse, HttpClient } from '@angular/common/http';

import { VacCreateComponent } from '../../vac-create/vac-create.component';
import { VaccRecord} from '../../../models/vacc-record';
import { VaccRecordService } from "../../../services/vacc-record.service";
import { Router, ActivatedRoute } from '@angular/router';
import { Pet } from 'src/app/models/pet';
import { PetsService } from 'src/app/services/pets.service';
import { NotesService } from 'src/app/services/notes.service';
import { Note } from 'src/app/models/note'; 

@Component({
  selector: 'app-cli-pet-record',
  templateUrl: './cli-pet-record.component.html',
  styleUrls: ['./cli-pet-record.component.css']
})


export class CliPetRecordComponent implements OnInit {
custId:string;
petId: number; 
parentPetId:number; 

recList: VaccRecord[];
public vaccList = [];
public expireList = [];
public pet:Pet;
public note:Note;


  constructor(private vaccService: VaccRecordService, private router: Router, private route: ActivatedRoute, private petService: PetsService, private noteService: NotesService) { }

  
  ngOnInit() {
     this.custId = sessionStorage.getItem('custId');
    console.log("custId "+ this.custId);
    this.petId = this.route.snapshot.params.animalId;
    console.log("petId "+this.petId); 
    this.parentPetId = this.petId; 
    this.petService.getPet(this.petId).subscribe(data=>this.pet = data); 
    console.log("petData "+this.pet);
    
    this.vaccService.getVaccRecordByPetId(this.petId)
    .subscribe(data => {this.recList = data}, data => {console.log('w e l o s t b o y s')}); 
   
  }

  backToConsole() {
     this.router.navigate(['clients',this.custId]); 
  }

}


