import { Component, OnInit, ViewChild } from "@angular/core";
import { AuthenticationService } from "../../../services/auth/authentication.service";
import { ClientsService } from "../../../services/clients.service";
import { Router, ActivatedRoute, Navigation } from "@angular/router";
import {
  FormBuilder,
  FormGroup,
  FormArray,
  Validators,
  NgForm,
} from "@angular/forms";
import { first } from "rxjs/operators";
import { Customer } from "src/app/models/customer";

@Component({
  selector: "app-profile",
  templateUrl: "./profile.component.html",
  styleUrls: ["./profile.component.css"],
})
export class ProfileComponent implements OnInit {
  loading = false;
  submitted = false;
  // form: FormGroup;
  @ViewChild("registerForm", { static: true }) editUserForm: NgForm;

  clientView: boolean;
  panelTitle: string = "Edit Client Profile";

  public customersList = [];
  customers: Customer[] = [];
  customer: Customer; //;
  custId: number;
  // registerForm: FormGroup;
  successMessage: string;

  constructor(
    private auth: AuthenticationService,
    private clientService: ClientsService,
    private formBuilder: FormBuilder,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit() {

    this.editUserForm.reset();

    this.auth.isCustLoggedIn()? this.getMyProfile():this.getAllCustomers();
    this.auth.isCustLoggedIn()? this.clientView = true:false;
    this.auth.isCustLoggedIn()? this.panelTitle = "Edit Profile":"Edit Client Profiles";
  }

  getAllCustomers() {
    this.clientService.getCustomers().subscribe(
      (response) => {
        console.log(response);
        this.customers = response;
      },
      (response) => {
        console.log("Failed to get all customers");
      }
    );
  }
  getMyProfile() {
    this.customer = this.auth.custValue;
   }
  getCustomer() {
    this.clientService.getCustomer(this.custId).subscribe(
      (response) => {
        this.customer = response;
      },
      (response) => {
        console.log("Failed to find customer");
      }
    );
  }

  editCustomer() {
    console.log("Will add updates for ", this.customer.firstName);
    this.clientService.updateCustomer(this.customer).subscribe(
      (response) => {
        this.editUserForm.reset();
        console.log("Added updates for ", this.customer.firstName);
      },
      (response) => {
        console.log("Failed to get all customers");
      }
    );
    this.auth.updateLocalStorage();
  }
}
