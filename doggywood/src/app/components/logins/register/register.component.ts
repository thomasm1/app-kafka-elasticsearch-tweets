import { Component, OnInit } from "@angular/core";
import { RegisterModel } from "../../../models/register";
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
import { AuthenticationService } from "src/app/services/auth/authentication.service";
import { ClientsService } from "../../../services/clients.service";

@Component({
  selector: "app-register",
  templateUrl: "./register.component.html",
  styleUrls: ["./register.component.css"],
})
export class RegisterComponent implements OnInit {
  loading = false;
  submitted = false;
  // registerForm: NgForm;
  form: FormGroup;
  //  @ViewChild('registerForm')
  panelTitle: string;
  customer: Customer; //;
  // registerForm: FormGroup;
  successMessage: string;
  public customersList = [];

  constructor(
    private clientService: ClientsService,
    private authService: AuthenticationService,
    private formBuilder: FormBuilder,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit() {
    this.form = this.formBuilder.group({
      id: null,
      firstName: ["", Validators.required],
      lastName: ["", Validators.required],
      email: ["", Validators.required],
      password: ["", [Validators.required, Validators.minLength(6)]],
      phone: "",
      cusUrl: "",
    });
    this.panelTitle = "CLIENT REGISTRATION";
    this.successMessage = "";
    // cust
    this.clientService
      .getCustomers()
      .subscribe((data) => (this.customersList = data));

    this.clientService
      .getCustomers()
      .subscribe((data) => (this.customersList = data));
    this.activatedRoute.paramMap.subscribe((parameterMap) => {
      const id = +parameterMap.get("id");
      this.clientService.getCustomer(id);
      this.getCustomer(id);
    });
  }
  // Forms getter
  get f() {
    return this.form.controls;
  }

  public saveCustomer(): void {
    this.submitted = true;
    //  if form is invalid
    if (this.form.invalid) {
      return;
    }
    this.loading = true;
    // if (this.customer.id === null) {  Updating moving to profile

    this.clientService
      .addCustomer(this.form.value)
      .pipe(first())
      .subscribe(
        (data: Customer) => {
          console.log(data);
          this.customer = data;
        },
        (error: any) => {
          console.log("error" + error);
          this.loading = false;
        }
      );

    //  this.registerForm.resetForm();
    this.onRegisterSubmit();
    if (!this.authService.isEmpLoggedIn()) {
      this.router.navigate([""]);
    } else {
      this.router.navigate(["vetLanding"]);
    }
    // } else {
    //   this.clientService.updateCustomer(this.form.value).subscribe(
    //     () => {

    //     },
    //     (error: any) => console.log(error)
    //   );
    //   this.registerForm.reset();
    //   console.log(this.customer);
    //   this.router.navigate(['recLanding']);
    // }
  }

  public getCustomer(id) {
    if (id === 0) {
      this.customer = {
        id: null,
        firstName: "",
        lastName: "",
        phone: "",
        email: "",
        password: "",
        cusUrl: "",
      };
      this.panelTitle = "Client Registration";
      // this.createPetForm.resetForm();
    } else {
      // this.pet = Object.assign({}, this._petService.getPet(id));
      this.clientService.getCustomer(id).subscribe(
        (cust) => (this.customer = cust),
        (err: any) => console.log("create-client.comp:" + err)
      );
      this.panelTitle = "Edit Details";
    }
  }
  public onRegisterSubmit() {
    this.successMessage =
      "Great!, your name: *" +
      this.customer.firstName +
      "*; username/email: *" +
      this.customer.email +
      "* have registered successfully";
  }
  public isPageRegister() {
    return this.isPageRegister;
  }
}
