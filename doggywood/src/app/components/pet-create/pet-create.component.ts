import { Component, OnInit, ViewChild } from "@angular/core";
import { Router, ActivatedRoute, Navigation } from "@angular/router";
import {
  FormBuilder,
  FormGroup,
  FormArray,
  Validators,
  NgForm,
} from "@angular/forms";
import { PetsService } from "../../services/pets.service";
import { ClientsService } from "../../services/clients.service";
import { tap, first } from "rxjs/operators";
import { PetType } from "../../models/petType";
import { PetNeuter } from "../../models/petNeuter";
import { Pet } from "src/app/models/pet";
import { Customer } from "src/app/models/customer";

@Component({
  selector: "app-pet-create",
  templateUrl: "./pet-create.component.html",
  styleUrls: ["./pet-create.component.css"],
})
export class PetCreateComponent implements OnInit {
  loading = false;
  success = false;
  panelTitle: string;
  pet: Pet = new Pet(0, 0, "", "", 0, 0, 0, "", "");
  custId: number;
  petName: string;
  weight: number;
  color: string;
  type: number;
  breed: string;
  neuter: number;
  description: string;
  petUrl: string;
  unformattedDate: Date = new Date("30-JAN-2020");
  storage: any;

  petTypes: PetType[] = [
    { id: Number(1), name: "Dog" },
    { id: Number(2), name: "Cat" },
    { id: Number(3), name: "Parrot" },
    { id: Number(4), name: "Ferret" },
    { id: Number(5), name: "Other" },
  ];

  petNeuters: PetNeuter[] = [
    { id: 1, name: "Not Neutered" },
    { id: 2, name: "Neutered" },
    { id: 3, name: "Not Spayed" },
    { id: 4, name: "Spayed" },
  ];

  public petForm: NgForm;
  public petsList = [];

  constructor(
    private petService: PetsService,
    private clientService: ClientsService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit() {
    // on page load here
    this.panelTitle = "Register Pet";
    this.petService.getPets().subscribe((data) => (this.petsList = data));

    this.petService.getPets().subscribe((data) => (this.petsList = data));

    // this.activatedRoute.paramMap.subscribe(parameterMap => {
    //   const id = +parameterMap.get('id');
    //   this.getPet(id);
    // })
    console.log(this.unformattedDate);
  }

  public getPet(id) {
    if (id === 0) {
      this.pet = {
        id: null,
        custId: null,
        petName: "",
        birthDate: "",
        weight: null,
        color: "",
        type: null,
        breed: "",
        neuter: null,
        description: "",
        petUrl: "",
      };
      this.panelTitle = "Add Pet";
      // this.createPetForm.resetForm();
    } else {
      // this.pet = Object.assign({}, this._petService.getPet(id));
      this.petService.getPet(id).subscribe(
        (pet) => (this.pet = pet),
        (err: any) => console.log("create-pet.comp:" + err)
      );
      this.panelTitle = "Edit Pet Details";
    }
  }
  public navigate(): void {
    this.router.navigate([`clients`, this.pet.custId]);
    console.log("clients reset");
  }

  public savePet(): void {
    this.storage = sessionStorage;
    this.pet.custId = this.storage.getItem("custId");
    // if (this.pet.id === null) {
    //   this.pet.id = 0; // TEMP until we can get formatting.
    //   this.pet.custId = 99; // TEMP until session storage.
    // this.pet.birthDate = '22-JAN-2020'; // TEMP until we can get formatting.
    // this.pet.birthDate !== ''? this.pet.birthDate:'22-JAN-2020'; // this.unformattedDate.toString();

    this.petService.addPet(this.pet).subscribe((data) => {
      console.log(data);
    },
    data => {
      console.log(data);
      console.log("Failed to add pet.");
    });

    // this.createPetForm.resetForm();
    // this.router.navigate(['clients']);
    //   },
    //   (error: any) => console.log(error)
    // );
    // } else {
    //   this.petService.updatePet(this.pet).subscribe(
    //     () => {
    //       // this.createPetForm.reset();
    //       this.router.navigate(['clients']);
    //     },
    //     (error: any) => console.log(error)
    //   );
    // }
  }
}
