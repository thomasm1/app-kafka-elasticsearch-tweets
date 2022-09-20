import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuardService } from './services/auth/auth.guard.service';

import { ClientsComponent } from './components/cli/clients/clients.component';
import { LoginComponent } from './components/logins/login/login.component';
import { RegisterComponent } from './components/logins/register/register.component';

import { ProfileComponent } from './components/logins/profile/profile.component';
import { PetCreateComponent } from './components/pet-create/pet-create.component';
import { ApptComponent } from './components/appt/appt.component';
import { ApptCreateComponent } from './components/appt-create/appt-create.component';
import { CliPetProfileComponent } from './components/cli/cli-pet-profile/cli-pet-profile.component';
import { CliPetRecordComponent } from './components/cli/cli-pet-record/cli-pet-record.component';
import { VetLandingComponent } from './components/landing/vet-landing/vet-landing.component';
import { EmpVetLoginComponent } from './components/logins/emp-vet-login/emp-vet-login.component';
import { VetPetProfileComponent } from './components/vet/vet-pet-profile/vet-pet-profile.component';
import { VacCreateComponent } from './components/vac-create/vac-create.component';
import { HomePageComponent } from './components/home-page/home-page.component';

const routes: Routes = [
  { path: '', component: HomePageComponent  },
  { path: 'cliPetProfile/:animalId', component: CliPetProfileComponent, canActivate: [ AuthGuardService ] },
  { path: 'cliPetRecord/:animalId', component: CliPetRecordComponent, canActivate: [ AuthGuardService ] },
  { path: 'register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent },

  { path: 'login', component: LoginComponent},

  // { path: 'clients', component: ClientsComponent },
  { path: 'clients/:id', component: ClientsComponent, canActivate: [ AuthGuardService ]  },
  { path: 'petCreate', component: PetCreateComponent, canActivate: [ AuthGuardService ] },
  { path: 'appt/:apptId', component: ApptComponent, canActivate: [ AuthGuardService ] },
  { path: 'apptCreate', component: ApptCreateComponent, canActivate: [ AuthGuardService ] },

  { path: 'vetLogin', component: EmpVetLoginComponent },
  { path: 'vetLanding', component: VetLandingComponent, canActivate: [ AuthGuardService ] },
  { path: 'vetPetProfile/:animalId', component: VetPetProfileComponent, canActivate: [ AuthGuardService ] },
  { path: 'recordCreate', component: VacCreateComponent , canActivate: [ AuthGuardService ] },

  /* catch-all */
  { path: '*', component: HomePageComponent }
  // { path: 'admin/:userId', component: EmployeesComponent }
  // { path: 'clients/:userId', component: ClientsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
