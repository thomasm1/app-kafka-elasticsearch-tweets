import { Component, OnInit } from "@angular/core";
import { Router  } from "@angular/router";
import {
  FormBuilder,
  FormGroup,
  FormArray,
  Validators,
  NgForm,
} from "@angular/forms";
import { AuthenticationService } from "src/app/services/auth/authentication.service";
import { first } from "rxjs/operators";

@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.css"],
})
export class LoginComponent implements OnInit {
  loading: boolean = false;
  returnUrl: string;
  form: FormGroup;
  submitted = false;

  panelTitle: string;c
  adminLogin: string = "ADMIN LOGIN";
  admin: boolean = false;
  email: string;
  public id: number;
  password: string;
  errorMessage: string = "";
  constructor(
    public authenticationService: AuthenticationService,
    private formBuilder: FormBuilder,
    private router: Router,
  ) {}

  ngOnInit() {
    this.form = this.formBuilder.group({
      email: ['', Validators.required],
      password: ['', Validators.required]});

    this.panelTitle = "CLIENT LOGIN";
    this.logout();
  }

  get f() { return this.form.controls; }

  handleLogin() {
        this.submitted = true;
        if (this.form.invalid) {
          return;
      }
      this.loading = true;
    // EMPLOYEE LOGIN
    if (this.admin) {
      this.authenticationService
        .loginEmp(this.f.email.value, this.f.password.value)
        .pipe(first())
        .subscribe(
          (data) => {
            console.log(data);
            if (data !== null) {
              this.id = this.authenticationService.getEmpId();
              console.log("emp liftoff: " + this.id);
              this.router.navigate([`vetLanding`]);
            } else {
              this.errorMessage = "Oops, wrong email or password!";
              this.router.navigate(["/login"]);
              this.errorReset();
            }
          },
          (error) => {
            console.log("errorLoginWaiting", error);
          }
        );
        this.loading = false;

        // CUSTOMER LOGIN
    } else if (!this.admin) {
      this.authenticationService
        .loginCust(this.f.email.value, this.f.password.value)
        .pipe(first())
        .subscribe(
          (data) => {
            console.log(data);
            if (data !== null) {
              this.id = this.authenticationService.getCustId();
              console.log("cust liftoff: " + this.id);
              this.router.navigate([`clients/${this.id}`]);

            } else {
              this.errorMessage = "Oops, wrong email or password!";
              this.router.navigate(["/login"]);
              this.errorReset();
            }
          },
          (error) => {
            console.log("errorLoginWaiting", error);
          }
        );
        this.loading = false;
    }
  }

  errorReset() {
    setTimeout(() => {
      this.logout();
    }, 2000);
  }

  getId() {
    return this.authenticationService.getCustId();
  }

  adminButton() {
    this.admin = this.admin === true ? false : true;
    this.adminLogin = this.admin === true ? "CLIENT LOGIN" : "ADMIN LOGIN";
    this.panelTitle = this.admin === true ? "ADMINISTRATION" : "CLIENT LOGIN";
  }

  logout() {
    this.authenticationService.logout();
    this.errorMessage = "";
  }
}
