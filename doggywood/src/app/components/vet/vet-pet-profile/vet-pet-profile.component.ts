import { Component, OnInit } from '@angular/core';

import { ClientsService } from '../../../services/clients.service';
import { CliLandingService } from '../../../services/cli-landing.service';
  
 
import { Observable, throwError  } from 'rxjs';
import { catchError } from 'rxjs/operators';
import {  HttpHeaders, HttpErrorResponse,  HttpClient } from '@angular/common/http';
 
import { Pet } from 'src/app/models/pet';
import { PetsService } from 'src/app/services/pets.service';
import { Customer } from 'src/app/models/customer';
import { PetCreateComponent } from '../../pet-create/pet-create.component';
import { ActivatedRoute } from '@angular/router';
import { NotesService } from 'src/app/services/notes.service';
import { Note } from 'src/app/models/note';

@Component({
  selector: 'app-vet-pet-profile',
  templateUrl: './vet-pet-profile.component.html',
  styleUrls: ['./vet-pet-profile.component.css']
})
export class VetPetProfileComponent implements OnInit { 
 
  id: number;
  custId: number;
  firstName: string;
  lastName: string;
  email: string;
  phone: string;
  cusUrl: string;
  petId: number;

  public customer: Customer;
  public customerList = [];
  public pet: Pet;
  public petList = [];
  public note: Note;
  public noteList = []

  constructor(private route :ActivatedRoute, private clientService: ClientsService, private clientsService: ClientsService, private cliLandingService: CliLandingService, private petService: PetsService, private noteService: NotesService) { }

  ngOnInit() {
    this.clientsService.getClientByEmail(this.email).subscribe(data=>this.customer = data);
    this.petId = this.route.snapshot.params.animalId;
    this.petService.getPet(this.petId).subscribe(data=>this.pet = data); 
    this.noteService.getNoteByPetId(this.petId).subscribe(data=>this.noteList = data);
   
  //  setTimeout(function() {
  //     this.custId = this.pet.custId;
  //   console.log("Look here" + this.pet);
  //  }, 50)

  }

 
}
