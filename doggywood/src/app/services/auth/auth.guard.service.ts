import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { AuthenticationService } from './authentication.service';

@Injectable({  providedIn: 'root'})
export class AuthGuardService  implements CanActivate  {

  constructor(private authenticationService: AuthenticationService,
    private _router: Router) { }

  canActivate(): boolean {
    if (this.authenticationService.isCustLoggedIn() || this.authenticationService.isEmpLoggedIn()) {
      return true
    } else {
      this._router.navigate(['/login'])
      return false
    }
  }
}
